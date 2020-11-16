package dopeAgile;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
private ScoreFile sf = new ScoreFile();
    public void savingToFile(String name, int points, int agility) {

        try {
            FileWriter mySave = new FileWriter(name + ".txt");
            mySave.write(name + " " + points + " " + agility);
            mySave.close();
            System.out.println("Saved...");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
        sf.writeToInputFile(name, points);
    }

}

