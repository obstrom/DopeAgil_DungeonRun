package dopeAgile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreFile {
private String[] inputValue;
    public void CreateFileScore() {
    
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

    public void writeToSocreFile(String name, int points) {

        try {
            FileWriter myFile = new FileWriter("Input.txt");
            myFile.write(name + " " + points);
            myFile.close();
            System.out.println("Saved...");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
    }

    public void arrayScoreFile() {
        
        try {
            File myFile = new File("Input.txt");
            Scanner myLoader = new Scanner(myFile);
            while (myLoader.hasNextLine()) {
                String data = myLoader.nextLine();
                inputValue = data.split("\\s+");
            }
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
        
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
        
        try {
            FileWriter myFile = new FileWriter("Score.txt");
            myFile.write(inputValue[0-9]);
            myFile.close();
            System.out.println("Saved...");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
        
        System.out.println("Loadfile name: ");
        
        try {
            File myObj = new File("Score.txt");
            Scanner myLoader = new Scanner(myObj);
            while (myLoader.hasNextLine()) {
                String data = myLoader.nextLine();
                System.out.println(data);
            }
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
    }
}
