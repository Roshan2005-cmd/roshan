package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and checks if a user-entered card is present in the hand.
 * 
 * @author dancye
 * @modifier Roshan Pansheriya, Student# 991775609 - June 1, 2025
 */
public class CardTrick {

    public static void main(String[] args) {

        Card[] magicHand = new Card[7];
        Random rand = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);
            c.setSuit(Card.SUITS[rand.nextInt(4)]);
            magicHand[i] = c;
        }

        // Ask user for their card
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of your card (1 to 13): ");
        int userValue = input.nextInt();
        input.nextLine(); // consume newline
        System.out.print("Enter the suit of your card (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = input.nextLine();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() &&
                card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Your card was found in the magic hand!");
        } else {
            System.out.println("Your card was NOT found in the magic hand.");
        }

        System.out.println("\nCards in the magic hand:");
        for (Card card : magicHand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        System.out.println("\nYour Card: " + userCard.getValue() + " of " + userCard.getSuit());
    }
}