package dopeAgile;

public abstract class Creature implements Comparable<Creature> {

    abstract int calcAttackScore();
    abstract int calcDefenseScore();
    abstract int getInitiative();
    abstract int getEndurance();
    abstract boolean isAlive();
    abstract String toString(boolean conjugate);
    abstract void refreshCombatEndurance();
    abstract int getCombatEndurance();
    abstract String getAttackMessage();
    abstract String getAttackHitMessage();
    abstract String getAttackMissMessage();

    @Override
    public int compareTo(Creature creature) {
        return this.getInitiative();
    }

}
