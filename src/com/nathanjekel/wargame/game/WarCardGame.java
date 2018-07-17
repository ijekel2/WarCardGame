package com.nathanjekel.wargame.game;

import java.util.LinkedList;

import com.nathanjekel.wargame.cards.WarCard;
import com.nathanjekel.wargame.cards.WarCardDeck;
import com.nathanjekel.wargame.messages.Messages;

public class WarCardGame {

	private WarCardDeck deck = new WarCardDeck();
	private LinkedList<WarCard> userHand = new LinkedList<>();
	private LinkedList<WarCard> computerHand = new LinkedList<>();
	private boolean hasWinner = false;

	public void play() {
		Messages.printWelcomeMessage();
		shuffle();
		deal();
		while (!hasWinner) {
			playTrick();
		}
	}

	public void shuffle() {
		Messages.printShuffleMessage();
		deck.shuffle();
	}

	public void deal() {
		Messages.printDealingMessage();
		while (!deck.isEmpty()) {
			computerHand.addFirst(deck.draw());
			userHand.addFirst(deck.draw());
		}
	}

	public void playTrick() {
		LinkedList<WarCard> pot = new LinkedList<>();
		flip(pot);

	}

	private void flip(LinkedList<WarCard> pot) {

		// Each player flips a card
		WarCard userCard = userHand.poll();
		WarCard computerCard = computerHand.poll();

		Messages.printFlipMessage(userCard, computerCard);

		// Add the flipped cards to the pot
		pot.addLast(userCard);
		pot.addLast(computerCard);

		// Check if the trick has a winner
		if (computerCard.getGameValue() > userCard.getGameValue()) {
			computerHand.addAll(pot);
			Messages.printLostTrickMessage();
			Messages.printHandSizes(userHand.size(), computerHand.size());
			checkForWinner();
			return;
		}

		if (userCard.getGameValue() > computerCard.getGameValue()) {
			userHand.addAll(pot);
			Messages.printWonTrickMessage();
			Messages.printHandSizes(userHand.size(), computerHand.size());
			checkForWinner();
			return;
		}

		// A tie has occurred and now there as a "war"
		Messages.printWarMessage();

		// Each player plays one card face down
		pot.addLast(userHand.pollFirst());
		pot.addLast(computerHand.pollFirst());
		checkForWinner();

		// Players flip cards again
		flip(pot);

	}

	private void checkForWinner() {
		if (computerHand.isEmpty()) {
			hasWinner = true;
			boolean userIsWinner = true;
			Messages.printEndGameMessage(userIsWinner);
		} else if (userHand.isEmpty()) {
			hasWinner = true;
			boolean userIsWinner = false;
			Messages.printEndGameMessage(userIsWinner);
		}
	}

}
