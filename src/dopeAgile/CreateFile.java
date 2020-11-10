package dopeAgile;

import java.io.File;
import java.io.IOException;


public class CreateFile {
Character ch = null;
    public void creatAFile() {

        try {
            File myFile = new File(ch.getName() +".txt");
            if (myFile.createNewFile()) {
                System.out.println(myFile.getName() + " skapad");
            } else {
                System.out.println(myFile.getName() + " hittad");
            }
        } catch (IOException e) {
            System.out.println("En error har hänt, " + e);
        }
    }


}
