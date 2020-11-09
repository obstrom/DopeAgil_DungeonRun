package dopeAgile;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLoop {
    private final Map loadedMap;
    private Character loadedCharacter;
    private Room currentRoom;
    private int loopIteration = 0;

    GameLoop(Map loadedMap, Character loadedCharacter) {
        this.loadedMap = loadedMap;
        this.loadedCharacter = loadedCharacter;
        loop();
    }

    public void loop() {
        Boolean keepGoing = true;
        while (keepGoing) {

            keepGoing = navigation();

            ++loopIteration;
        }
    }

    public boolean navigation() {
        // DEBUG CODE
        /*System.out.println("This room X = " + currentRoom.getMapX() + ", Y = " + currentRoom.getMapY());
        System.out.println("This room is an edge room? " + currentRoom.isEdgeRoom());
        System.out.println("Try to display adjacent rooms:");
        HashMap<Map.cardinalDirection, Room> allAdjacentRooms = currentRoom.getAdjacentRooms();
        for (java.util.Map.Entry<Map.cardinalDirection, Room> entry: allAdjacentRooms.entrySet()) {
            System.out.println(entry.getKey() + ": (" + entry.getValue().getMapX() + ", " + entry.getValue().getMapY() + ")");
        }*/

        // Get the current room of player, if this is
        // the first iteration it will get the spawn room
        currentRoom = loadedMap.getPlayerCurrentRoom();

        System.out.println(loadedMap.toString(true));
        System.out.println("\n\033[1m-*-*-*-*-*-*-*-*-*-*-\033[0m");
        System.out.println("\033[1m -- Välj riktning -- \033[0m");
        System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-\033[0m");
        Map.cardinalDirection chosenDirection = getDirectionFromUser();

        if (chosenDirection == Map.cardinalDirection.LEAVE) {
            System.out.println("ÄVENTYRET ÄR SLUT (PLACEHOLDER!)");
            return false;
        }

        // Set current room as explored
        currentRoom.setIsRoomExplored(true);

        // Move to target room and update values
        currentRoom = currentRoom.getSpecificAdjacentRoom(chosenDirection);
        loadedMap.setPlayerCurrentRoom(currentRoom);

        return true;
    }

    public Map.cardinalDirection getDirectionFromUser() {
        Map.cardinalDirection returnDirection = null;

        ArrayList<Map.cardinalDirection> menuOptions = new ArrayList<Map.cardinalDirection>();
        for (java.util.Map.Entry<Map.cardinalDirection, Room> entry: currentRoom.getAdjacentRooms().entrySet()) {
            menuOptions.add(entry.getKey());
        }

        if (currentRoom.isEdgeRoom()) {
            menuOptions.add(Map.cardinalDirection.LEAVE);
        }

        for (int i = 0; i < menuOptions.size(); i++) {
            if (menuOptions.get(i) == Map.cardinalDirection.LEAVE) {
                System.out.println(i+1 + ". Lämna dungeon och avsluta äventyret (SPARA).");
            } else {
                System.out.println(i+1 + ". Gå mot " + menuOptions.get(i).toString().toLowerCase() + ".");
            }
        }

        Map.cardinalDirection chosenDirection = null;
        for (int i = 0; i < 1; i++) {
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine().toLowerCase();

            try {
                int userInputInt = Integer.parseInt(userInput);
                returnDirection = menuOptions.get(userInputInt-1);
            } catch (NumberFormatException e) {
                if (menuOptions.toString().toLowerCase().contains(userInput)) {
                    for (Map.cardinalDirection direction: menuOptions) {
                        if (direction.toString().toLowerCase().contains(userInput)) {
                            returnDirection = direction;
                        }
                    }
                } else {
                    System.out.println("Ogiltigt kommando! Försök igen.");
                    --i;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ogiltigt kommando! Försök igen.");
                --i;
            }

        }

        return returnDirection;
    }

}
