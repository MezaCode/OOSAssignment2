import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Player 
{
    public String name;
    public LinkedList<Card> hand;
    public LinkedList<Card> pointPile;
    public ArrayList<Card> warDeck;
    public Card card;
    public int points;

    Player(String name, List<Card> deck)
    {
        this.name = name;
        this.hand = new LinkedList<Card>();
        this.hand.addAll(deck);
        pointPile = new LinkedList<Card>();
        points = 0;
    }

    public int getHandSize()
    {
        return this.hand.size();
    }

    public String getName()
    {
        return this.name;
    }

    public void addToPointPile(ArrayList<Card> wonCards)
    {
        pointPile.addAll(wonCards);
    }

    public void addToHand(ArrayList<Card> wonCards)
    {
        for (Card card : wonCards)
            hand.addLast(card);
    }

    public int getPointPileSize()
    {
        return pointPile.size();
    }
}
