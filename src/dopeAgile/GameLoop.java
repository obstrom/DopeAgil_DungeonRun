package dopeAgile;

public class GameLoop {
    private Map loadedMap;
    private Character loadedCharacter;

    GameLoop(Map loadedMap, Character loadedCharacter) {
        this.loadedMap = loadedMap;
        this.loadedCharacter = loadedCharacter;
        loop();
    }

    public static void loop() {

    }

}
