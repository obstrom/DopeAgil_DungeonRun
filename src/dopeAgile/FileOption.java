package dopeAgile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOption {
    private int noClue;
    private String input;
    String data;
    Scanner sc = new Scanner(System.in);
    Utility array = null;
    Main ret = null;
    Highscore hs = new higscore();
    Character ch = null;
    public void options(int choice){
        if (choice == 1){
            loadingSaveFile();
            hs.highscoreList(data); // kanske inte är rätt.
        }else{
        while (noClue <= 0|| noClue > 3){
        System.out.println("Välj nedstående alternativ:\n"
        +"1: ladda en karaktär\n"
        +"2: tabort en karaktär");
        input = sc.nextLine();
        try{
            noClue = Integer.parseInt(input);
        }catch(Exception e){
            System.out.println("Ett Fel Uppstog");
        }
        if(noClue == 1){
            loadingSaveFile();
            ret.mapMenu();
            break;
        }else{
          DeleteCharacter();
          ret.mainMenu();
          break;
        }
        
        }
        }
    }
    
    public String loadingSaveFile() {
        System.out.println("Loadfile name: ");
        input = sc.nextLine();
        try {
            File myFile = new File( input +".txt");
            Scanner myLoader = new Scanner(myFile);
            while (myLoader.hasNextLine()) {
                data = myLoader.nextLine();
                System.out.println(data);
                String[] inputValue = data.split("\\s+");
                String name = inputValue[0];
                String one = inputValue[1];
                String role = inputValue[2];
                int points = Integer.parseInt(one);
                ch.setName(name);
                ch.setPoints(points);
                ch.setRole(role);
            }
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("En error har hänt, " + e);

        }
       return data;
    }
        public void DeleteCharacter() {
        System.out.println("tabort karaktären: ");
        input = sc.nextLine();

        File myFile = new File(input + ".txt");
        if (myFile.delete()) {
            System.out.println("Bortagen karaktär: " + myFile.getName());
        } else {
            System.out.println("Misslyckades att tarbort " + myFile.getName());
            
        }
        ret.mainMenu();
    } 

}

