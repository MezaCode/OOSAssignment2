import java.util.ArrayList;

public class WarUtils {

    public static int rounds;

    public WarUtils(){
        rounds = -1;
    }
    public WarUtils(int numberOfRounds){
        rounds = numberOfRounds;
    }

    public void playRound(ArrayList<Card> masterDeck, Player player1, Player player2)
    {
        player1.card = player1.hand.pop();
        player2.card = player2.hand.pop();
        System.out.println("Player 1 plays " + player1.card.toString());
        System.out.println("Player 2 plays " + player2.card.toString());
        compareCards(player1, player2);
    }

    public void compareCards(Player player1, Player player2){
        if(player1.card.getRank() > player2.card.getRank()){
            player1.pointPile.addLast(player1.card);
            player1.pointPile.addLast(player2.card);
            System.out.println("Player 1 wins the round");
        }
        else if(player1.card.getRank() < player2.card.getRank()){
            player2.pointPile.addLast(player1.card);
            player2.pointPile.addLast(player2.card);  
            System.out.println("Player 2 wins the round");
        }
        else 
            war(player1, player2, false);
    }

    public void initializeWar(Player player1, Player player2, boolean tie){
        if(!tie){
            player1.warDeck = new ArrayList<Card>(); 
            player2.warDeck = new ArrayList<Card>();
            player1.warDeck.add(player1.card);
            player2.warDeck.add(player2.card);
        }
        for(int x=0; x<2; x++){ 
            if(player1.hand.size() == 0 || player2.hand.size() == 0 )
                gameOver(player1, player2);
            player1.warDeck.add(player1.hand.pop());
            player2.warDeck.add(player2.hand.pop());                  
        }
    }

    public void war(Player player1, Player player2, boolean tie){
        System.out.println("*** WAR! ***"); 
        initializeWar(player1, player2, tie);
        compareWarCards(player1, player2);
    }

    public void compareWarCards(Player player1, Player player2){
        int player1WarDeckSize = player1.warDeck.size();
        int player2WarDeckSize = player2.warDeck.size();
        if(player1WarDeckSize >= 3 && player2WarDeckSize >= 3 ){
            System.out.println("War card for player1 is " + player1.warDeck.get(player1WarDeckSize-1).toString());
            System.out.println("War card for player2 is " + player2.warDeck.get(player2WarDeckSize-1).toString());
            if(player1.warDeck.get(player1WarDeckSize-1).getRank() > player2.warDeck.get(player2WarDeckSize-1).getRank()){
                player1.pointPile.addAll(player1.warDeck);
                player1.pointPile.addAll(player2.warDeck);
                System.out.println("Player 1 wins the war round");
            }
            else if(player2.warDeck.get(player2WarDeckSize-1).getRank() > player1.warDeck.get(player1WarDeckSize-1).getRank()){
                player2.pointPile.addAll(player1.warDeck);
                player2.pointPile.addAll(player2.warDeck);
                System.out.println("Player 2 wins the war round");
            }
            else
                war(player1, player2, true);
        }
    }

    public void checkForGameOver(Player player1, Player player2){
        if(player2.hand.size() == 0 || player1.hand.size() == 0 || 
            player1.pointPile.size() >= 26 || player2.pointPile.size() >= 26)
            gameOver(player1, player2);
    }

    public void checkForGameOver(Player player1, Player player2, int roundsPlayed){
        if(player2.hand.size() == 0 || player1.hand.size() == 0 || roundsPlayed == rounds)
            gameOver(player1, player2);
    }

    public void gameOver(Player player1, Player player2){
        printScore(player1, player2);
        System.out.println("GAME OVER");
        if(player2.pointPile.size() == player1.pointPile.size())
            System.out.println("IT'S A TIE!");
        else{
            String player = player1.pointPile.size() > player2.pointPile.size() ? "Player 1" : "Player 2";
            System.out.println(player + " wins the game!");
        }
        System.exit(0);
    }
    public void printScore(Player player1, Player player2){
        System.out.println("Player 1 score: " + player1.pointPile.size());
        System.out.println("Player 2 score: " + player2.pointPile.size());
    }
}