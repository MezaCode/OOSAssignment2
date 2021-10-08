import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class WarWithoutRecycling {
    ArrayList<Card> masterDeck;
    LinkedList<Card> player1Deck;
    LinkedList<Card> player2Deck;
    ArrayList<Card> player1PointPile;
    ArrayList<Card> player2PointPile;
    ArrayList<Card> player1FaceUpCards;
    ArrayList<Card> player2FaceUpCards;
    ArrayList<Card> player1FaceDownCards;
    ArrayList<Card> player2FaceDownCards;

    public WarWithoutRecycling() {
        initializeDecks();
    }

    public void initializeDecks(){
        this.masterDeck = new Deck().getDeckOfCards();
        Collections.shuffle(this.masterDeck);
        this.player1Deck = new LinkedList<Card>();
        this.player2Deck = new LinkedList<Card>();
        this.player1Deck.addAll(masterDeck.subList(0,25));
        this.player2Deck.addAll(masterDeck.subList(26,masterDeck.size()));
        this.player1PointPile = new ArrayList<Card>();
        this.player2PointPile = new ArrayList<Card>();
        this.player1FaceDownCards = new ArrayList<Card>();
        this.player1FaceUpCards = new ArrayList<Card>();
        this.player2FaceDownCards = new ArrayList<Card>();
        this.player2FaceUpCards = new ArrayList<Card>();
    }

    public Card getCard(int player){
        Card playerCard;
        if (player == 1){
            playerCard = player1Deck.pop();
        }
        else{
            playerCard = player2Deck.pop();
        }
        return playerCard;
    }

    public void roundWinner( int player, ArrayList<Card> roundsCards){
        if (player == 1){
            player1PointPile.addAll(roundsCards);
            System.out.println("PLayer 1 wins the round");
        }
        else{
            player2PointPile.addAll(roundsCards);
            System.out.println("PLayer 2 wins the round");
        }

        System.out.println("Player 1 has a score of " + player1PointPile.size());
        System.out.println("Player 2 has a score of " + player2PointPile.size());
    }

    public void war(Card player1Card, Card player2Card){
        boolean winnerNotFound = true;
        int warRound = 0;
        ArrayList<Card> warRoundCards = new ArrayList<Card>();
        while (winnerNotFound){
            getWarCards();

            if (player1FaceUpCards.get(warRound).getRank() > player2FaceUpCards.get(warRound).getRank()){
                winnerNotFound = false;
                warRoundCards.addAll(getWarWinnerCards(player1Card, player2Card));
                roundWinner(1, warRoundCards);
            }
            else if (player1FaceUpCards.get(warRound).getRank() < player2FaceUpCards.get(warRound).getRank()){
                winnerNotFound = false;
                warRoundCards.addAll(getWarWinnerCards(player1Card, player2Card));
                roundWinner(2, warRoundCards);
            }
            else if (player1Deck.size() <=1 || player2Deck.size() <=1){
                //Todo: figure out which unofficial rule to use for 1 or less cards remaining in a player's deck
            }
            else { warRound++;}
        }
    }
    public void getWarCards(){
        player1FaceDownCards.add(player1Deck.pop());
        player1FaceUpCards.add(player1Deck.pop());
        player2FaceDownCards.add(player2Deck.pop());
        player2FaceUpCards.add(player2Deck.pop());
    }
    public ArrayList<Card> getWarWinnerCards(Card player1Card, Card player2Card){
        ArrayList<Card> warWinnings = new ArrayList<Card>();
        warWinnings.addAll(player1FaceUpCards);
        warWinnings.addAll(player1FaceDownCards);
        warWinnings.addAll(player2FaceUpCards);
        warWinnings.addAll(player2FaceDownCards);
        warWinnings.add(player1Card);
        warWinnings.add(player2Card);
        return warWinnings;
    }

}

//-------------------------------Done------------------------------------------------
//Todo: constructor
// Todo: method to initialize decks and player decks and discard deck for each player
// Todo: method to grab cards for each player
// Todo: method to handle winner of round
// Todo: methods to handle war
//-------------------------------Still need to do------------------------------------------------
// Todo: method to check who wins round or war
