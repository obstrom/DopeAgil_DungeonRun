package dopeAgile;

import java.util.Scanner;

public class Main {

    static TryCatch tryinput = new TryCatch();

    enum CharacterType {
        RIDDARE, TJUV, MAGIKER;
    }

    public static void main(String[] args) throws InterruptedException {
        Startpage.Startpage();

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\n\033[1mVälkommen till Dungeon Run\033[0m");
        
        MusicPlayer audios = new MusicPlayer();
        audios.DungeonMusic();
        
        mainMenu();
      
        Map loadedMap = mapMenu();

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\n\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\033[1m -- Ett nytt äventyr börjar! -- \033[0m");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
        GameLoop gameSession = new GameLoop(loadedMap, Utility.getSingleCharacter(0));

    }

    public static void mainMenu() throws InterruptedException {
        FileOption op = new FileOption();
        int input = -1;
        int inputA = -1;
        while (input < 0) {

            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("1: Highscore\n" + "2: Skapa Karaktär\n" + "3: Ladda Karaktär\n" + "0: Avsluta");
            input = tryinput.TryIntInput();
            MusicPlayer sound = new MusicPlayer();
            sound.confirmSound();

        }

        switch (input) {
            case 1:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Highscore");
                op.options(1);
                break;
            case 2:
                characterChoice();
                break;
            case 3:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Välj Sparad Karaktär");
                op.options(2);
                break;
            default:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Avslutar Spelet");
                System.exit(0);
        }

    }

    public static CharacterType characterChoice() throws InterruptedException {
        CreateFile cf = new CreateFile();
        int characterMenuChoice = 0;
        String name = " ";
        CharacterType characterChoice = null;
        boolean run = true;

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\033[1m --- Välj en hjälte! --- \033[0m");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("1. Riddaren");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(" Iniativ: 5, Tålighet: 9, Attack: 6, Smidighet: 4 \n");
        System.out.println("    .-.");
        System.out.println("  __|=|__");
        System.out.println(" (_/`-`\\_)");
        System.out.println(" //\\___/\\\\");
        System.out.println(" <>/   \\<>");
        System.out.println("  \\|_._|/");
        System.out.println("   <_I_>");
        System.out.println("    |||");
        System.out.println("   /_|_\\ ");

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("2. Magiker");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(" Iniativ: 6, Tålighet: 4, Attack: 9, Smidighet: 5 \n");
        System.out.println("     __/\\__");
        System.out.println(". _  \\\\''//");
        System.out.println("-( )-/_||_\\");
        System.out.println(" .'. \\_()_/");
        System.out.println("  |   | . \\");
        System.out.println("  |   | .  \\");
        System.out.println("  |   | .   \\");
        System.out.println(" .'. ,\\_____'. ");

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("3. Tjuv");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(" Iniativ: 7, Tålighet: 5, Attack: 5, Smidighet: 7 \n");
        System.out.println("   / \\     ");
        System.out.println("  _|\"|_   /");
        System.out.println("0/ \\ /   /");
        System.out.println("\\/\\ ^ /`0");
        System.out.println("  /_^_\\");
        System.out.println("  // \\\\");
        System.out.println("  \\\\ //");
        System.out.println(" _d|_|b_ ");
 
        while (run) {

            try {
                characterMenuChoice = tryinput.TryIntInput();
                MusicPlayer sound = new MusicPlayer();
                sound.confirmSound();

                if (characterMenuChoice > 0 && characterMenuChoice < 4) {
                    run = false;
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("Ange ett tal mellan 1 och 3");
                }
            } catch (NumberFormatException e) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Ange endast siffror");
            }

        }

        Character player = null;
        switch (characterMenuChoice) {
            case 1:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Du har valt Riddaren!");
                characterChoice = CharacterType.RIDDARE;
                player = new Knight();
                break;
            case 2:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Du har valt Magikern!");
                characterChoice = CharacterType.MAGIKER;
                player = new Wizard();
                break;
            case 3:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Du har valt Tjuven!");
                characterChoice = CharacterType.TJUV;
                player = new Rogue();
                break;
            default:
                System.out.println("test");
                break;
        }

        name = characterName();
        player.setName(name);
        cf.creatAFile(name);
        Utility.addPlayer(player);

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\nKaraktären heter " + name + " och är en " + characterChoice + "\n");

        return characterChoice;

    }

    public static String characterName() throws InterruptedException {
        String characterName;
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\nVälj ett namn för din hjälte");
        characterName = tryinput.TryStringInput();
        MusicPlayer sound = new MusicPlayer();
        sound.confirmSound();

        return characterName;
    }

    public static Map mapMenu() throws InterruptedException {
        Map generatedMap = null;

        mapMenuLoop:
        while (true) {

            // Choose map size
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m -- Välj storlek på kartan -- \033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("1. Liten karta (4x4)");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("2. Medium karta (5x5)");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("3. Stor karta (8x8)");

            int mapChoice = 0;
            for (int i = 0; i < 1; i++) {
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine().toLowerCase();
                MusicPlayer sound = new MusicPlayer();
                sound.confirmSound();

                if (userInput.equals("1") || userInput.contains("liten")) {
                    mapChoice = 1;
                } else if (userInput.equals("2") || userInput.contains("medium")) {
                    mapChoice = 2;
                } else if (userInput.equals("3") || userInput.contains("large")) {
                    mapChoice = 3;
                } else {
                    System.out.println("Ogiltigt kommando! Försök igen.");
                    --i;
                }
            }

            // Choose spawn point
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m -- Vart på kartan vill du börja -- \033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("1. Nordvästra hörnet");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("2. Nordöstra hörnet");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("3. Sydvästra hörnet");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("4. Sydöstra hörnet");

            Map.cardinalDirection cardinal = null;
            for (int i = 0; i < 1; i++) {
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine().toLowerCase();
                MusicPlayer sound = new MusicPlayer();
                sound.confirmSound();

                if (userInput.equals("1") || userInput.contains("nordväst") || userInput.contains("nw")) {
                    cardinal = Map.cardinalDirection.NW;
                } else if (userInput.equals("2") || userInput.contains("nordöst") || userInput.contains("ne")) {
                    cardinal = Map.cardinalDirection.NE;
                } else if (userInput.equals("3") || userInput.contains("sydväst") || userInput.contains("sw")) {
                    cardinal = Map.cardinalDirection.SW;
                } else if (userInput.equals("4") || userInput.contains("sydöst") || userInput.contains("se")) {
                    cardinal = Map.cardinalDirection.SE;
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("Ogiltigt kommando! Försök igen.");
                    --i;
                }
            }

            switch (mapChoice) {
                case 1:
                    generatedMap = new Map(Map.mapSize.SMALL, cardinal);
                    break;
                case 2:
                    generatedMap = new Map(Map.mapSize.MEDIUM, cardinal);
                    break;
                case 3:
                    generatedMap = new Map(Map.mapSize.LARGE, cardinal);
                    break;
                default:
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("MapChoice switchcase error!");
            }

            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\n\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m -- Förhandsgranska karta -- \033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);

            // Print map one line at a time
            String printMap[] = generatedMap.toString(true).split("\n");
            for (String mapLine: printMap) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(mapLine);
            }

            for (int i = 0; i < 1; i++) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.print("\nAnvänd denna karta? (Y/N) ");
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine().toLowerCase();
                MusicPlayer sound = new MusicPlayer();
                sound.choiceSound();

                if (userInput.equals("y") || userInput.contains("yes") || userInput.contains("ja")) {
                    break mapMenuLoop;
                } else if (userInput.equals("n") || userInput.contains("no") || userInput.contains("nej")) {
                    break;
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("Ogiltigt kommando! Försök igen.");
                    --i;
                }
            }

        }

        return generatedMap;
    }

}
