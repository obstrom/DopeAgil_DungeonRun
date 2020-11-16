package dopeAgile;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreRank {

    private String data;
    private String[] inputValue;
    private ArrayList<compareCharacter> heroes = new ArrayList<>();

    class compareCharacter implements Comparable<compareCharacter> {

        private int points;
        private final String name;

        compareCharacter(String name, String points) {
           this.name = name;
           try {
               this.points = Integer.parseInt(points);
           } catch (Exception e) {
                // Do nothing
           }
        }

        public int getPoints() {
            return points;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(compareCharacter hero) {
            return this.getPoints() - hero.getPoints();
        }

    }

    public void scoreList() {
        try {
            File myFile = new File("Input.txt");
            Scanner myLoader = new Scanner(myFile);
            while (myLoader.hasNextLine()) {
                data = myLoader.nextLine();
                inputValue = data.split("\\s+");

                compareCharacter heroA = new compareCharacter(inputValue[0], inputValue[1]);
                compareCharacter heroB = new compareCharacter(inputValue[2], inputValue[3]);
                compareCharacter heroC = new compareCharacter(inputValue[4], inputValue[5]);

                heroes.add(heroA);
                heroes.add(heroB);
                heroes.add(heroC);

            }
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

        Collections.sort(heroes);
        
    }

    public ArrayList<compareCharacter> getSortedHeroes() {
        scoreList();
        return heroes;
    }

}
