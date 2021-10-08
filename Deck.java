import java.util.ArrayList;

public class Deck 
{
    private static ArrayList<Card> deckOfCards;

    public Deck()
    {
        initializeDeck();
    }

    private void initializeDeck()
    {
        deckOfCards = new ArrayList<>();
        String[] suits = new String[] {"SPADES", "CLUBS", "DIAMONDS", "HEARTS"};

        int i = 0;
        for (String suit : suits)
        {
            for (i = 2; i < 15; i++)
                deckOfCards.add(new Card(suit, i));
        }
    }

    /* Accessor */
    public ArrayList<Card> getDeckOfCards()
    {
        return deckOfCards;
    }
}
