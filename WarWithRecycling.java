import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * WarWithRecycling.java
 * 
 * @author Gideon Reyes
 * 
 * WarWithRecycling is an implementation of the card game "War". It implements the original rules of "War" 
 * by recycling won cards at the bottom of the player's hand. The game ends as soon as one of the following 
 * conditions is met: a) one player has won all of the cards, or 2) a predetermined number of rounds has 
 * been played. The winner is the player with the most cards at the end of the game.
 */
public class WarWithRecycling {
    public static ArrayList<Card> masterDeck;
    public static Player player1;
    public static Player player2;

    public WarWithRecycling(){
        initialize();
    }

    private void initialize(){
        masterDeck = new Deck().getDeckOfCards();
        Collections.shuffle(masterDeck, new Random());
        player1 = new Player("Player 1", masterDeck.subList(0, 26));
        player2 = new Player("Player 2", masterDeck.subList(26, masterDeck.size()));
        player1.pointPile.addAll(player1.hand);
        player2.pointPile.addAll(player2.hand);
    }

    /**
     * Starts the game of "War"
     * 
     * @param rounds Number of rounds to play
     */
    public void play(int rounds){
        WarUtils warUtils = new WarUtils(rounds);
        int roundsPlayed = 0;
        while(true){
            warUtils.printScore(player1, player2);
            clearPointPiles(player1, player2);
            warUtils.playRound(masterDeck, player1, player2);
            roundsPlayed++;
            addPointsPileToHand(player1, player2);
            clearPointPiles(player1, player2);
            addHandToPointsPile(player1, player2);
            warUtils.checkForGameOver(player1, player2, roundsPlayed);
        } 
    }

    private void clearPointPiles(Player player1, Player player2){
        player1.pointPile.clear();
        player2.pointPile.clear();
    }

    private void addHandToPointsPile(Player player1, Player player2){
        player1.pointPile.addAll(player1.hand);
        player2.pointPile.addAll(player2.hand);
    }

    private void addPointsPileToHand(Player player1, Player player2){
        player1.hand.addAll(player1.pointPile);
        player2.hand.addAll(player2.pointPile);
    }
}
