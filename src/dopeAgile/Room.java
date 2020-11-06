package dopeAgile;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private boolean hasMonster = false;
    private boolean hasTreasure = false;
    private boolean isSpawnRoom = false;
    private boolean isEdgeRoom = false;
    private boolean isRoomExplored = false;
    private HashMap<Map.cardinalDirection, Room> adjacentRooms = new HashMap<Map.cardinalDirection, Room>();
    private int mapX;
    private int mapY;

    Room (int mapX, int mapY, boolean isEdgeRoom, boolean isSpawnRoom) {
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

    public boolean getIsRoomExplored() {
        return isRoomExplored;
    }

    public HashMap<Map.cardinalDirection, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public Room getSpecificAdjacentRoom(Map.cardinalDirection direction) {
        return adjacentRooms.get(direction);
    }

    public void addAdjacentRoom(Map.cardinalDirection direction, Room room) {
        adjacentRooms.put(direction, room);
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public boolean isEdgeRoom() {
        return isEdgeRoom;
    }
}
