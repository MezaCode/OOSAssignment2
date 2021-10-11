/**
 * PlayWar.java
 *
 * @author Mazen Shaban
 *
 * PlayWar is a controller class for the implementation of the card game "War". Picks a version
 * of "War" to play based on command line arguments.
 */
public class PlayWar {

    static int gameType;
    public static int roundsToPlay;
    public static WarType warType;

    public static void main(String[] args) {
        if (parseArgs(args)) {
            if (gameType == 1) {
                warType = new WarWithRecycling();
            } else if (gameType == 2) {
                warType = new WarWithoutRecycling();
            }
            else {
                System.out.println("Error: Game Type Unknown! \nPlease chose 1 for War With Recycling and 2 for War Without Recycling! ");
                System.exit(1);
            }
            warType.play();
        }
        else { System.exit(1);}
    }

    public static boolean parseArgs(String[] args){
        boolean parseSuccess = true;
        try {
            gameType = Integer.parseInt(args[0]);
        } catch (Exception e){
            System.out.println("Error: First Argument not an integer!");
            parseSuccess = false;
        }
        if (parseSuccess && gameType == 1){
            try{
                roundsToPlay = Integer.parseInt(args[1]);
            } catch(Exception e){
                System.out.println("Error: Option 1 requires second argument of type int!");
                parseSuccess = false;
            }
        }
        return parseSuccess;
    }
}
