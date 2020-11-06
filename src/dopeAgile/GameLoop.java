package dopeAgile;

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



            break; // Remove when exit map is implemented
        }
    }

}
