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
      int spawnCoin = 0;
      int spawnMoneyPouch = 0;
      int spawnGoldJewelry = 0;
      int spawnGemstone = 0;
      int spawnSmallChest = 0;
      
        int spawnTreasure = ThreadLocalRandom.current().nextInt(1, 100);
        spawnTreasure = spawnCoin;
        if (spawnCoin <= 40) {
            
        }
        
        //int spawnMoneyPouch = ThreadLocalRandom.current().nextInt(1, 100);
        spawnTreasure = spawnMoneyPouch;
        if (spawnMoneyPouch <= 20) {

        }

        //int spawnGoldJewelry = ThreadLocalRandom.current().nextInt(1, 100);
        spawnTreasure = spawnGoldJewelry;
        if (spawnGoldJewelry <= 15) {

        }
        
        //int spawnGemstone = ThreadLocalRandom.current().nextInt(1, 100);
        spawnTreasure = spawnGemstone;
        if (spawnGemstone <= 10) {

        }
        
        //int spawnSmallChest = ThreadLocalRandom.current().nextInt(1, 100);
        spawnTreasure = spawnSmallChest;
        if (spawnSmallChest <= 5) {

        }

    }

}
