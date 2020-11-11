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

        System.out.println("\n\033[1mHändelser:\033[0m");
        if (!currentRoom.isSpawnRoom()) {
            System.out.println("\u001B[3m" + currentRoom.getRoomMessage() + "\033[0m");
            for (Monster monster: currentRoom.getRoomMonsters()) {
                System.out.println("\u001B[31m" + monster.getEntryMessage() + "\033[0m");
            }
            if (currentRoom.getRoomMonsters().size() > 0) {
                System.out.println("Du besegrar alla monster.");
            }
        }

        if (currentRoom.getRoomTreasure().getTreasureList() == null) {
            System.out.println("Du söker igenom rummet, och inser att du varit här förut.");
        } else if (currentRoom.getRoomTreasure().getTreasureList().isEmpty()) {
            System.out.println("Du söker igenom rummet, men du hittar bara damm.");
        } else {
            System.out.print("Du söker igenom rummet, och hittar [\u001B[33m");
            ArrayList<Treasure.treasureTypes> treasures = currentRoom.getRoomTreasure().getTreasureList();
            for (int i = 0; i < treasures.size(); i++) {
                if (i == 0) {
                    System.out.print(treasures.get(i));
                } else {
                    System.out.print(" och " + treasures.get(i));
                }
            }
            System.out.print("\u001B[0m] för ett värde av \u001B[33m" + currentRoom.getRoomTreasure().getTreasureTotalValue() + "\u001B[0m poäng.\n");
            loadedCharacter.addPoints(currentRoom.getRoomTreasure().getTreasureTotalValue());
        }
        currentRoom.clearTreasure();
    }

    // General method for navigating the dungeon
    public boolean navigation() {
        // Get the current room of player, if this is
        // the first iteration it will get the spawn room
        currentRoom = loadedMap.getPlayerCurrentRoom();

        // Print map and headline
        System.out.println("");
        System.out.println(loadedMap.toString(true));
        System.out.println("\n\033[1mDina skatter är värda \u001B[33m" + loadedCharacter.getPoints() + "\u001B[0m poäng.\033[0m");
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

        // If room contains monsters
        if (!currentRoom.getRoomMonsters().isEmpty()) {
            Combat roomCombat = new Combat(loadedCharacter, currentRoom.getRoomMonsters(), currentRoom);
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
        menuOptions.add(Map.cardinalDirection.N);
        menuOptions.add(Map.cardinalDirection.E);
        menuOptions.add(Map.cardinalDirection.S);
        menuOptions.add(Map.cardinalDirection.W);

        // Check if player can leave map at this point...
        // ... add it to the menu options
        if (currentRoom.isEdgeRoom()) {
            menuOptions.add(Map.cardinalDirection.LEAVE);
        }

        // Print dynamic menu options
        for (int i = 0; i < menuOptions.size(); i++) {
            if (menuOptions.get(i) == Map.cardinalDirection.LEAVE) {
                System.out.println("5. Lämna dungeon och avsluta äventyret (SPARA).");
            } else {
                if(currentRoom.getSpecificAdjacentRoom(menuOptions.get(i)) == null) {
                    System.out.println("\u001B[31m" + (i+1) + ". - \033[0m");
                    menuOptions.set(i, null);
                } else {
                    System.out.println(i+1 + ". Gå mot " + menuOptions.get(i).toString().toLowerCase() + ".");
                }
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
                if (returnDirection == null) {
                    System.out.println("Ogiltigt kommando! Försök igen.");
                    --i;
                }
            } catch (NumberFormatException e) {
                if (menuOptions.toString().toLowerCase().contains(userInput)) {
                    for (Map.cardinalDirection direction: menuOptions) {
                        if (direction.toString().toLowerCase().contains(userInput)) {
                            returnDirection = direction;
                        }
                    }
                } else {
                    System.out.println("Ogiltigt riktning! Försök igen.");
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
        return "Hjälten " + loadedCharacter.getName() + " lämnar dungeon efter att ha samlat på sig skatter värda \033[1m\u001B[33m" + loadedCharacter.getPoints() + " poäng.\u001B[0m\033[0m";
    }

}
