
package dopeAgile;

public class Character {
    
    int initiative;
    int endurance;
    int attack;
    int agility;
    int positionX;
    int positionY;
 
public Character() {
    
   this.positionX = 0;
   this.positionY = 0;
    
}    

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "Character{" + " initiative : " + initiative + ", endurance : " + endurance + ", attack : " + attack + ", agility : " + agility + '}';
    }
   
    public void specialAbility() {
        
    }



}
