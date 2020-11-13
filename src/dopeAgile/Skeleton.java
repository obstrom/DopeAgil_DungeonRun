
package dopeAgile;

public class Skeleton extends Monster {

    public static final double COMMON = 0.15;
    
    public Skeleton(){
        super();
        this.initiative = 4;
        this.endurance = 2;
        this.attack = 3;
        this.agility = 3;
        super.refreshCombatEndurance();
    }

    public static double getCommon() {
        return COMMON;
    }

    @Override
    public String toString(boolean conjugate) {
        return (conjugate) ? "Skelettet" : "Skelett";
    }

    @Override
    public String getAttackMessage() {
        return "Skelett";
    }

    @Override
    public String getAttackHitMessage() {
        return "Hit";
    }

    @Override
    public String getAttackMissMessage() {
        return "Miss";
    }

    @Override
    public String getEntryMessage() { return "Ett skelett reser sig från marken!"; }

    @Override
    public String getKilledByMessage() { return ""; }

    @Override
    public String getDeathMessage() { return ""; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() { return ""; }

}
