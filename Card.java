public class Card {
    // Attributes 
    private int suit;
    private String colour;
    private int value;

    // Constructors 
    public Card() {
       this.suit = 1 ;
       this.value = 1 ;
    }

    public Card(int value, int suit)  {
       this.suit = suit; 
       this.colour = getColour();
       this.value = value; 
    }

    // Methods
    public String getSuit() {
        String s = "";
        
         switch(this.suit) {
            case 1:
                s = "club";
                break;
            case 2:
                s = "heart";
                break;
            case 3:
                s = "diamond";
                break;
            case 4:
                s = "spade";
                break;
        }
        return s;        
    }
    
    public String getColour() {
        if (this.suit == 1 || this.suit == 4) {
            return "black" ;
        }
        return "red";
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        String name = "";
        switch(this.value) {
            case 1:
                name = "A";
                break;
            case 11:
                name = "J";
                break;
            case 12:
                name = "Q";
                break;
            case 13:
                name = "K";
                break;
            default:
                name = Integer.toString(this.value);
                break;
        }
        
         switch(this.suit) {
            case 1:
                name += (char)'\u2663'; // club
                break;
            case 2:
                name += (char)'\u2665'; // heart
                break;
            case 3:
                name += (char)'\u2666'; // diamond
                break;
            case 4:
                name += (char)'\u2660'; // spade
                break;
        }

         return name;
    }
}
