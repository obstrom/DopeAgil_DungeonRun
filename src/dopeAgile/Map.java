package dopeAgile;

// TODO:
//  - getters
//  - Print map view
//  - Create pick spawn point
//  - Generate room content
//  - Room hasMonster boolean
//  - Room hasTreasure boolean

public class Map {
    private final mapSize currentMapSize;
    private final Room[][] mapArray;
    private int[] spawnPointXYCoordinates;
    private Room spawnRoom;

    Map (mapSize sizeEnum, spawnCardinal spawnCardinal) {
        this.currentMapSize = sizeEnum;
        mapArray = createMapArray(sizeEnum.getSize());
        spawnPointXYCoordinates = calcSpawnPointCoordinates(spawnCardinal);
    }

    public enum mapSize {
        SMALL(4),
        MEDIUM(5),
        LARGE(8);

        private final int size;

        mapSize(final int newSize) {
            size = newSize;
        }

        int getSize() {
            return this.size;
        }
    }

    public enum spawnCardinal {
        NW, NE, SW, SE;
    }

    private Room[][] createMapArray(int size) {
        Room[][] mapArray = new Room[size][size];
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                mapArray[i][j] = new Room();
            }
        }
        return mapArray;
    }

    private int[] calcSpawnPointCoordinates(spawnCardinal spawnCardinal) {
        int[] returnInt = new int[] {0, 0};
        switch (spawnCardinal) {
            case NE:
                returnInt[1] = currentMapSize.getSize();
                break;
            case SE:
                returnInt[0] = currentMapSize.getSize();
                returnInt[1] = currentMapSize.getSize();
                break;
            case SW:
                returnInt[0] = currentMapSize.getSize();
                break;
        }
        return returnInt;
    }

    public Room getRoomFromArray(int x, int y) {
        Room returnObject = null;

        try {
            returnObject = mapArray[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        return returnObject;
    }

}
