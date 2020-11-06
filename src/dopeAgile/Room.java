package dopeAgile;

public class Room {

    private boolean hasMonster = false;
    private boolean hasTreasure = false;
    private boolean isSpawnRoom = false;
    private boolean isEdgeRoom = false;
    private int mapX;
    private int mapY;

    Room(int mapX, int mapY, boolean isEdgeRoom, boolean isSpawnRoom) {
        this.mapX = mapX;
        this.mapY = mapY;
        this.isEdgeRoom = isEdgeRoom;
        this.isSpawnRoom = isSpawnRoom;
        generateMonster();
        generateTreasure();
    }

    private void generateMonster() {
        double rand = Math.random(); // Random number 0.0 -> 1.0
        // Jättespindel = 20%
        // Skelett = 15%
        // Orc = 10%
        // Troll = 5%
        if (rand < 0.5 && !isSpawnRoom) {
            hasMonster = true;
        }
    }

    private void generateTreasure() {
        double rand = Math.random(); // Random number 0.0 -> 1.0
        // Lösa slantar: 2 poäng, 40% chans
        // Pengarpung: 6 poäng, 20% chans
        // Guldsmycken: 10 poäng, 15% chans
        // Ädelsten: 14 poäng, 10% chans
        // Liten skattkista: 20 poäng, 5% chans
        if (rand < 0.9 && !isSpawnRoom) {
            hasTreasure = true;
        }
    }

}
