
package dopeAgile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Score {
    //Key == scores, Value == players
    //set the key on the map to the points of the character 
    //value as the game player. That way I can keep scores as values that are easily retrievable.
    
    HashMap<String, List<Integer>> mapScores = new HashMap<>();

    public Score(){
        
    }
    
    public void addScore(String name, int score) {
        List<Integer> scoresBoard = mapScores.getOrDefault(name, new ArrayList<>()); //returns empty arrayList if name is not found
        scoresBoard.add(score);// 
        mapScores.put(name,scoresBoard);
        System.out.println("END SCORES: " + mapScores);
    }
   
}
