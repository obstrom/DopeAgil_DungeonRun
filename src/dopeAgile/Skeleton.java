
package dopeAgile;

public class Skeleton extends Monster {
    
    public Skeleton(){
        super();
        this.initiative = 4;
        this.endurance = 2;
        this.attack = 2;
        this.agility = 3;
        this.common = 0.15;
    }

    @Override
    public String getAttackMessage() {
        return "";
    }
    
}
