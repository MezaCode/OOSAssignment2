import java.util.ArrayList;
import java.util.Collections;

public class WarWithoutRecycling {
    ArrayList<Card> masterDeck;
    Player player1;
    Player player2;
    int warRound;

    public WarWithoutRecycling() {
        warRound = -1; // -1 to indicate it's outside of war round
        initializeDecks();
    }

    public void initializeDecks(){
        this.masterDeck = new Deck().getDeckOfCards();
        Collections.shuffle(this.masterDeck);
        this.player1 = new Player("Player 1",masterDeck.subList(0,25));
        this.player2 = new Player("Player 2",masterDeck.subList(26,masterDeck.size()));
    }

    public void playRound(){
        if (player1.getHandSize() == 0 || player2.getHandSize() == 0){
            endGame();
        }
        Card player1Card = player1.getRoundCard();
        Card player2Card = player2.getRoundCard();

        if (player1Card.getRank() > player2Card.getRank()){
            roundEnd( player1, player2, player1Card, player2Card);
        }
        else if (player1Card.getRank() < player2Card.getRank()){
            roundEnd( player2, player1, player1Card, player2Card);
        }
        else {
            System.out.println("*** WAR! ***");
            war(player1Card, player2Card);
        }
    }
// todo: roundEnd method needs to be changed for polymorphism
    //change addToPointPile method into addToHand method
    public void roundEnd( Player winner, Player loser, Card player1Card, Card player2Card){
        winner.addToPointPile(getWinnerCards(player1Card, player2Card));
        winner.wins(winner.getPointPileSize());
        loser.loses(loser.getPointPileSize());
    }

    public void war(Card player1Card, Card player2Card){
        boolean winnerNotFound = checkWarAble(player1Card, player2Card);
        warRound = 0;
        ArrayList<Card> warRoundCards = new ArrayList<Card>();
        while (winnerNotFound){
            getWarCards();
            if (player1.getFaceUpCards().get(warRound).getRank() > player2.getFaceUpCards().get(warRound).getRank()){
                winnerNotFound = false;
                roundEnd( player1, player2, player1Card, player2Card);
            }
            else if (player1.getFaceUpCards().get(warRound).getRank() < player2.getFaceUpCards().get(warRound).getRank()){
                winnerNotFound = false;
                roundEnd( player2, player1, player1Card, player2Card);
            }
            else {
                winnerNotFound = checkWarAble(player1Card, player2Card);
                warRound++;
            }
        }
    }

    public boolean checkWarAble(Card player1Card, Card player2Card){
        if (player1.getHandSize() <=1  && player2.getHandSize() <=1 ){
            player1.warTie(player1Card);
            player2.warTie(player2Card);
            System.out.println("Both Players unable to continue War, Cards have been returned to bottom of deck");
            return false;
        }
        else if (player1.getHandSize() <=1){
            System.out.println("Player 1 unable to continue War");
            roundEnd( player2, player1, player1Card, player2Card);
            return false;
        }
        else if (player2.getHandSize() <=1){
            System.out.println("Player 2 unable to continue War");
            roundEnd( player1, player2, player1Card, player2Card);
            return false;
        }
        else { return true;}
    }

    public void getWarCards(){
        player1.drawWarCards();
        player2.drawWarCards();
    }
    public ArrayList<Card> getWinnerCards(Card player1Card, Card player2Card){
        ArrayList<Card> winnings = new ArrayList<Card>();
        if (warRound >= 0) {
            winnings.addAll(player1.getFaceUpCards());
            winnings.addAll(player1.getFaceDownCards());
            winnings.addAll(player2.getFaceUpCards());
            winnings.addAll(player2.getFaceDownCards());
            warRound = -1;
        }
        winnings.add(player1Card);
        winnings.add(player2Card);
        return winnings;
    }
    // todo: change endGame method for polymorphism
    // change getPointPileSize method to getHandSize method
    public void endGame(){
        System.out.println("*** GAME OVER ***");
        if (player1.getPointPileSize() > player2.getPointPileSize()){
            System.out.println(player1.getName() + " WINS THE GAME!");
        }
        else if (player1.getPointPileSize() < player2.getPointPileSize()){
            System.out.println(player2.getName() + " WINS THE GAME!");
        }
        else{ System.out.println("*** TIE GAME ***");}

        System.out.println(player1.getName() +" has a score of " + player1.getPointPileSize());
        System.out.println(player1.getName() +" has a score of " + player1.getPointPileSize());
        System.exit(0);
    }

}
