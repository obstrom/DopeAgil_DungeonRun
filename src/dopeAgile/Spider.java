
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
        return (conjugate) ? "Jättespindeln" : "Jättespindel";
    }

    @Override
    public String getAttackMessage() {

        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Spindeln hugger Hjälten med sitt ben och träffar hjältens arm.";
        } else if (rand < 5) {
            return "Spindeln skjuter en spindelnäts boll mot hjälten, den träffar.";
        } else {
            return "spindel biter hjälten i armen.";
        }

    }

    @Override
    public String getAttackHitMessage() {

        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Här är miss 1";
        } else if (rand < 5) {
            return "Här är miss 2";
        } else {
            return "Här är miss 3";
        }

    }

    @Override
    public String getAttackMissMessage() {
        return "Miss";
    }

    @Override
    public String getEntryMessage() { return "En jättespindel faller ner från taket!"; }

    @Override
    public String getKilledByMessage() { return ""; }

    @Override
    public String getDeathMessage() { return ""; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() { return ""; }
    
}
