import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Välkommen till Dungeon Run");

        mainMenu();
        mapManu();

    }

    public static void mainMenu() {
        String Adventure;
        int input = -1;
        int inputA = -1;
        while (input < 0) {

            Scanner sc = new Scanner(System.in);

            System.out.println("1: Highscorem\n" + "2: Skapa Karaktär\n" + "3: Ladda Karaktär\n" + "0: Avsluta");

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
                break;
            case 2:
                int choice = characterChoice();
                break;
            case 3:
                System.out.println("Välj Sparad Karaktär");
                break;
            default:
                System.out.println("Avslutar Spelet");
                System.exit(0);
        }

    }

    public static void characterMenu() {
        int character = characterChoice();
        String name = characterName();
        System.out.println("Vald karaktär är " + character + "\nDitt namn är " + name);
    }

    public static int characterChoice() {

        int characterChoice = 0;
        boolean run = true;

        System.out.println(" --- Välj en hjälte! --- ");
        System.out.println("1. Riddaren");
        System.out.println(" Iniativ: 5, Tålighet: 9, Attack: 6, Smidighet: 4 \n");

        System.out.println("2. Magiker");
        System.out.println(" Iniativ: 6, Tålighet: 4, Attack: 9, Smidighet: 5 \n");

        System.out.println("3. Tjuv");
        System.out.println(" Iniativ: 7, Tålighet: 5, Attack: 5, Smidighet: 7 \n");

        while (run) {

            try {
                Scanner sc = new Scanner(System.in);
                characterChoice = Integer.parseInt(sc.nextLine());

                if (characterChoice > 0 && characterChoice < 4) {
                    run = false;
                } else {
                    System.out.println("Ange ett tal mellan 1 och 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ange endast siffror");
            }

        }

        switch (characterChoice) {
            case 1:
                System.out.println("Du har valt Riddaren!");
                // Character player = new Knight();
                break;
            case 2:
                System.out.println("Du har valt Magikern!");
                // Character player = new Magican();
                break;
            case 3:
                System.out.println("Du har valt Tjuven!");
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
        System.out.println("Välj ett namn för din hjälte");
        Scanner sc = new Scanner(System.in);
        characterName = sc.nextLine();

        return characterName;
    }

    public static void mapManu() {

        int mapChoice = 0;
        System.out.println("Map menu");
        System.out.println("Choose the size of your map.");
        System.out.println("1 Small map 4x4");
        System.out.println("2 Medium map 5x5");
        System.out.println("3 Large map 8x8");


        for (int i = 0; i < 1; i++) {
            try {
                Scanner sc = new Scanner(System.in);
                mapChoice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("invalid input");
                --i;
            }
        }

        switch (mapChoice) {
            case 1:
                System.out.println("You have chosen a small map");
                break;
            case 2:
                System.out.println("You have chosen a medium map");
                break;
            case 3:
                System.out.println("You have chosen a large map");
                break;
            default:
                System.out.println("The choices were 1, 2 and 3");
        }

    }

}