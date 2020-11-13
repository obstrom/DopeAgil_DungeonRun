
package dopeAgile;

public class Orc extends Monster {

    public static final double COMMON = 0.1;
    
    public Orc(){
        super();
        this.initiative = 6;
        this.endurance = 3;
        this.attack = 4;
        this.agility = 4;
        super.refreshCombatEndurance();
    }

    public static double getCommon() {
        return COMMON;
    }

    @Override
    public String toString(boolean conjugate) {
        return (conjugate) ? "Orcen" : "Orc";
    }

    @Override
    public String getAttackMessage() {
        return "Orc";
    }

    @Override
    public String getAttackHitMessage() {
        return "Träff!";
    }

    @Override
    public String getAttackMissMessage() {
        return "Miss";
    }

    @Override
    public String getEntryMessage() { return "En orc kommer ut ur skuggan!"; }

    @Override
    public String getKilledByMessage() { return ""; }

    @Override
    public String getDeathMessage() { return ""; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() { return ""; }

}