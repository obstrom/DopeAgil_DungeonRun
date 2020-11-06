
package dopeAgile;

import java.util.ArrayList;

public class Utility {
    
    private static final ArrayList<Character> playerList = new ArrayList<Character>();

    public static void addPlayer(Character player) {
        playerList.add(player);
    }

    public static Character getPlayer(int index) {
        return playerList.get(index);
    }
    
}
