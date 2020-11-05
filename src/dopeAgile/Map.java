package dopeAgile;

public class Map {
    private mapSize mapSize;

    Map(mapSize sizeEnum) {
        createMap(sizeEnum.getSize());
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

    public void createMap(int size) {
        Room[][] mapArray = new Room[size][size];
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                mapArray[i][j] = new Room();
            }
        }
    }
}
