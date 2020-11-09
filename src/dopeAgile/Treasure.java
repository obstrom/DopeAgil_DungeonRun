package dopeAgile;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Treasure {

    ArrayList<treasureTypes> treasureList = new ArrayList<>();
    
    public enum treasureTypes{
       COIN(2) {
           @Override
           public String toString() {
               return "småmynt";
           }
       },
       MONEYPOUCH(6) {
           @Override
           public String toString() {
               return "en pengapung";
           }
       },
       GOLDJEWELRY(10) {
           @Override
           public String toString() {
               return "ett guldsmycke";
           }
       },
       GEMSTONE(14) {
           @Override
           public String toString() {
               return "en ädelsten";
           }
       },
       SMALLCHEST(20) {
           @Override
           public String toString() {
               return "en liten skattkista";
           }
       };
       
       treasureTypes(int value){
           this.value = value;
       }

       private int value;

       public int getValue() {
            return value;
        }

    }

    Treasure() {

        int spawnCoin = ThreadLocalRandom.current().nextInt(1, 100);
        if (spawnCoin <= 40) {
            treasureList.add(treasureTypes.COIN);
        }
        
        int spawnMoneyPouch = ThreadLocalRandom.current().nextInt(1, 100);
        if (spawnMoneyPouch <= 20) {
            treasureList.add(treasureTypes.MONEYPOUCH);
        }

        int spawnGoldJewelry = ThreadLocalRandom.current().nextInt(1, 100);
        if (spawnGoldJewelry <= 15) {
            treasureList.add(treasureTypes.GOLDJEWELRY);
        }
        
        int spawnGemstone = ThreadLocalRandom.current().nextInt(1, 100);
        if (spawnGemstone <= 10) {
            treasureList.add(treasureTypes.GEMSTONE);
        }
        
        int spawnSmallChest = ThreadLocalRandom.current().nextInt(1, 100);
        if (spawnSmallChest <= 5) {
            treasureList.add(treasureTypes.SMALLCHEST);
        }
        
    }

    public ArrayList<treasureTypes> getTreasureList() {
        return treasureList;
    }

    public int getTreasureTotalValue() {
        int totalScore = 0;
        for (treasureTypes type: treasureList) {
            totalScore += type.getValue();
        }
        return totalScore;
    }

    public void clearTreasureList() {
        treasureList = null;
    }
    
}
