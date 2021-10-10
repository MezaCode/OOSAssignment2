public class PlayWar {

    static int gameType;
    static int roundsToPlay;

    public static void main(String[] args) {
        if (parseArgs(args)) {
            if (gameType == 1) {
                WarWithRecycling warWithRecycling = new WarWithRecycling();
                warWithRecycling.play(roundsToPlay);
            } else if (gameType == 2) {
                WarWithoutRecycling warWithoutRecycling = new WarWithoutRecycling();
                warWithoutRecycling.play();
            }
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
