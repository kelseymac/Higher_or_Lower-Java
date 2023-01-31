import java.util.*;

public class Deck {
    private List<Card> deck;
    private List<Card> playPile;

    public Deck() {
        deck = new ArrayList<Card>();

        for (int i = 0; i<=12; i++) {
            //Card(value, suit) - 
            deck.add(new Card(i+1, 1)); // clubs
            deck.add(new Card(i+1, 2)); // heart 
            deck.add(new Card(i+1, 3)); // diamonds
            deck.add(new Card(i+1, 4)); // spades 
        }  
    }

    public void Shuffle() {
       Collections.shuffle(deck); 
    }

    public List<Card> grabPlayPile() {
        Random rand = new Random();
        playPile = new ArrayList<Card>();
        
        for (int i=0; i<4; i++) {
            int size = deck.size();
            Card c = deck.get(size-1);
            playPile.add(c);
            deck.remove(size-1);
        } 

        return playPile;
    }
}
