
package dopeAgile;

import java.util.Scanner;


public class TryCatch {
    protected String input;
    protected boolean loop = false;
    protected int intReturn;
    protected Scanner sc = new Scanner(System.in);
    public String TryStringInput(){
        do{
            input = sc.nextLine();
            try{
                if(input.isEmpty()){
                    throw new Exception("Error: Du har angivit namnet som: ` Tomt `, det fungerar tyvärr inte.\n"
                    +"Prova igen");
                }else{
                    loop = true;
                }
                
        }catch(Exception e){
                System.out.println("Du har angivit namnet som: ` Tomt `, det fungerar tyvärr inte.");
                }
        }while(loop == false);
        return input;
    }
    public int TryIntInput(){
        do{
            input = sc.nextLine();
            try{
                intReturn = Integer.parseInt(input);
                if (intReturn <= -1){
                    throw new Exception("Error: Du har angivit ett negativt tal: " + intReturn  
                    +", Prova med posetivt tal.");
                }else{
                   loop = true;
                }
                
                
            }catch(Exception e){
                System.out.println("Error: Du behöver ange tal här: " + input + "är ej tillåtet val");
                loop = false;
            }
            
        }while(loop == false);
        return intReturn;
    }
}
