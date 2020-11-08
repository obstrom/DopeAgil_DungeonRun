package dopeAgile;

public class FleeingMonster {

    int flee;
    int type;
   

    public void Fleeing() {
        
        Character kar = new Character();
        type = kar.getAgility();
        

        switch (type) {
            case 4:
                flee = 1 + (int) (100 * Math.random());
                if (flee <= 40) {
                    System.out.println("Du lyckade göra en taktisk reträtt");
                    // skappa ett nytt tomt rum? eller gå tillbacka?
                    
                    
                    
                } else {
                    System.out.println("Du misslyckades");
                    // Striden fortsätter men monstert börjar.
                }
                break;
            case 5:
                System.out.println("Ljussken: Monstern är blinda");
                //retur till föra Rum. monster får full hp
                break;
            case 7:
                flee = 1 + (int) (100 * Math.random());
                if (flee <= 70) {
                    System.out.println("så ovanligt.... du lyckades... fly.. ");
                    // retur till Föra rum, monster får full hp
                } else {
                    System.out.println("Jaha, ett mislyckade... lycka till att överleva");
                    // Striden fortsätter men monstert börjar.
                }
                break;
        }

    }
}
