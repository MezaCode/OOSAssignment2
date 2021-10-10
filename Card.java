import java.util.Arrays;
import java.util.ArrayList;

/**
 * Card.java
 * 
 * @author Gideon Reyes
 * 
 * Card is an object class to represent a playing card. Cannot represent a Joker card.
 */
public class Card {
    private int rank;
    private String suit;
    
    public Card(String suit, int rank){
        ArrayList<String> suits = 
            new ArrayList<>(Arrays.asList(new String[] {"SPADES", "CLUBS", "DIAMONDS", "HEARTS"}));
        try{
            if (!suits.contains(suit))
                throw new Exception(suit + " is not a valid suit.");
        }
        catch (Exception e){
            System.out.println(e);
        }
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString(){
        String card = "";
        card += getCardProperName();
        card += (" of " + suit) ;
        return card;
    }

    /* Accessors */

    public String getSuit(){
        return this.suit;
    }

    public int getRank(){
        return this.rank;
    }

    public String getCardProperName(){
        String properName;
        switch(rank)
        {
            case 2:
                properName = "TWO";
                break;
            case 3:
                properName = "THREE";
                break;
            case 4:
                properName = "FOUR";
                break;
            case 5:
                properName = "FIVE";
                break;
            case 6:
                properName = "SIX";
                break;
            case 7:
                properName = "SEVEN";
                break;
            case 8:
                properName = "EIGHT";
                break;
            case 9:
                properName = "NINE";
                break;
            case 10:
                properName = "TEN";
                break; 
            case 11:
                properName = "JACK";
                break;
            case 12:
                properName = "QUEEN";
                break;
            case 13:
                properName = "KING";
                break;
            case 14:
                properName = "ACE";
                break;    
            default:
                properName = String.valueOf(rank);
                break;
        }
        return properName;
    }
}