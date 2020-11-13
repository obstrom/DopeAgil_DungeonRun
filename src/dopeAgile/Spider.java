
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
        return "";
    }

    @Override
    public String getAttackHitMessage() {
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
    public String getAttackMissMessage() {
                
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Spindeln sveper över med sitt ben men missar hjälten.";
        } else if (rand < 5) {
            return "Spindeln skjuter en spindelnäts boll mot hjälten, den missar.";
        } else {
            return "spindeln försöker bita dig men du lyckas hoppa undan.";
        }
    }

    @Override
    public String getEntryMessage() { return "En jättespindel faller ner från taket!"; }

    @Override
    public String getKilledByMessage() { 
        return "Spindeln springer fram och biter av ditt ansikte."; }

    @Override
    public String getDeathMessage() { return "Spindeln gör ett sista ljud innan den dör: SCHREEEEE….."; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() { return ""; }
    
}
