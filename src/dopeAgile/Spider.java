
package dopeAgile;

public class Spider extends Monster {

    private static final double COMMON = 0.2;
    
    public Spider() {
        super();
        this.initiative = 7;
        this.endurance = 1;
        this.attack = 2;
        this.agility = 3;
        super.refreshCombatEndurance();
    }

    public static double getCommon() {
        return COMMON;
    }

    @Override
    public String toString(boolean conjugate) {
        return (conjugate) ? "Spindeln" : "Spindel";
    }

    @Override
    public String getAttackMessage() {
        return "";
    }

    @Override
    public String getEntryMessage() { return "En spindel faller ner från taket!"; }
    
}
