package dopeAgile;

import java.util.HashMap;

public class Room {

    private boolean hasMonster = false;
    private boolean isSpawnRoom = false;
    private boolean isEdgeRoom = false;
    private boolean isRoomExplored = false;
    private Treasure roomTreasure = new Treasure();
    private HashMap<Map.cardinalDirection, Room> adjacentRooms = new HashMap<Map.cardinalDirection, Room>();
    private String roomMessage;
    private int mapX;
    private int mapY;

    Room (int mapX, int mapY, boolean isEdgeRoom, boolean isSpawnRoom) {
        this.mapX = mapX;
        this.mapY = mapY;
        this.isEdgeRoom = isEdgeRoom;
        this.isSpawnRoom = isSpawnRoom;
        if (isSpawnRoom) {
            clearTreasure();
        }
        generateMonster();
        roomMessage = generateRoomMessage();
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

    private String generateRoomMessage() {
        int rand = (int) (Math.random()*10);
        String returnString;

        switch (rand) {
            case 1:
                returnString = "Du kommer in i ett mörkt rum upplyst utav faklor i rummet ser du burar. i burarna ser du skellet som håller i bur stängerna helt livlösa.";
                break;
            case 2:
                returnString = "Du kommer in matsal som ser övergiven ut. du ser bestik och tallrikar slängda över golvet som om det var lämnat i språng.";
                break;
            case 3:
                returnString = "Du kommer in i rum täckt utav blod och livlösa kroppar täckt utav larver. Du känner en rysning som om att alla livlösa kroppar skriker ut.";
                break;
            case 4:
                returnString = "Du kommer in mörkt rum fyllt med rutten mat och verktyg av olika slag, det ser övergivet ut.";
                break;
            case 5:
                returnString = "Du kommer in ett rum fyllt med lik av olika raser, det ser ut som det varit en strid alla lik beväpnade med svärd och spikklubbor.";
                break;
            case 6:
                returnString = "Du kommer in i ett mörkt blött rum täckt utav mossa det droppar vatten från tacket.";
                break;
            case 7:
                returnString = "Du kommer in i ett rum fyllt av vapen av olika slag ser ut som någots slags vapenförråd, alla vapena ser förfallna ut.";
                break;
            case 8:
                returnString = "Du kommer in ett rum som ser ut som ett mötesrum, du ser kartor utläggna över borden med schack liknade pjäser på dem.";
                break;
            case 9:
                returnString = "Du kommer mörkt rum upplysta av ljus, på marken ser du röda pentagram täckta utav blod som om det har skett blodoffringar här.";
                break;
            case 0:
                returnString = "Du kommer in rum med massa sängar täckta utav damm som om att det inte har använts på många år.";
                break;
            default:
                returnString = null;
                break;
        }
        return returnString;
    }

    public boolean getIsRoomExplored() {
        return isRoomExplored;
    }

    public void setIsRoomExplored(boolean isExplored) {
        isRoomExplored = isExplored;
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

    public Treasure getRoomTreasure() {
        return roomTreasure;
    }

    public void clearTreasure() {
        roomTreasure.clearTreasureList();
    }
}
