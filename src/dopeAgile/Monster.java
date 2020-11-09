
// Metod som tittar om monsret träffar vid attack (tar emot dpelarens attack värde int
package dopeAgile;

public abstract class Monster {
    
    int initiative;
    int endurance;
    int attack;
    int agility;

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

    abstract String getAttackMessage();
    abstract String getEntryMessage();
    
    // Metod för att sänka monstrets endurance. Tar en int som sänker endurance
    public void lowerMonsterEndurance(){
        this.endurance = this.endurance - 1;
    }
    // Metod som returnerar boolean som kollar om monsterets endurance är högre än 0
    public boolean monsterEndurance(){
        boolean monsterAlive;
        
        if (this.endurance < 0){
            monsterAlive = false;
        } else{
            monsterAlive = true;
        }
        return monsterAlive;
    }
    
    // Metod som tittar om monsret träffar vid attack (tar emot dpelarens attack värde int
    
    
}
