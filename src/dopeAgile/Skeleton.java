
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
    public String getAttackMessage(){
        return null;
    }


    @Override
    public String getAttackHitMessage(Creature creature) {
        
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Skelettet tar av sin ena arm och använder det som ett vapen. du blir träffad.";
        } else if (rand < 5) {
            return "Skelettet hugger dig med sitt svärd.";
        } else {
            return "Skelettet tar upp sten från marken och kastar på Hjälten, den träffar.";
        }
    }

    @Override
    public String getAttackMissMessage(Creature creature) {
    
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Skelettet försöker attackera dig men missar.";
        } else if (rand < 5) {
            return "skelettet försöker hugga dig men du lyckas hoppa undan.";
        } else {
            return "Skelettet tar upp sten från marken och kastar på Hjälten, den missar.";
        }
    }

    @Override
    public String getEntryMessage() { return "Ett skelett reser sig från marken!"; }

    @Override
    public String getKilledByMessage() { 
        return "Skelett dödar hjälte skelettet tar tag i din luftstrupe och drar ut den från din hals. du dör av syrebrist."; }

    @Override
    public String getDeathMessage() { return "Alla benen faller livlöst till marken."; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() { 
        return "Tjuven hugger skelettets huvud och det exploderar."; }

}
