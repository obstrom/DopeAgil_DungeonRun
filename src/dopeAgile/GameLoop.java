package dopeAgile;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLoop {
    private final Map loadedMap;
    private Character loadedCharacter;
    private Room currentRoom;
    private ArrayList<Monster> roomMonster;
    private Treasure roomTreasure;

    GameLoop(Map loadedMap, Character loadedCharacter) {
        this.loadedMap = loadedMap;
        this.loadedCharacter = loadedCharacter;
        loop();
    }

    // Game logic loop
    public void loop() {
        Boolean keepGoing = true;
        while (keepGoing) {

            keepGoing = navigation();
            if (keepGoing) {
                displayRoom();
            }

        }
    }

    public void displayRoom() {
        // VISA MONSTER

        System.out.println("Du söker igenom rummet...");
        if (currentRoom.getRoomTreasure().getTreasureList() == null) {
            System.out.println("... men inser att du varit här förut.");
        } else if (currentRoom.getRoomTreasure().getTreasureList().isEmpty()) {
            System.out.println("... men du hittar bara damm.");
        } else {
            System.out.print("... och hittar [\u001B[33m");
            ArrayList<Treasure.treasureTypes> treasures = currentRoom.getRoomTreasure().getTreasureList();
            for (int i = 0; i < treasures.size(); i++) {
                if (i == 0) {
                    System.out.print(treasures.get(i));
                } else {
                    System.out.print(" och " + treasures.get(i));
                }
            }
            System.out.print("\u001B[0m] för ett värde av " + currentRoom.getRoomTreasure().getTreasureTotalValue() + " poäng.\n");
            loadedCharacter.addPoints(currentRoom.getRoomTreasure().getTreasureTotalValue());
        }
        currentRoom.clearTreasure();

    }

    // General method for navigating the dungeon
    public boolean navigation() {
        // Get the current room of player, if this is
        // the first iteration it will get the spawn room
        currentRoom = loadedMap.getPlayerCurrentRoom();

        System.out.println("\033[H\033[2J");
        System.out.flush(); // Clear screen

        // Print map and headline
        System.out.println(loadedMap.toString(true));
        System.out.println("\n\033[1mDina poäng är: \u001B[33m" + loadedCharacter.getPoints() + "\u001B[0m\033[0m");
        System.out.println("\n\033[1m-*-*-*-*-*-*-*-*-*-*-\033[0m");
        System.out.println("\033[1m -- Välj riktning -- \033[0m");
        System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-\033[0m");

        // Get direction choice from user
        Map.cardinalDirection chosenDirection = getDirectionFromUser();

        // If user picked to leave map
        if (chosenDirection == Map.cardinalDirection.LEAVE) {
            System.out.println("\n\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            System.out.println("\033[1m -- Äventyret slutar -- \033[0m");
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            System.out.println(leaveMapMessage());
            return false;
        }

        // Set current room as explored
        currentRoom.setIsRoomExplored(true);

        // Move to target room and update values
        currentRoom = currentRoom.getSpecificAdjacentRoom(chosenDirection);
        loadedMap.setPlayerCurrentRoom(currentRoom);

        return true;
    }

    // Input method for getting movement direction from user
    public Map.cardinalDirection getDirectionFromUser() {
        Map.cardinalDirection returnDirection = null;

        // Creating a temporary ArrayList to hold the dynamic menu options
        ArrayList<Map.cardinalDirection> menuOptions = new ArrayList<Map.cardinalDirection>();
        for (java.util.Map.Entry<Map.cardinalDirection, Room> entry: currentRoom.getAdjacentRooms().entrySet()) {
            menuOptions.add(entry.getKey());
        }

        // Check if player can leave map at this point...
        // ... add it to the menu options
        if (currentRoom.isEdgeRoom()) {
            menuOptions.add(Map.cardinalDirection.LEAVE);
        }

        // Print dynamic menu options
        for (int i = 0; i < menuOptions.size(); i++) {
            if (menuOptions.get(i) == Map.cardinalDirection.LEAVE) {
                System.out.println(i+1 + ". Lämna dungeon och avsluta äventyret (SPARA).");
            } else {
                System.out.println(i+1 + ". Gå mot " + menuOptions.get(i).toString().toLowerCase() + ".");
            }
        }

        // Handle user input and map it to correct menu option
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

        // Return chosen option
        return returnDirection;
    }

    // Message for leaving the dungeon map
    private String leaveMapMessage() {
        return "Hjälten " + loadedCharacter.getName() + " lämnar dungeon efter att ha samlat på sig skatter värda " + loadedCharacter.getPoints() + " poäng.";
    }

}
