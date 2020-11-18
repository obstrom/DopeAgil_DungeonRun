package dopeAgile;

import dopeAgile.Character.Role;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileOption extends Utility {

    private int noClue;
    private int points;
    private String input;
    private String data;
    private String name;
    private String one;
    private Character loadPlayer = null;
    private TryCatch tryinput = new TryCatch();

    public void options(int choice) throws InterruptedException {
        if (choice == 1) {
            loadingSaveFile();
        } else {
            while (noClue <= 0 || noClue > 3) {
                System.out.println("pick one of the following:\n"
                        + "1: load a character\n"
                        + "2: delete a character\n"
                        + "3: reset highscore\n");
                noClue = tryinput.TryIntInput();
                if (noClue == 1) {
                    loadingSaveFile();
                } else if (noClue == 2) {
                    DeleteCharacter();
                } else {
                    clearHighScore();
                }

            }
        }
    }

    public void loadingSaveFile() {

        System.out.println("Loadfile name: ");
        input = tryinput.TryStringInput();
        try {
            File myFile = new File(input + ".txt");
            Scanner myLoader = new Scanner(myFile);
            while (myLoader.hasNextLine()) {
                data = myLoader.nextLine();
                String[] inputValue = data.split("\\s+");
                name = inputValue[0];
                one = inputValue[1];
                input = inputValue[2];
                points = Integer.parseInt(one);
                int role = Integer.parseInt(input);
                switch (role) {
                    case 4:
                        loadPlayer = new Knight();
                        loadPlayer.setRole(Role.KNIGHT);
                        break;
                    case 5:
                        loadPlayer = new Wizard();
                        loadPlayer.setRole(Role.WIZARD);
                        break;
                    case 7:
                        loadPlayer = new Rogue();
                        loadPlayer.setRole(Role.ROGUE);
                        break;

                }
            }
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("could not find file with that name, it`s case-sensitiv." + e);
        }
        loadPlayer.setName(name);
        loadPlayer.setPoints(points);
        Utility.addPlayer(loadPlayer);
    }

    public void DeleteCharacter() throws InterruptedException {
        System.out.println("Delete a Character: ");
        input = tryinput.TryStringInput();
        File myFile = new File(input + ".txt");
        if (myFile.delete()) {
            System.out.println("DELETED: no return point...");
            Main.mainMenu();
        } else {
            System.out.println("failure to delete " + myFile.getName());
            Main.mainMenu();
        }

    }

    public void clearHighScore() throws InterruptedException {
        System.out.println("clearing catch-file");
        input = tryinput.TryStringInput();
        File myFile = new File("Input.txt");
        if (myFile.delete()) {
            System.out.println("DELETED: reCreating empty-file");
            Main.mainMenu();
        } else {
            System.out.println("failure to delete " + myFile.getName());
            Main.mainMenu();
        }

        try {
            File myNewFile = new File("Input.txt");
            if (myNewFile.createNewFile()) {
                System.out.println(myNewFile.getName() + " Made");
            } else {
                System.out.println(myNewFile.getName() + " Error: Found");
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

    }

}
