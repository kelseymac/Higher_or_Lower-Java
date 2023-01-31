import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Mechanics {

    private int dealer_score;
    private int player_score;

    protected boolean Introduction() {
        System.out.println("Hello, my name is Tibolt. I will be your Dealer today.");
        System.out.println("Would you like to hear the rules?");

        String resp = "";
        Scanner scanObj = new Scanner(System.in);
        while (!resp.equalsIgnoreCase("no")) {
            resp = scanObj.nextLine();
            if (resp.equalsIgnoreCase("yes")) {
                return true;
            }
            else if (!resp.equalsIgnoreCase("no")) {
                System.out.println("please type yes or no.");
            }
        }
        return false;
    }

    protected void Rules() {
        System.out.println("This is a card game, and it will be against you and me.");
        System.out.println("I will draw 4 cards and separate them from the rest of the deck");
        System.out.println("You will then have four chances to earn points when you answer correctly");
        System.out.println("and each decision is ranked differently.");
        System.out.println("Also to note...ace will be considered with the value of 1");
        System.out.println("First, I will ask you what colour the card will be. (1 point)");
        System.out.println("Second, you will choose if the next card's value");
        System.out.println("will be higher or lower than the first card. (3 points)");
        System.out.println("Third, you will choose if the card will be in between");
        System.out.println("or outside of the first two card's values. If you guess in between,");
        System.out.println("then the card must be either equal to or clearly in between the two card's values.");
        System.out.println("If you choose outside, they must be clearly outside of the two cards' values (5 points)");
        System.out.println("Lastly, you will try to guess the suit of the card. (10 point)");
    }

    protected void getPoints(boolean isCorrect, int pointsRewarded, Card card) {
        System.out.println("The card was " + card.getName());
        if (isCorrect) {
            System.out.println("You are correct.");
            player_score += pointsRewarded;
        }
        else {
            System.out.println("You are incorrect.");
            dealer_score += pointsRewarded;
        }
        System.out.println("Here is the current score...");
        System.out.println("Dealer: " + dealer_score);
        System.out.println("Player: " + player_score);
    }

    protected boolean guessColour(Card c) {
        System.out.println("Is this card red or black?");
        String resp = "";
        Scanner scanObj = new Scanner(System.in);
        while (!resp.equalsIgnoreCase("red") == false && !resp.equalsIgnoreCase("black") == false || resp == "") {
            resp = scanObj.nextLine();
            if (resp.equalsIgnoreCase("black") && c.getColour().equalsIgnoreCase("black")) {
                return true;
            }
            else if (resp.equalsIgnoreCase("red") && c.getColour().equalsIgnoreCase("red")) {
                return true;
            }
            else if (!resp.equalsIgnoreCase("red") == false && !resp.equalsIgnoreCase("black") == false) {
                System.out.println("please type red or black.");
            }
        }
        return false;
    }

    protected boolean guessHighLow(Card c1, Card cToGuess) {
        System.out.println("Is this card Higher or Lower than " + c1.getName() + "?");
        String resp = "";
        Scanner scanObj = new Scanner(System.in);
        while (!resp.equalsIgnoreCase("higher") && !resp.equalsIgnoreCase("lower") || resp == "") {
            resp = scanObj.nextLine();
            if (resp.equalsIgnoreCase("higher") && cToGuess.getValue() > c1.getValue()) {
                return true;
            }

            else if (resp.equalsIgnoreCase("lower") && cToGuess.getValue() <= c1.getValue()) {
                return true;
            }
            else if (!resp.equalsIgnoreCase("higher") && !resp.equalsIgnoreCase("lower")) {
                System.out.println("please type higher or lower.");
            }
        }
        return false;
    }

    protected boolean guessBetweenOutside(Card c1, Card c2, Card cToGuess) {
        System.out.println("Is this card inside or outside of " + c1.getName() + " and " + c2.getName() + "?");
        String resp = "";
        Scanner scanObj = new Scanner(System.in);
        int largerValueCard = c1.getValue() > c2.getValue() ? c1.getValue() : c2.getValue();
        int lesserValueCard = c1.getValue() <= c2.getValue() ? c1.getValue() : c2.getValue();

        int cToGuessValue = cToGuess.getValue();
        
        while (!resp.equalsIgnoreCase("inside") && !resp.equalsIgnoreCase("outside") || resp == "") {
            resp = scanObj.nextLine();
            if (resp.equalsIgnoreCase("inside") && cToGuessValue >= lesserValueCard  && cToGuessValue <= largerValueCard) {
                return true;
            }

            else if (resp.equalsIgnoreCase("outside") && cToGuessValue < lesserValueCard || cToGuessValue > largerValueCard) {
                return true;
            }
            else if (!resp.equalsIgnoreCase("outside") && !resp.equalsIgnoreCase("inside")) {
                System.out.println("please type outside or inside.");
            }
        }
        return false;
    }

    protected boolean guessSuit (Card cToGuess) {
        System.out.println("What is the last card's suit?");
        String resp = "";
        Scanner scanObj = new Scanner(System.in);
        
        String cToGuessSuit = cToGuess.getSuit();

        while (!resp.equalsIgnoreCase("spade") && !resp.equalsIgnoreCase("club") 
               && !resp.equalsIgnoreCase("heart") && !resp.equalsIgnoreCase("diamond") || resp == "") 
        {
            resp = scanObj.nextLine();
            if (resp.equalsIgnoreCase("spade") && cToGuessSuit.equalsIgnoreCase("spade")) {
                return true;
            }
            else if (resp.equalsIgnoreCase("club") && cToGuessSuit.equalsIgnoreCase("club")) {
                return true;
            }
            else if (resp.equalsIgnoreCase("heart") && cToGuessSuit.equalsIgnoreCase("heart")) {
                return true;
            }
            else if (resp.equalsIgnoreCase("diamond") && cToGuessSuit.equalsIgnoreCase("diamond")) {
                return true;
            }
            else if (!resp.equalsIgnoreCase("spade") && !resp.equalsIgnoreCase("club") 
                     && !resp.equalsIgnoreCase("heart") && !resp.equalsIgnoreCase("diamond")) {
                System.out.println("please type spade, club, heart or diamond.");
            }
        }
        return false;
    }

    protected String Winner() {
        if (dealer_score > player_score) return "I am the winner. Better luck next time!";
        else if (dealer_score < player_score) return "You Won! Congratulations!";
        else return "It looks like it's a draw!";
    }
}
