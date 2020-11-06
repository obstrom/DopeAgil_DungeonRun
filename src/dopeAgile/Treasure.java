package dopeAgile;

import java.util.concurrent.ThreadLocalRandom;

public class Treasure {
    
    public enum treasureTypes{
       COIN(2),
       MONEYPOUCH(6),
       GOLDJEWELRY(10),
       GEMSTONE(14),
       SMALLCHEST(20);
       
      
                
    }

    public void treasureCreation() {
      /*  final int coinPoints = 2;
        final int moneyPouchPoints = 6;
        final int goldJewelryPoints = 10;
        final int gemStonePoints = 14;
        final int smallChestPoints = 20;
        */
        int spawnCoin = ThreadLocalRandom.current().nextInt(1, 100);
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
