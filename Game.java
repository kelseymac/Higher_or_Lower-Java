import java.util.*;
public class Game {
    public static void main(String[] args) {
        Mechanics m = new Mechanics();
        // Start game with Introduction
        boolean displayRules = m.Introduction();
         if (displayRules) {
            m.Rules();
         }
        // Create Deck
        Deck deck = new Deck();
        // Shuffle Deck
        deck.Shuffle();
        // Grab 4 cards for play pile
        List<Card> playPile = deck.grabPlayPile();
        
        // Begin Game

        // First Round Guess Colour 
        // grab card from play pile
        int size = playPile.size();
        Card c = playPile.get(size-1);
        boolean guess = m.guessColour(c); 
        m.getPoints(guess, 1, c); // colour guess is 1 point
        playPile.remove(size-1);
        

        // Second Round Guess Higher or Lower
        // grab card from play pile
        size = playPile.size();
        Card c2 = playPile.get(size-1);
        guess = m.guessHighLow(c, c2); 
        m.getPoints(guess , 3, c2); // higher or lower guess is 3 points
        playPile.remove(size-1);


        // Third Round Guess in between or outside of last two cards
        // grab card from play pile
        size = playPile.size();
        Card c3 = playPile.get(size-1);
        guess = m.guessBetweenOutside(c, c2, c3); 
        m.getPoints(guess , 5, c3); // between or outside guess is 5 point
        playPile.remove(size-1);
        
        // Finaly Round Guess in Suit 
        // grab card from play pile
        size = playPile.size();
        Card c4 = playPile.get(size-1);
        guess = m.guessSuit(c4); 
        m.getPoints(guess , 10, c4); // suit is 10 point
    }
}
