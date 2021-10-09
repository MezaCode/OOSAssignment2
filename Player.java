import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Player {
    String name;
    LinkedList<Card> hand;
    ArrayList<Card> pointPile;
    ArrayList<Card> faceUpCards;
    ArrayList<Card> faceDownCards;
    int points;

    Player(String name, List<Card> deck){
        this.name = name;
        this.hand = new LinkedList<Card>();
        this.hand.addAll(deck);
        pointPile = new ArrayList<Card>();
        faceDownCards = new ArrayList<Card>();
        faceUpCards = new ArrayList<Card>();
        points = 0;
    }
//todo: change wins method to not calc points
    public void wins(int points){
        System.out.println(this.name + " wins the round");
        System.out.println( this.name +" has a score of " + points);

        clearWarCards();
    }

    public void clearWarCards(){
        if (this.faceUpCards.size() > 0){
            this.faceUpCards.clear();
        }
        if (this.faceDownCards.size() > 0){
            this.faceDownCards.clear();
        }
    }
    //todo: change loses method to not calc points
    public void loses(int points){
        System.out.println( this.name +" has a score of " + points);
        clearWarCards();
    }

    public void drawWarCards(){
        this.faceDownCards.add(this.hand.pop());
        this.faceUpCards.add(this.hand.pop());
    }

    public Card getRoundCard(){
        return this.hand.pop();
    }

    public ArrayList<Card> getFaceDownCards() {
        return faceDownCards;
    }

    public ArrayList<Card> getFaceUpCards() {
        return faceUpCards;
    }

    public int getHandSize(){
        return this.hand.size();
    }

    public void warTie(Card roundCard){
        for (Card card : faceDownCards){
            hand.addLast(card);
        }
        for (Card card : faceUpCards){
            hand.addLast(card);
        }
        hand.addLast(roundCard);
    }

    public String getName(){
        return this.name;
    }

    public void addToPointPile(ArrayList<Card> wonCards){
        pointPile.addAll(wonCards);
    }

    public void addToHand(ArrayList<Card> wonCards){
        for (Card card : wonCards){
            hand.addLast(card);
        }
    }
    public int getPointPileSize(){
        return pointPile.size();
    }



}
