package dopeAgile;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {
//Utility array = new Utility();
    Character ch = new Character();

    public void savingToFile() {
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