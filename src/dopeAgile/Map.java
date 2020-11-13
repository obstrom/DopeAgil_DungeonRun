package dopeAgile;

public class Map {

    private final mapSize currentMapSize;
    private final Room[][] mapArray; // [y][x]
    private int[] playerPositionXYCoordinates;
    private Room playerCurrentRoom;

    public mapSize getCurrentMapSize() {
        return currentMapSize;
    }

    public Room[][] getMapArray() {
        return mapArray;
    }

    Map(mapSize sizeEnum, cardinalDirection spawnCardinal) {
        this.currentMapSize = sizeEnum;
        playerPositionXYCoordinates = calcSpawnPointCoordinates(spawnCardinal);
        mapArray = createMapArray(sizeEnum.getSize());
        calcAdjacentRooms();
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

    public enum cardinalDirection {
        N {
            @Override
            public String toString() {
                return "Norr";
            }
        },
        W {
            @Override
            public String toString() {
                return "Väst";
            }
        },
        S {
            @Override
            public String toString() {
                return "Söder";
            }
        },
        E {
            @Override
            public String toString() {
                return "Öst";
            }
        }, NW, NE, SW, SE, LEAVE;
    }

    private Room[][] createMapArray(int size) {
        Room[][] mapArray = new Room[size][size];
        for (int y = 0; y < mapArray.length; y++) {
            for (int x = 0; x < mapArray[y].length; x++) {
                boolean isEdge = (y == 0 || x == 0 || y == (mapArray.length - 1) || x == (mapArray.length - 1));
                if (y == playerPositionXYCoordinates[0] && x == playerPositionXYCoordinates[1]) {
                    Room newRoom = new Room(x, y, isEdge, true);
                    mapArray[y][x] = newRoom;
                    this.playerCurrentRoom = newRoom;
                } else {
                    mapArray[y][x] = new Room(x, y, isEdge, false);
                }
            }
        }
        return mapArray;
    }

    private void calcAdjacentRooms() {
        for (Room[] mapRowArray : mapArray) {
            for (Room thisRoom : mapRowArray) {
                int xPos = thisRoom.getMapX();
                int yPos = thisRoom.getMapY();

                // Try to add north room
                if (getRoomFromArray(xPos, yPos - 1) != null) {
                    thisRoom.addAdjacentRoom(cardinalDirection.N, getRoomFromArray(xPos, yPos - 1));
                }
                // Try to add east room
                if (getRoomFromArray(xPos + 1, yPos) != null) {
                    thisRoom.addAdjacentRoom(cardinalDirection.E, getRoomFromArray(xPos + 1, yPos));
                }
                // Try to add south room
                if (getRoomFromArray(xPos, yPos + 1) != null) {
                    thisRoom.addAdjacentRoom(cardinalDirection.S, getRoomFromArray(xPos, yPos + 1));
                }
                // Try to add west room
                if (getRoomFromArray(xPos - 1, yPos) != null) {
                    thisRoom.addAdjacentRoom(cardinalDirection.W, getRoomFromArray(xPos - 1, yPos));
                }
            }
        }
    }

    private int[] calcSpawnPointCoordinates(cardinalDirection spawnCardinal) {
        int[] returnInt = new int[]{0, 0};
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
        try {
            return mapArray[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public String toString(boolean showLegend) {
        String result = "";
        for (Room[] roomRows : mapArray) {
            for (Room room : roomRows) {
                if (playerCurrentRoom == room) {
                    result += "[\u001B[32m*\u001B[0m]";
                } else if (room.getIsRoomExplored()) {
                    result += "[ ]";
                } else {
                    result += "[\u001B[34m?\u001B[0m]";
                }
            }
            result += "\n";
        }

        if (showLegend) {
            result += "\n[\u001B[32m*\u001B[0m] = Din position | [\u001B[34m?\u001B[0m] = Obesökt rum\n[ ] = Besökt rum | [\u001B[31m!\u001B[0m] = Rum med monster";
        }

        return result;
    }

    public Room getPlayerCurrentRoom() {
        if (this.playerCurrentRoom == null) {
            int x = playerPositionXYCoordinates[0];
            int y = playerPositionXYCoordinates[1];
            return getRoomFromArray(x, y);
        } else {
            return this.playerCurrentRoom;
        }
    }

    public void setPlayerCurrentRoom(Room room) {
        playerCurrentRoom = room;
    }

    public void setPlayerCurrentRoom() {
        int x = playerPositionXYCoordinates[0];
        int y = playerPositionXYCoordinates[1];
        playerCurrentRoom = getRoomFromArray(y, x);
    }

    public void setPlayerPositionXYCoordinates(int x, int y) {
        playerPositionXYCoordinates[0] = y;
        playerPositionXYCoordinates[1] = x;
    }

}
