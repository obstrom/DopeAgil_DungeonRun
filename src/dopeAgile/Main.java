package dopeAgile;

import java.util.Scanner;

public class Main {

    enum CharacterType {
        RIDDARE, TJUV, MAGIKER;
    }

    public static void main(String[] args) { ///coment

        System.out.println("\n\033[1mVälkommen till Dungeon Run\033[0m");

        mainMenu();

    }

    public static void mainMenu() {
        String Adventure;
        int input = -1;
        int inputA = -1;
        while (input < 0) {

            Scanner sc = new Scanner(System.in);

            System.out.println("1: Highscore\n" + "2: Skapa Karaktär\n" + "3: Ladda Karaktär\n" + "0: Avsluta");

            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Fel input");
            }

        }

        Scanner sc = new Scanner(System.in);

        switch (input) {
            case 1:
                System.out.println("Highscore");
                mainMenu();
                break;
            case 2:
                characterMenu();
                break;
            case 3:
                System.out.println("Välj Sparad Karaktär");
                mainMenu();
                break;
            default:
                System.out.println("Avslutar Spelet");
                System.exit(0);
        }

    }

    public static void characterMenu() {
        CharacterType character = characterChoice();
        String name = characterName();
        System.out.println("\nKaraktären heter " + name + " och är en " + character + "\n");
        mapMenu();
    }

    public static CharacterType characterChoice() {

        int characterMenuChoice = 0;
        CharacterType characterChoice = null;
        boolean run = true;

        System.out.println("\033[1m --- Välj en hjälte! --- \033[0m");
        System.out.println("1. Riddaren");
        System.out.println(" Iniativ: 5, Tålighet: 9, Attack: 6, Smidighet: 4 \n");

        System.out.println("2. Magiker");
        System.out.println(" Iniativ: 6, Tålighet: 4, Attack: 9, Smidighet: 5 \n");

        System.out.println("3. Tjuv");

        while (run) {

            try {
                Scanner sc = new Scanner(System.in);
                characterMenuChoice = Integer.parseInt(sc.nextLine());

                if (characterMenuChoice > 0 && characterMenuChoice < 4) {
                    run = false;
                } else {
                    System.out.println("Ange ett tal mellan 1 och 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ange endast siffror");
            }

        }

        switch (characterMenuChoice) {
            case 1:
                System.out.println("Du har valt Riddaren!");
                characterChoice = CharacterType.RIDDARE;
                // Character player = new Knight();
                break;
            case 2:
                System.out.println("Du har valt Magikern!");
                characterChoice = CharacterType.MAGIKER;
                // Character player = new Magican();
                break;
            case 3:
                System.out.println("Du har valt Tjuven!");
                characterChoice = CharacterType.TJUV;
                // Character player = new Rouge();
                break;
            default:
                System.out.println("test");
                break;
        }

        return characterChoice;

    }

    public static String characterName() {
        String characterName;
        System.out.println("\nVälj ett namn för din hjälte");
        Scanner sc = new Scanner(System.in);
        characterName = sc.nextLine();

        return characterName;
    }

    public static void mapMenu() {

        int mapChoice = 0;
        System.out.println("\033[1mVälj storlek på kartan:\033[0m");
        System.out.println("1. Liten karta (4x4)");
        System.out.println("2. Lagom karta (5x5)");
        System.out.println("3. Stor karta (8x8)");


        for (int i = 0; i < 1; i++) {
            try {
                Scanner sc = new Scanner(System.in);
                mapChoice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Ogiltigt kommando! Försök igen.");
                --i;
            }
        }

        switch (mapChoice) {
            case 1:
                System.out.println("Du har valt en liten karta.");
                break;
            case 2:
                System.out.println("Du har valt en lagom karta.");
                break;
            case 3:
                System.out.println("Du har valt en stor karta.");
                break;
            default:
                System.out.println("Valen var 1, 2 och 3");
        }

    }

}