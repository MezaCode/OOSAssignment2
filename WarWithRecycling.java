import java.util.ArrayList;     
import java.util.List;          
import java.util.Collections;   
import java.util.LinkedList;    

public class WarWithRecycling 
{
    public static void main(String[] args) 
    {
        ArrayList<Card> masterDeck = new Deck().getDeckOfCards();

        Collections.shuffle(masterDeck);

        LinkedList<Card> player1Deck = new LinkedList<Card>();
        LinkedList<Card> player2Deck = new LinkedList<Card>();
        
        player1Deck.addAll(masterDeck.subList(0, 25));      
        player2Deck.addAll(masterDeck.subList(26, masterDeck.size()));
        
        while(true)
        {
            Card player1Card = player1Deck.pop();
            Card player2Card = player2Deck.pop();
            
            System.out.println("Player 1 plays " + player1Card.toString());
            System.out.println("Player 2 plays " + player2Card.toString());
            
            if(player1Card.getRank() > player2Card.getRank())
            {
                player1Deck.addLast(player1Card);
                player1Deck.addLast(player2Card);
                System.out.println("PLayer 1 wins the round");
            }
 
            else if(player1Card.getRank() < player2Card.getRank())
            {
                player2Deck.addLast(player1Card);   
                player2Deck.addLast(player2Card);  
                System.out.println("PLayer 2 wins the round");
            }
            
            else 
            {
                System.out.println("*** WAR! ***"); 
                
                //creating war cards
                List<Card> player1WarDeck = new ArrayList<Card>(); 
                List<Card> player2WarDeck = new ArrayList<Card>();
                
                for(int x=0; x<3; x++)
                { 
                    if(player1Deck.size() == 0 || player2Deck.size() == 0 )
                        break;
                    
                    System.out.println("War card for player1 is xx.");
                    System.out.println("War card for player2 is xx.");

                    player1WarDeck.add(player1Deck.pop());
                    player2WarDeck.add(player2Deck.pop());                  
                }

                if(player1WarDeck.size() == 3 && player2WarDeck.size() == 3 )
                {
                    System.out.println("War card for player1 is " + player1WarDeck.get(0).toString());
                    System.out.println("War card for player2 is " + player2WarDeck.get(0).toString());
                    
                    if(player1WarDeck.get(2).getRank() > player2WarDeck.get(2).getRank())
                    {
                        player1Deck.addAll(player1WarDeck); //player1 get all 10 cards
                        player1Deck.addAll(player2WarDeck);
                        System.out.println("Player 1 wins the war round");
                    }
                    
                    else
                    {
                        player2Deck.addAll(player1WarDeck);
                        player2Deck.addAll(player2WarDeck);
                        System.out.println("Player 2 wins the war round");
                    }                     
                }
                
            }
            
            if(player1Deck.size() == 0 )
            {
                System.out.println("GAME OVER");
                System.out.println("Player 1 wins the game!");
                break;
            }

            else if(player2Deck.size() == 0)
            {
                System.out.println("GAME OVER");
                System.out.println("Player 2 wins the game!");
                break;
            }
        } 

    }    
}
