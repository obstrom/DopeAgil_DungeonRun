package dopeAgile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreFile {

    private String[] inputValue;
    private String data;
    private String[] input;

    public void CreateFileInput() { // implumented

        try {
            File myFile = new File("Input.txt");
            if (myFile.createNewFile()) {
                System.out.println(myFile.getName() + " finns nu");
            } else {
                System.out.println(myFile.getName() + " finns");
            }
        } catch (IOException e) {
            System.out.println("En error har hänt, " + e);
        }
    }

    public void CreateFileScore() { // implumented
        try {
            File myFile = new File("Score.txt");
            if (myFile.createNewFile()) {
                System.out.println(myFile.getName() + " finns nu");
            } else {
                System.out.println(myFile.getName() + " finns");
            }
        } catch (IOException e) {
            System.out.println("En error har hänt, " + e);
        }

    }

    public void writeToInputFile(String name, int points) { // implumented
        try {
            File myFile = new File("Input.txt");
            Scanner myLoader = new Scanner(myFile);
            while (myLoader.hasNextLine()) {
                data = myLoader.nextLine();
                input = data.split("\\s+");
                
            }
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
        if (input == null ) {
            try {
                FileWriter myFile = new FileWriter("Input.txt");
                myFile.write(name + " " + points);
                myFile.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");

            }
        } else {

            try {
                File myFile = new File("Input.txt");
                Scanner myLoader = new Scanner(myFile);
                while (myLoader.hasNextLine()) {
                    data = myLoader.nextLine();
                    inputValue = data.split("\\s+");
                }
                myLoader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");

            }
            if (inputValue.length <= 2) {

                try {
                    FileWriter myFile = new FileWriter("Input.txt");
                    myFile.write(inputValue[0] + " " + inputValue[1] + " " + name + " " + points);
                    myFile.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");

                }
            } else if (inputValue.length <= 4) {

                try {
                    FileWriter myFile = new FileWriter("Input.txt");
                    myFile.write(inputValue[0] + " " + inputValue[1] + " "
                            + inputValue[2] + " " + inputValue[3] + " " + name + " " + points);
                    myFile.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");

                }

            } else if (inputValue.length <= 6) {

                try {
                    FileWriter myFile = new FileWriter("Score.txt");
                    myFile.write(inputValue[0] + " " + inputValue[1] + " "
                            + inputValue[2] + " " + inputValue[3] + " " + inputValue[4] + " " + inputValue[5]);
                    myFile.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");

                }
            }
        }

        try {
            File myFile = new File("Input.txt");
            Scanner myLoader = new Scanner(myFile);
            while (myLoader.hasNextLine()) {
                data = myLoader.nextLine();
                System.out.println(data);
            }
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
    }
}
