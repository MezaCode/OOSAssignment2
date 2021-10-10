/**
 * PlayWar.java
 * 
 * @author Mazen Shaban
 * 
 * PlayWar is a controller class for the implementation of the card game "War". Picks a version
 * of "War" to play based on command line arguments.
 */
public class PlayWar {
    public static void main(String[] args) {
        WarWithRecycling warWithRecycling = new WarWithRecycling();
        warWithRecycling.play(50);

        //WarWithoutRecycling warWithoutRecycling = new WarWithoutRecycling();
        //warWithoutRecycling.play();
    }
}
