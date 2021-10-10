import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class WarWithoutRecycling extends WarType{

    public static ArrayList<Card> masterDeck;
    public static Player player1;
    public static Player player2;

    public WarWithoutRecycling()
    {
        initialize();
    }

    public void initialize()
    {
        masterDeck = new Deck().getDeckOfCards();
        Collections.shuffle(masterDeck, new Random());
        player1 = new Player("Player 1", masterDeck.subList(0, 26));
        player2 = new Player("Player 2", masterDeck.subList(26, masterDeck.size()));
        player1.pointPile = new LinkedList<Card>();
        player2.pointPile = new LinkedList<Card>();
    }

    public void play()
    {
        WarUtils warUtils = new WarUtils();
        while(true){
            warUtils.printScore(player1, player2);
            warUtils.playRound(masterDeck, player1, player2);
            warUtils.checkForGameOver(player1, player2);
        } 
    }
}
