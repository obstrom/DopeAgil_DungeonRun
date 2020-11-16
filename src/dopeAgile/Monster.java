
package dopeAgile;

public abstract class Monster extends Creature {
    
    int initiative;
    int endurance;
    int attack;
    int agility;
    int combatEndurance;
    int combatRoundInitiativeScore;
    boolean isAlive = true;

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public int getCombatEndurance() {
        return combatEndurance;
    }

    abstract String getAttackHitMessage(Creature creature); // Monster lands hit on player
    abstract String getAttackMissMessage(Creature creature); // Monster misses attack on player
    abstract String getEntryMessage(); // Monster appears
    abstract String getKilledByMessage(); // Monster kills player
    abstract String getDeathMessage(); // Monster dies by player
    abstract String getPlayerHitMessage(); // Monster gets hit by player
    abstract String getPlayerCritMessage(); // Monster gets critial hit by player

    // Restores "health" to full. Should be called after successful flee attempt
    public void refreshCombatEndurance() {
        combatEndurance = endurance;
    }

    // Method for lowering monsters combat endurance by one
    // Takes a boolean for crit that lowers endurance by two instead
    public void lowerCombatEndurance(boolean criticalHit) {
        combatEndurance = (criticalHit) ? combatEndurance -2 : combatEndurance -1;
    }

    public int getCombatRoundInitiativeScore() {
        return combatRoundInitiativeScore;
    }

    public void setCombatRoundInitiativeScore(int combatRoundInitiativeScore) {
        this.combatRoundInitiativeScore = combatRoundInitiativeScore;
    }

    public void resetCombatRoundInitiativeScore() {
        combatRoundInitiativeScore = 0;
    }
    
}
