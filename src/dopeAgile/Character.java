
package dopeAgile;

public class Character {

    int initiative;
    int endurance;
    int attack;
    int agility;
    int positionX;
    int positionY;
    private String name;
    int points;
    int playerId;
    int idGenerator;

    public Character() {
       this.role = role;
       this.positionX = 0;
       this.positionY = 0;
       this.name = name;
       this.points = 0;
       this.playerId = idGenerator;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return "Character{" + " initiative : " + initiative + ", endurance : " + endurance + ", attack : " + attack + ", agility : " + agility + '}';
    }
   
    public void specialAbility() {
        
    }

}
