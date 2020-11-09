package dopeAgile;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
//Utility array = new Utility();
    static Character ch = new Wizard(); // FIX THIS - GET PLAYER CHAR INSTEAD

    SaveFile() {
        // GET PLAYER CHAR
    }

    public static void savingToFile() {
        try {
            FileWriter mySave = new FileWriter(ch.getName()+".txt");
            mySave.write(ch.getName() + " " + ch.getPoints() + " " + ch.getRole()); // role = riddare, trollkarl, tjuv. Points är totalt värde av poäng.
            mySave.close();
            System.out.println("Saved...");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
    }

}
//(array.playerList + System.getProperty("line.separator"));