package dopeAgile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreFiles {

    public void CreateFileScore() {
        try {
            File myFile = new File("Score.txt");
            if (myFile.createNewFile()) {
                System.out.println(myFile.getName() + " fanns inte");
            } else {
                System.out.println(myFile.getName() + " finns");
            }
        } catch (IOException e) {
            System.out.println("En error har hänt, " + e);
        }
    }

    public void writeToSocreFile() {
        
        String[] data;
        data(name, points);
        
        try {
            FileWriter mySave = new FileWriter(name + ".txt");
            mySave.write(name + " " + points); // role = riddare, trollkarl, tjuv. Points är totalt värde av poäng.
            mySave.close();
            System.out.println("Saved...");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
    }

    public void readScoreFile() {

    }
}
