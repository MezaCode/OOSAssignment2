import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * WarWithoutRecycling.java
 *
 * @author Gideon Reyes
 *
 * WarWithoutRecycling is an implementation of the card game "War". It implements a different set of rules
 * than the original rules of "War" by placing won cards in a separate points pile. Cards are not recycled.
 * The game ends after the players use the cards that were initially dealt to them. The winner is the
 * player with the most cards in his/her points pile at the end of the game.
 */
public class WarWithoutRecycling extends WarType{

    public static ArrayList<Card> masterDeck;
    public static Player player1;
    public static Player player2;

    public WarWithoutRecycling(){
        initialize();
    }

    private void initialize(){
        masterDeck = new Deck().getDeckOfCards();
        Collections.shuffle(masterDeck, new Random());
        player1 = new Player("Player 1", masterDeck.subList(0, 26));
        player2 = new Player("Player 2", masterDeck.subList(26, masterDeck.size()));
    }

    /**
     * Starts the game of "War"
     */
    public void play(){
        WarUtils warUtils = new WarUtils();
        while(true){
            warUtils.printScore(player1, player2);
            warUtils.playRound(masterDeck, player1, player2);
            warUtils.checkForGameOver(player1, player2);
        } 
    }
}
