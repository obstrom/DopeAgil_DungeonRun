package dopeAgile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoreRank {

    private String data;
    private String[] inputValue;
    private String heroA;
    private String intergerA;
    private int pA;
    private String heroB;
    private String intergerB;
    private int pB;
    private String heroC;
    private String intergerC;
    private int pC;

    public void scoreList() {
        try {
            File myFile = new File("Input.txt");
            Scanner myLoader = new Scanner(myFile);
            while (myLoader.hasNextLine()) {
                data = myLoader.nextLine();
                inputValue = data.split("\\s+");
                heroA = inputValue[0];
                intergerA = inputValue[1];
                heroB = inputValue[2];
                intergerB = inputValue[3];
                heroC = inputValue[4];
                intergerC = inputValue[5];
                pA = Integer.parseInt(intergerA);
                pB = Integer.parseInt(intergerB);
                pC = Integer.parseInt(intergerC);

            }
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
        if (pA > pB && pA > pC) {
            // om A är störst
            
            System.out.println(heroA+ " " + pA);
        }else if (pB > pA && pB > pC){
            // om B är störst
            System.out.println(heroB + " " + pB);
        }else{
            // C är störst
            System.out.println(heroC + " " + pC);
        }
        
        
    }
}
