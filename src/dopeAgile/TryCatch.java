package dopeAgile;

import java.util.Scanner;

public class TryCatch {

    protected String input;
    protected boolean loop = false;
    protected int intReturn;
    protected Scanner sc = new Scanner(System.in);

    public String TryStringInput() {
        do {
            input = sc.nextLine();
            try {
                if (input.isEmpty()) {
                    throw new Exception("Error: the name can´t be: ` Empty `, that just wont work.\n"
                            + "Prova igen");
                } else {
                    loop = true;
                }

            } catch (Exception e) {
                System.out.println("Error: the name can´t be: ` Empty `, that just wont work");
                loop = false;
            }
        } while (loop == false);
        return input;
    }

    public int TryIntInput() {
        do {
            input = sc.nextLine();
            try {
                intReturn = Integer.parseInt(input);
                if (intReturn <= -1) {
                    throw new Exception("Error: you have selected a negativ number: " + intReturn
                            + ", test with a posetiv number please.");
                } else {
                    loop = true;
                }

            } catch (Exception e) {
                System.out.println("Error: you need to use numbers here : " + input + " this is not allowed here");
                loop = false;
            }

        } while (loop == false);
        return intReturn;
    }
}
