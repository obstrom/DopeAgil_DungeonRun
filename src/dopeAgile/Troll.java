
package dopeAgile;

public class Troll extends Monster {

    public static final double COMMON = 0.05;
    
    public Troll() {
        super();
        this.initiative = 2;
        this.endurance = 4;
        this.attack = 7;
        this.agility = 2;
        super.refreshCombatEndurance();
    }

    public static double getCommon() {
        return COMMON;
    }

    @Override
    public String toString(boolean conjugate) {
        return (conjugate) ? "Trollet" : "Troll";
    }

    @Override
    public String getAttackMessage() {
        return "";
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
    public String getEntryMessage() { return "Ett troll kommer in genom en av dörrarna!"; }

    @Override
    public String getKilledByMessage() { return ""; }

    @Override
    public String getDeathMessage() { return ""; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() { return ""; }
    
}
