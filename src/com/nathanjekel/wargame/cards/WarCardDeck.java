package com.nathanjekel.wargame.cards;

import java.util.Collections;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class WarCardDeck {

	Stack<WarCard> deck = new Stack<>();

	//
	// Initializer to fill deck with values.
	{
		for (CardSuit suit : CardSuit.values()) {
			for (CardValue value : CardValue.values()) {
				WarCard card = new WarCard(suit, value);
				deck.push(card);
			}
		}
	}

	public void shuffle() {
		int randomNum = ThreadLocalRandom.current().nextInt(3, 6);
		for (int i = 0; i < randomNum; i++) {
			Collections.shuffle(deck);

		}
	}

	public WarCard draw() {
		return deck.pop();
	}

	public boolean isEmpty() {
		return deck.isEmpty();
	}
}
