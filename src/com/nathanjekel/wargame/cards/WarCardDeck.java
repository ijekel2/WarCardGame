package com.nathanjekel.wargame.cards;

import java.util.Collections;
import java.util.Stack;

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
		Collections.shuffle(deck);
    }

	public WarCard draw() {
		return deck.pop();
	}

	public boolean isEmpty() {
		return deck.isEmpty();
	}
}
