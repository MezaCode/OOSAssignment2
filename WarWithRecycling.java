import java.util.ArrayList;     
import java.util.List;          
import java.util.Collections;   
import java.util.LinkedList;  
import java.util.Random;  

public class WarWithRecycling 
{
    private static int rounds;
    private static ArrayList<Card> masterDeck;
    private static LinkedList<Card> player1Deck;
    private static LinkedList<Card> player2Deck;
    private static List<Card> player1WarDeck; 
    private static List<Card> player2WarDeck;

    public WarWithRecycling(int numberOfRounds)
    {
        rounds = numberOfRounds;
        initialize();
    }

    private static void initialize()
    {
        masterDeck = new Deck().getDeckOfCards();
        Collections.shuffle(masterDeck, new Random());
        player1Deck = new LinkedList<Card>();
        player2Deck = new LinkedList<Card>();
        player1Deck.addAll(masterDeck.subList(0, 26));      
        player2Deck.addAll(masterDeck.subList(26, masterDeck.size()));
    }

    public void play()
    {
        int roundsPlayed = 0;
        while(true)
        {
            printScore();
            playRound();
            roundsPlayed++;
            checkForGameOver(roundsPlayed);
        } 
    }

    private static void playRound()
    {
        Card player1Card = player1Deck.pop();
        Card player2Card = player2Deck.pop();
        System.out.println("Player 1 plays " + player1Card.toString());
        System.out.println("Player 2 plays " + player2Card.toString());
        compareCards(player1Card, player2Card);
    }

    private static void compareCards(Card player1Card, Card player2Card)
    {
        if(player1Card.getRank() > player2Card.getRank())
        {
            player1Deck.addLast(player1Card);
            player1Deck.addLast(player2Card);
            System.out.println("Player 1 wins the round");
        }
        else if(player1Card.getRank() < player2Card.getRank())
        {
            player2Deck.addLast(player1Card);   
            player2Deck.addLast(player2Card);  
            System.out.println("Player 2 wins the round");
        }
        else 
            war(player1Card, player2Card, false);
    }

    private static void initializeWar(Card player1Card, Card player2Card, boolean tie)
    {
        if(!tie)
        {
            player1WarDeck = new ArrayList<Card>(); 
            player2WarDeck = new ArrayList<Card>();
            player1WarDeck.add(player1Card);
            player2WarDeck.add(player2Card);
        }
        for(int x=0; x<2; x++)
        { 
            if(player1Deck.size() == 0 || player2Deck.size() == 0 )
                break;
            player1WarDeck.add(player1Deck.pop());
            player2WarDeck.add(player2Deck.pop());                  
        }
    }

    private static void war(Card player1Card, Card player2Card, boolean tie)
    {
        System.out.println("*** WAR! ***"); 
        initializeWar(player1Card, player2Card, tie);
        compareWarCards();
    }

    private static void compareWarCards()
    {
        int player1WarDeckSize = player1WarDeck.size();
        int player2WarDeckSize = player2WarDeck.size();
        if(player1WarDeckSize >= 3 && player2WarDeckSize >= 3 )
        {
            System.out.println("War card for player1 is " + player1WarDeck.get(player1WarDeckSize-1).toString());
            System.out.println("War card for player2 is " + player2WarDeck.get(player2WarDeckSize-1).toString());
            
            if(player1WarDeck.get(player1WarDeckSize-1).getRank() > player2WarDeck.get(player2WarDeckSize-1).getRank())
            {
                player1Deck.addAll(player1WarDeck);
                player1Deck.addAll(player2WarDeck);
                System.out.println("Player 1 wins the war round");
            }
            else if(player2WarDeck.get(player2WarDeckSize-1).getRank() > player1WarDeck.get(player1WarDeckSize-1).getRank())
            {
                player2Deck.addAll(player1WarDeck);
                player2Deck.addAll(player2WarDeck);
                System.out.println("Player 2 wins the war round");
            }
            else
                war(player1WarDeck.get(0), player2WarDeck.get(0), true);
        }
    }

    private static void checkForGameOver(int roundsPlayed)
    {
        if(player2Deck.size() == 0 || player1Deck.size() == 0 || roundsPlayed == rounds)
            gameOver();
    }

    private static void gameOver()
    {
        printScore();
        System.out.println("GAME OVER");
        if(player2Deck.size() == player1Deck.size())
            System.out.println("IT'S A TIE!");
        else
        {
            String player = player1Deck.size() > player2Deck.size() ? "Player 1" : "Player 2";
            System.out.println(player + " wins the game!");
        }
        System.exit(0);
    }
    private static void printScore()
    {
        System.out.println("Player 1 score: " + player1Deck.size());
        System.out.println("Player 2 score: " + player2Deck.size());
    }
}
