package dopeAgile;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    public void creatAFile(String name) {

        try {
            File myFile = new File(name + ".txt");
            if (myFile.createNewFile()) {
                System.out.println(myFile.getName() + " made");
            } else {
                System.out.println(myFile.getName() + " found");
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }

}
