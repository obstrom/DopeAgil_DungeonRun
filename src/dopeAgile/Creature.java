package dopeAgile;

public abstract class Creature implements Comparable<Creature> {

    abstract int getInitiative();
    abstract int getEndurance();
    abstract int getAttack();
    abstract int getAgility();
    abstract boolean isAlive();
    abstract String toString(boolean conjugate);
    abstract void refreshCombatEndurance();
    abstract int getCombatRoundInitiativeScore();
    abstract void resetCombatRoundInitiativeScore();
    abstract void setCombatRoundInitiativeScore(int score);
    abstract int getCombatEndurance();
    abstract String getAttackHitMessage(Creature creature);
    abstract String getAttackMissMessage(Creature creature);

    @Override
    public int compareTo(Creature compareCreature) {
        return compareCreature.getCombatRoundInitiativeScore() - this.getCombatRoundInitiativeScore();
    }

    // Returns the calculated attack score
    public int calcAttackScore() {
        int attackScore = 0;
        for (int i = 0; i < this.getAttack(); i++) {
            attackScore += Utility.throwSixSidedDie();
        }
        return attackScore;
    }

    // Returns the calculated defense score
    public int calcDefenseScore() {
        int defenseScore = 0;
        for (int i = 0; i < this.getAgility(); i++) {
            defenseScore += Utility.throwSixSidedDie();
        }
        return defenseScore;
    }

    // Sets the calculated initiative score
    public void calcNewCombatInitiative() {
        int initiativeScore = 0;
        for (int i = 0; i < this.getInitiative(); i++) {
            initiativeScore += Utility.throwSixSidedDie();
        }
        this.setCombatRoundInitiativeScore(initiativeScore);
    }

}
