package dopeAgile;

import java.io.File;
import java.io.IOException;


public class CreateFile {

    public void creatAFile(String name) {

        try {
            File myFile = new File(name +".txt");
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
