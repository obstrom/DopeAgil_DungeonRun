package dopeAgile;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private boolean isSpawnRoom = false;
    private boolean isEdgeRoom = false;
    private boolean isRoomExplored = false;
    private Treasure roomTreasure = new Treasure();
    private ArrayList<Monster> roomMonsters;
    private HashMap<Map.cardinalDirection, Room> adjacentRooms = new HashMap<Map.cardinalDirection, Room>();
    private String roomMessage;
    private int mapX;
    private int mapY;

    Room(int mapX, int mapY, boolean isEdgeRoom, boolean isSpawnRoom) {
        this.mapX = mapX;
        this.mapY = mapY;
        this.isEdgeRoom = isEdgeRoom;
        this.isSpawnRoom = isSpawnRoom;
        if (isSpawnRoom) {
            clearTreasure();
        }
        roomMonsters = generateMonster();
        roomMessage = generateRoomMessage();
    }

    private ArrayList<Monster> generateMonster() {
        ArrayList<Monster> monsterList = new ArrayList<Monster>();

        double spawnOrc = Math.random();
        if (spawnOrc <= Orc.getCommon()) {
            monsterList.add(new Orc());
        }

        double spawnSkeleton = Math.random();
        if (spawnSkeleton <= Skeleton.getCommon()) {
            monsterList.add(new Skeleton());
        }

        double spawnSpider = Math.random();
        if (spawnSpider <= Spider.getCommon()) {
            monsterList.add(new Spider());
        }

        double spawnTroll = Math.random();
        if (spawnTroll <= Troll.getCommon()) {
            monsterList.add(new Troll());
        }

        return monsterList;
    }

    private String generateRoomMessage() {
        int rand = (int) (Math.random() * 10);
        String returnString;

        switch (rand) {
            case 1:
                returnString = "Du kommer in i ett mörkt rum upplyst av faklor. I rummet ser du burar som innehåller skelett. Dem hänger livslöst i burarna.";
                break;
            case 2:
                returnString = "Du kommer in matsal som ser övergiven ut. Du ser bestik och tallrikar slängda över golvet som om de vore lämnade i språng.";
                break;
            case 3:
                returnString = "Du kommer in i ett rum täckt av blod och livlösa kroppar- likmaskar kravlar över dem. Du känner en rysning som om att alla livlösa kroppar skriker ut.";
                break;
            case 4:
                returnString = "Du kommer in i ett mörkt rum fyllt med rutten mat och verktyg av olika slag, det ser övergivet ut.";
                break;
            case 5:
                returnString = "Du kommer in ett rum fyllt med lik av olika raser, det ser ut som det varit en strid. Alla liken är beväpnade med svärd och spikklubbor.";
                break;
            case 6:
                returnString = "Du kommer in i ett mörkt blött rum täckt av mossa det droppar vatten från tacket.";
                break;
            case 7:
                returnString = "Du kommer in i ett rum fyllt med vapen av olika slag. Det ser ut som något slags vapenförråd- alla vapen ser förfallna ut.";
                break;
            case 8:
                returnString = "Du kommer in ett rum som ser ut som ett mötesrum, du ser kartor utslängda över borden med schack liknade pjäser på dem.";
                break;
            case 9:
                returnString = "Du kommer in i ett mörkt rum upplyst av vaxljus, på marken ser du röda pentagram täckt av blod, som om det har skett blodoffringar här.";
                break;
            case 0:
                returnString = "Du kommer in rum med sängar täckta av damm som om att det inte har använts på många år.";
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

    public String getRoomMessage() {
        return roomMessage;
    }

    public boolean isSpawnRoom() {
        return isSpawnRoom;
    }

    public ArrayList<Monster> getRoomMonsters() {
        return roomMonsters;
    }
}
