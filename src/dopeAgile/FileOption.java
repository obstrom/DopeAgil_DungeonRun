package dopeAgile;

import dopeAgile.Character.Role;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOption extends Utility{
    private  int noClue;
    private  int points;
    private String input;
    private String data;
    private String name;
    private String one;
    private Character loadPlayer = null;
    private TryCatch tryinput = null;


    public void options(int choice){
        if (choice == 1){
            loadingSaveFile();
        }else{
        while (noClue <= 0|| noClue > 3){
        System.out.println("Välj nedstående alternativ:\n"
        +"1: ladda en karaktär\n"
        +"2: tabort en karaktär");
        noClue = tryinput.TryIntInput();
        if(noClue == 1){
           loadingSaveFile();
        }else{
          DeleteCharacter();
        }
        }
        }
    }

    public void loadingSaveFile() {
        
        System.out.println("Loadfile name: ");
        input = tryinput.TryStringInput();
        try {
            File myFile = new File( input +".txt");
            Scanner myLoader = new Scanner(myFile);
            while (myLoader.hasNextLine()) {
                data = myLoader.nextLine();
                String[] inputValue = data.split("\\s+");
                name = inputValue[0];
                one = inputValue[1];
                input = inputValue[2];
                points = Integer.parseInt(one);
                int role = Integer.parseInt(input);
                switch (role){
                    case 4:
                        loadPlayer = new Knight();
                        loadPlayer.setRole(Role.KNIGHT);
                        break;
                    case 5:
                        loadPlayer = new Wizard();
                        loadPlayer.setRole(Role.WIZARD);
                        break;
                    case 7:
                        loadPlayer = new Rouge();
                        loadPlayer.setRole(Role.ROUGE);
                        break;
                        
                }
            } 
            myLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("kunde inte hitta din fil, prova ett annat namn." + e);   
        }
        loadPlayer.setName(name);
        loadPlayer.setPoints(points);
       Utility.addPlayer(loadPlayer);
    }
        public void DeleteCharacter() {
        System.out.println("tabort karaktären: ");
        input = tryinput.TryStringInput();
        File myFile = new File(input + ".txt");
        if (myFile.delete()) {
            System.out.println("DELETED HAHAHAHAHAHAHAHA");
            Main.mainMenu();
        } else {
            System.out.println("Misslyckades att tarbort " + myFile.getName());
            Main.mainMenu();
        }
        
    } 




}

