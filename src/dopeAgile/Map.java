package dopeAgile;

// TODO:
//  - getters
//  - Create pick spawn point
//  - Generate room content
//  - Room hasMonster boolean
//  - Room hasTreasure boolean

public class Map {
    private final mapSize currentMapSize;
    private final Room[][] mapArray;

    Map (mapSize sizeEnum) {
        this.currentMapSize = sizeEnum;
        mapArray = createMapArray(sizeEnum.getSize());
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

    private Room[][] createMapArray(int size) {
        Room[][] mapArray = new Room[size][size];
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                mapArray[i][j] = new Room();
            }
        }
        return mapArray;
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
                result += "[x]";
                
            }
          result += "\n";  
        }
        System.out.println(result);
    }

}
