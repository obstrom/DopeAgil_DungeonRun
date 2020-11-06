package dopeAgile;

import java.util.HashMap;

public class GameLoop {
    private Map loadedMap;
    private Character loadedCharacter;
    private Room currentRoom;
    private int loopIteration = 0;

    GameLoop(Map loadedMap, Character loadedCharacter) {
        this.loadedMap = loadedMap;
        this.loadedCharacter = loadedCharacter;
        loop();
    }

    public void loop() {
        while (true) {
            if (loopIteration == 0) {
                currentRoom = loadedMap.getSpawnRoom();
            }
            navigation();
            break; // Remove when exit map is implemented
        }
    }

    public void navigation() {
        System.out.println("This room X = " + currentRoom.getMapX() + ", Y = " + currentRoom.getMapY());
        System.out.println("This room is an edge room? " + currentRoom.isEdgeRoom());
        System.out.println("Try to display adjacent rooms:");
        HashMap<Map.cardinalDirection, Room> allAdjacentRooms = currentRoom.getAdjacentRooms();
        for (java.util.Map.Entry<Map.cardinalDirection, Room> entry: allAdjacentRooms.entrySet()) {
            System.out.println(entry.getKey() + ": (" + entry.getValue().getMapX() + ", " + entry.getValue().getMapY() + ")");
        }
    }

}
