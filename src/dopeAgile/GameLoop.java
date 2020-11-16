package dopeAgile;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLoop {
    private final Map loadedMap;
    private Character loadedCharacter;
    private Room currentRoom;
    private Room previousRoom;
    private ArrayList<Monster> roomMonster;
    private Treasure roomTreasure;
    private Score scores = new Score();
    SaveFile save = new SaveFile();
    private boolean playerIsFleeing;
    MusicPlayer music = new MusicPlayer();

    GameLoop(Map loadedMap, Character loadedCharacter) throws InterruptedException {
        this.loadedMap = loadedMap;
        this.loadedCharacter = loadedCharacter;
        loop();
        save.savingToFile(loadedCharacter.getName(), loadedCharacter.getPoints(), loadedCharacter.getAgility());
    }

    // Game logic loop
    public void loop() throws InterruptedException {
        Boolean keepGoing = true;
        while (keepGoing && loadedCharacter.isAlive()) {

            keepGoing = navigation();
            if (keepGoing) {
                displayRoom();

                if (playerIsFleeing) {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println(ConsoleColors.ITALIC + ConsoleColors.YELLOW + "Du flyr tillbaka till föregående rum." + ConsoleColors.RESET);
                    loadedMap.setPlayerCurrentRoom(previousRoom);
                    playerIsFleeing = false;
                }

                Thread.sleep(Utility.SLEEPTIME);
                System.out.print(ConsoleColors.NEWLINE + "<Tryck ENTER för att fortsätta vidare>");
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine();

                // TODO: TABORT DETTA??
                /*System.out.println("\n\033[1mHändelser:\033[0m");
                if (!currentRoom.isSpawnRoom()) {
                    System.out.println("\u001B[3m" + currentRoom.getRoomMessage() + "\033[0m");
                    for (Monster monster: currentRoom.getRoomMonsters()) {
                        System.out.println("\u001B[31m" + monster.getEntryMessage() + "\033[0m");
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
                }*/
            }
        }
    }

    public void displayRoom() throws InterruptedException {

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(ConsoleColors.NEWLINE + ConsoleColors.BOLD + "Händelser:" + ConsoleColors.RESET);
        if (!currentRoom.isSpawnRoom()) {
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println(ConsoleColors.NEWLINE + ConsoleColors.ITALIC + currentRoom.getRoomMessage() + ConsoleColors.RESET);
            for (Monster monster: currentRoom.getRoomMonsters()) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.RED + monster.getEntryMessage() + ConsoleColors.RESET);
                music.monsterSound();
            }

            // If room contains monsters
            if (!currentRoom.getRoomMonsters().isEmpty()) {
                Combat roomCombat = new Combat(loadedCharacter, currentRoom.getRoomMonsters(), currentRoom);
                playerIsFleeing = roomCombat.isPlayerIsFleeing();
            } else {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.ITALIC + "Det är tyst och stilla i rummet..." + ConsoleColors.RESET);
            }

        }

        if (loadedCharacter.isAlive() && !playerIsFleeing) {
            if (currentRoom.getRoomTreasure().getTreasureList() == null) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.NEWLINE + "Du söker igenom rummet, och inser att du varit här förut.");
            } else if (currentRoom.getRoomTreasure().getTreasureList().isEmpty()) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.NEWLINE + "Du söker igenom rummet, men du hittar bara damm.");
            } else {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.print(ConsoleColors.NEWLINE + "Du söker igenom rummet, och hittar [" + ConsoleColors.YELLOW_BOLD);
                music.treasureSound();
                ArrayList<Treasure.treasureTypes> treasures = currentRoom.getRoomTreasure().getTreasureList();
                //TODO lägg treasure sound här
                music.treasureSound();
                for (int i = 0; i < treasures.size(); i++) {
                    if (i == 0) {
                        System.out.print(treasures.get(i));
                    } else {
                        System.out.print(" och " + treasures.get(i));
                    }
                }
                System.out.print(ConsoleColors.RESET + "] för ett värde av "
                        + ConsoleColors.YELLOW_BOLD + currentRoom.getRoomTreasure().getTreasureTotalValue()
                        + ConsoleColors.RESET + " poäng." + ConsoleColors.NEWLINE );
                loadedCharacter.addPoints(currentRoom.getRoomTreasure().getTreasureTotalValue());
            }
            currentRoom.clearTreasure();
        }
    }

    // General method for navigating the dungeon
    public boolean navigation() throws InterruptedException {
        // Get the current room of player, if this is
        // the first iteration it will get the spawn room
        currentRoom = loadedMap.getPlayerCurrentRoom();

        // Print map and headline
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("");

        String printMap[] = loadedMap.toString(true).split("\n");
        for (String mapLine: printMap) {
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println(mapLine);
        }

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(ConsoleColors.NEWLINE + ConsoleColors.BOLD + "Dina skatter är värda " + ConsoleColors.YELLOW_BOLD + loadedCharacter.getPoints() + ConsoleColors.WHITE_BOLD + " poäng.");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(ConsoleColors.NEWLINE + ConsoleColors.BOLD + "-*-*-*-*-*-*-*-*-*-*-");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(ConsoleColors.BOLD + " -- Välj riktning -- ");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(ConsoleColors.BOLD +"-*-*-*-*-*-*-*-*-*-*-" + ConsoleColors.RESET);

        // Get direction choice from user
        Map.cardinalDirection chosenDirection = getDirectionFromUser();

        // If user picked to leave map
        if (chosenDirection == Map.cardinalDirection.LEAVE) {
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\n\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m -- Äventyret slutar -- \033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            System.out.println(leaveMapMessage());

            //Will output the name of game player and total points for the game.
            scores.addScore(loadedCharacter.getName(), loadedCharacter.getPoints());
            return false;

        }

        // Set current room as explored
        currentRoom.setIsRoomExplored(true);

        // Move to target room and update values
        previousRoom = currentRoom;
        currentRoom = currentRoom.getSpecificAdjacentRoom(chosenDirection);
        loadedMap.setPlayerCurrentRoom(currentRoom);
        currentRoom.setIsRoomExplored(true);

        return true;
    }

    // Input method for getting movement direction from user
    public Map.cardinalDirection getDirectionFromUser() throws InterruptedException {
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
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("5. Lämna dungeon och avsluta äventyret (SPARA).");
            } else {
                if (currentRoom.getSpecificAdjacentRoom(menuOptions.get(i)) == null) {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("\u001B[31m" + (i + 1) + ". - \033[0m");
                    menuOptions.set(i, null);
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println(i + 1 + ". Gå mot " + menuOptions.get(i).toString().toLowerCase() + ".");
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
                returnDirection = menuOptions.get(userInputInt - 1);
                if (returnDirection == null) {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("Ogiltigt kommando! Försök igen.");
                    --i;
                }
            } catch (NumberFormatException e) {
                if (menuOptions.toString().toLowerCase().contains(userInput)) {
                    for (Map.cardinalDirection direction : menuOptions) {
                        if (direction.toString().toLowerCase().contains(userInput)) {
                            returnDirection = direction;
                        }
                    }
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("Ogiltigt riktning! Försök igen.");
                    --i;
                }
            } catch (IndexOutOfBoundsException e) {
                Thread.sleep(Utility.SLEEPTIME);
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
