/**
 * Modifier: Roshan Pansheriya
 * Student Number: 991775609
 * Date Modified: 02-06-2025
 *
 * This class simulates a magic card trick by randomly generating
 * a "hand" of 7 cards and checking whether the user's chosen card
 * or a hard-coded lucky card is in the hand.
 */

import ca.sheridancollege.week3.softwarefundamentals.ice1.Card;
import java.util.Random;

public class CardTrick {
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(suits[random.nextInt(suits.length)]);
            magicHand[i] = c;
        }

        System.out.println("Magic Hand:");
        for (Card c : magicHand) {
            System.out.println(c.getValue() + " of " + c.getSuit());
        }
        
        Card luckyCard = new Card();
        luckyCard.setValue(1);
        luckyCard.setSuit("Spades");

        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() &&
                c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! The lucky card is in the magic hand!");
        } else {
            System.out.println("Sorry! The lucky card was not found in the magic hand.");
        }
    }
}
