
package dopeAgile;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    
    private static final ArrayList<Character> playerList = new ArrayList<Character>();

    public static void addPlayer(Character player) {
        playerList.add(player);
    }

    public static Character getSingleCharacter(int index) {
        return playerList.get(index);
    }

    public static ArrayList<Character> getPlayerList() {
        return playerList;
    }

    public static int throwSixSidedDie() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
    
}
