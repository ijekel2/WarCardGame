package com.nathanjekel.wargame.messages;

import java.io.IOException;

import com.nathanjekel.wargame.cards.WarCard;

public class Messages {

	public static void printWelcomeMessage() {
		System.out.println("Welcome to War!");
		insertPause(500);
		System.out.println("Press Enter to play...");
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Goodbye!");
			System.exit(0);
		}
	}

	public static void printShuffleMessage() {
		System.out.println("Shuffling deck...");
		insertPause(1000);
	}

	public static void printDealingMessage() {
		System.out.println("Dealing Cards...");
		insertPause(1000);

	}

	public static void printFlipMessage(WarCard userCard, WarCard computerCard) {
		System.out.println("\nPress Enter to flip the next card...");
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Invalid Input");
		}

		System.out.println("You played: " + userCard.getFaceValue() + " of " + userCard.getSuit());
		insertPause(500);
		System.out.println("Your opponent played: " + computerCard.getFaceValue() + " of " + computerCard.getSuit());
		insertPause(500);

	}

	public static void printWarMessage() {
		System.out.println("War ensues!");
		insertPause(500);
		System.out.println("You each place one card face down.");
		insertPause(500);

	}

	public static void printLostTrickMessage() {
		System.out.println("Your opponent won the trick.\n");
		insertPause(500);

	}

	public static void printWonTrickMessage() {
		System.out.println("You won the trick.\n");
		insertPause(500);

	}

	public static void printHandSizes(int userHandSize, int computerHandSize) {
		System.out.println("Your deck: " + userHandSize + " cards");
		System.out.println("Opponent's deck: " + computerHandSize + " cards");
		insertPause(500);
	}

	public static void printEndGameMessage(boolean userIsWinner) {
		if (userIsWinner) {
			System.out.println("Congratulations! You've won the game!");
		} else {
			System.out.println("You've lost the game. Please try again.");
		}
		System.exit(0);
	}

	private static void insertPause(int length) {
		try {
			Thread.sleep(length);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
