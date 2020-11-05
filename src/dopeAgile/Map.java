package dopeAgile;

public class Map {
    private final mapSize currentMapSize;
    private final Room[][] mapArray;
    private int[] spawnPointXYCoordinates;
    private Room spawnRoom;

    public mapSize getCurrentMapSize() {
        return currentMapSize;
    }

    public Room[][] getMapArray() {
        return mapArray;
    }

    Map (mapSize sizeEnum, spawnCardinal spawnCardinal) {
        this.currentMapSize = sizeEnum;
        spawnPointXYCoordinates = calcSpawnPointCoordinates(spawnCardinal);
        mapArray = createMapArray(sizeEnum.getSize());
    }

    public static enum mapSize {
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

    public static enum spawnCardinal {
        NW, NE, SW, SE;
    }

    private Room[][] createMapArray(int size) {
        Room[][] mapArray = new Room[size][size];
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                if (i == spawnPointXYCoordinates[0] && j == spawnPointXYCoordinates[1]) {
                    Room newRoom = new Room(true);
                    mapArray[i][j] = newRoom;
                    this.spawnRoom = newRoom;
                } else {
                    mapArray[i][j] = new Room(false);
                }
            }
        }
        return mapArray;
    }

    private int[] calcSpawnPointCoordinates(spawnCardinal spawnCardinal) {
        int[] returnInt = new int[] {0, 0};
        switch (spawnCardinal) {
            case NE:
                returnInt[1] = currentMapSize.getSize() - 1;
                break;
            case SE:
                returnInt[0] = currentMapSize.getSize() - 1;
                returnInt[1] = currentMapSize.getSize() - 1;
                break;
            case SW:
                returnInt[0] = currentMapSize.getSize() - 1;
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
    
    public void mapPrint(){
        String result = "";
        for (Room[] roomRows : mapArray) {
            for (Room room : roomRows) {
                if (room == getSpawnRoom()) {
                    result += "[O]";
                } else {
                    result += "[ ]";
                }
            }
          result += "\n";  
        }
        System.out.println("[O] = Spawnpunkt");
        System.out.println("[ ] = Obesökt rum\n");
        System.out.println(result);
    }

    public Room getSpawnRoom() {
        if (this.spawnRoom == null) {
            int x = spawnPointXYCoordinates[0];
            int y = spawnPointXYCoordinates[1];
            return getRoomFromArray(x, y);
        } else {
            return this.spawnRoom;
        }
    }

}
