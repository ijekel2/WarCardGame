package com.nathanjekel.wargame.cards;

public class WarCard {

	private CardSuit suit;
	private CardValue faceValue;
	private int gameValue;
	
	
	public WarCard(CardSuit suit, CardValue value) {
		this.suit = suit;
		this.faceValue = value;
		this.gameValue = faceValue.ordinal() + 2;
	}
	
	public int getGameValue() {
		return gameValue;
	}
	
	public String getFaceValue() {
		return faceValue.name();
	}
	
	public String getSuit() {
		return suit.name();
	}
}
