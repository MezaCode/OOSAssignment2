import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WarWithRecycling {

    public static ArrayList<Card> masterDeck;
    public static Player player1;
    public static Player player2;

    public WarWithRecycling()
    {
        initialize();
    }

    public void initialize()
    {
        masterDeck = new Deck().getDeckOfCards();
        Collections.shuffle(masterDeck, new Random());
        player1 = new Player("Player 1", masterDeck.subList(0, 26));
        player2 = new Player("Player 2", masterDeck.subList(26, masterDeck.size()));
        player1.pointPile = player1.hand;
        player2.pointPile = player2.hand;
    }

    public void play(int rounds)
    {
        WarUtils warUtils = new WarUtils(rounds);
        int roundsPlayed = 0;
        while(true){
            warUtils.printScore(player1, player2);
            warUtils.playRound(masterDeck, player1, player2);
            roundsPlayed++;
            warUtils.checkForGameOver(player1, player2, roundsPlayed);
            player1.hand.addAll(player1.pointPile);
            player2.hand.addAll(player2.pointPile);
        } 
    }
}
