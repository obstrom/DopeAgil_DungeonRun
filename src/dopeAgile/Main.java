package dopeAgile;

// imports to handle Windows 10 console ANSI colors
import com.sun.jna.*;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.platform.win32.WinNT.HANDLE;


import java.util.Scanner;

public class Main {

    static TryCatch tryinput = new TryCatch();
    static ScoreFile sf = new ScoreFile();
    
    enum CharacterType {
        RIDDARE, TJUV, MAGIKER;
    }

    public static void main(String[] args) throws InterruptedException {

        // Handle Win10 ANSI color
        try {
            if(System.getProperty("os.name").startsWith("Windows"))
            {
                // Set output mode to handle virtual terminal sequences
                Function GetStdHandleFunc = Function.getFunction("kernel32", "GetStdHandle");
                DWORD STD_OUTPUT_HANDLE = new DWORD(-11);
                HANDLE hOut = (HANDLE)GetStdHandleFunc.invoke(HANDLE.class, new Object[]{STD_OUTPUT_HANDLE});

                DWORDByReference p_dwMode = new DWORDByReference(new DWORD(0));
                Function GetConsoleModeFunc = Function.getFunction("kernel32", "GetConsoleMode");
                GetConsoleModeFunc.invoke(BOOL.class, new Object[]{hOut, p_dwMode});

                int ENABLE_VIRTUAL_TERMINAL_PROCESSING = 4;
                DWORD dwMode = p_dwMode.getValue();
                dwMode.setValue(dwMode.intValue() | ENABLE_VIRTUAL_TERMINAL_PROCESSING);
                Function SetConsoleModeFunc = Function.getFunction("kernel32", "SetConsoleMode");
                SetConsoleModeFunc.invoke(BOOL.class, new Object[]{hOut, dwMode});
            }
        } catch (Exception e) {
            System.out.println("NOT WINDOWS 10");
        }

        sf.CreateFileInput();
        Startpage.Startpage();
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\n\033[1mWelcome to Dungeon Run\033[0m");

        //MusicPlayer audios = new MusicPlayer();
        //audios.DungeonMusic();

        while(true) {
            mainMenu();
            Map loadedMap = mapMenu();

            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\n\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m -- A new adventur begins! -- \033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            GameLoop gameSession = new GameLoop(loadedMap, Utility.getSingleCharacter(0));
        }

    }

    public static void mainMenu() throws InterruptedException {
        boolean keepGoing = true;
        FileOption op = new FileOption();
        int input = -1;
        int inputA = -1;
        while (input < 0) {

            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("1: High-Score\n" + "2: Create New Adventure\n" + "3: Option: Load/Delete \n" + "0: Exit Game\n");
            input = tryinput.TryIntInput();
//            MusicPlayer sound = new MusicPlayer();
//            sound.confirmSound();

        }

        switch (input) {
            case 1:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("High-Score");
                Score.displayHighScore();
                mainMenu();
                break;
            case 2:
                characterChoice();
                break;
            case 3:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Option: Load/Delete");
                op.options(2);
                break;
            default:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Exit Game");
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
        System.out.println("\033[1m --- Pick A hero! --- \033[0m");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("1. Knight");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(" Iniativ: 5, Endurance: 9, Attack: 6, Agility: 4 \n");
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
        System.out.println("2. Wizard");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(" Iniativ: 6, Endurance: 4, Attack: 9, Agility: 5 \n");
        System.out.println("     __/\\__");
        System.out.println(". _  \\\\''//");
        System.out.println("-( )-/_||_\\");
        System.out.println(" .'. \\_()_/");
        System.out.println("  |   | . \\");
        System.out.println("  |   | .  \\");
        System.out.println("  |   | .   \\");
        System.out.println(" .'. ,\\_____'. ");

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("3. Theif");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(" Iniativ: 7, Endurance: 5, Attack: 5, Agility: 7 \n");
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
                //MusicPlayer sound = new MusicPlayer();
                //sound.confirmSound();

                if (characterMenuChoice > 0 && characterMenuChoice < 4) {
                    run = false;
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("pick a number between 1 - 3");
                }
            } catch (NumberFormatException e) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("Only Numbers");
            }

        }

        Character player = null;
        switch (characterMenuChoice) {
            case 1:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("You Picked the Knight!");
                characterChoice = CharacterType.RIDDARE;
                player = new Knight();
                break;
            case 2:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("You picked the Wizard!");
                characterChoice = CharacterType.MAGIKER;
                player = new Wizard();
                break;
            case 3:
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("You picked the Theif!");
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
        System.out.println("\n the Adventure is named " + name + " and is a " + characterChoice + "\n");

        return characterChoice;

    }

    public static String characterName() throws InterruptedException {
        String characterName;
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("\nPick a name for you´re hero");
        characterName = tryinput.TryStringInput();
//        MusicPlayer sound = new MusicPlayer();
//        sound.confirmSound();

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
            System.out.println("\033[1m -- Pick size for map -- \033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("1. Small map (4x4)");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("2. Medium map (5x5)");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("3. Large map (8x8)");

            int mapChoice = 0;
            for (int i = 0; i < 1; i++) {
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine().toLowerCase();
//                MusicPlayer sound = new MusicPlayer();
//                sound.confirmSound();

                if (userInput.equals("1") || userInput.contains("small")) {
                    mapChoice = 1;
                } else if (userInput.equals("2") || userInput.contains("medium")) {
                    mapChoice = 2;
                } else if (userInput.equals("3") || userInput.contains("large")) {
                    mapChoice = 3;
                } else {
                    System.out.println("Try another command.");
                    --i;
                }
            }

            // Choose spawn point
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m -- Where on the map do you want to start -- \033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("\033[1m-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\033[0m");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("1. Northwest cornor");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("2. Northeast cornor");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("3. soulthwest cornor");
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println("4. soultheast cornor");

            Map.cardinalDirection cardinal = null;
            for (int i = 0; i < 1; i++) {
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine().toLowerCase();
//                MusicPlayer sound = new MusicPlayer();
//                sound.confirmSound();

                if (userInput.equals("1") || userInput.contains("northwest") || userInput.contains("nw")) {
                    cardinal = Map.cardinalDirection.NW;
                } else if (userInput.equals("2") || userInput.contains("northeast") || userInput.contains("ne")) {
                    cardinal = Map.cardinalDirection.NE;
                } else if (userInput.equals("3") || userInput.contains("soulthwest") || userInput.contains("sw")) {
                    cardinal = Map.cardinalDirection.SW;
                } else if (userInput.equals("4") || userInput.contains("soultheast") || userInput.contains("se")) {
                    cardinal = Map.cardinalDirection.SE;
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("Try another command.");
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
            System.out.println("\033[1m -- Preveiw the map -- \033[0m");
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
                System.out.print("\nUse this map? (Y/N) ");
                Scanner sc = new Scanner(System.in);
                String userInput = sc.nextLine().toLowerCase();
//                MusicPlayer sound = new MusicPlayer();
//                sound.choiceSound();

                if (userInput.equals("y") || userInput.contains("yes") || userInput.contains("yeah")) {
                    break mapMenuLoop;
                } else if (userInput.equals("n") || userInput.contains("no") || userInput.contains("nope")) {
                    break;
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println("Try another command.");
                    --i;
                }
            }

        }

        return generatedMap;
    }

}
