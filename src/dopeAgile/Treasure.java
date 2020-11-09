package dopeAgile;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Treasure {
    
    public enum treasureTypes{
       COIN(2),
       MONEYPOUCH(6),
       GOLDJEWELRY(10),
       GEMSTONE(14),
       SMALLCHEST(20);
       
       treasureTypes(int value){
           this.value = value;
           
       }
       private int value;

        public int getValue() {
            return value;
        }
        
       
      
                
    }

    public void treasureCreation() {
        
       ArrayList<Treasure> treasure = new ArrayList<>();
      
        int spawnCoin= ThreadLocalRandom.current().nextInt(1, 100);
       
        if (spawnCoin <= 40) {
            
        }
        
        int spawnMoneyPouch = ThreadLocalRandom.current().nextInt(1, 100);
      
        if (spawnMoneyPouch <= 20) {

        }

        int spawnGoldJewelry = ThreadLocalRandom.current().nextInt(1, 100);
        
        if (spawnGoldJewelry <= 15) {

        }
        
        int spawnGemstone = ThreadLocalRandom.current().nextInt(1, 100);
       
        if (spawnGemstone <= 10) {

        }
        
        int spawnSmallChest = ThreadLocalRandom.current().nextInt(1, 100);
    
        if (spawnSmallChest <= 5) {

        }
        
    }
    
}
