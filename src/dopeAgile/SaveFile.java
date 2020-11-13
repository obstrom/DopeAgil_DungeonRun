package dopeAgile;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
//Utility array = new Utility();

    public void savingToFile(String name, int points, int agility) {

        try {
            FileWriter mySave = new FileWriter(name + ".txt");
            mySave.write(name + " " + points + " " + agility); // role = riddare, trollkarl, tjuv. Points är totalt värde av poäng.
            mySave.close();
            System.out.println("Saved...");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
    }

}
//(array.playerList + System.getProperty("line.separator"));
