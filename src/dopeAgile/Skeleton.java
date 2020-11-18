
package dopeAgile;

public class Skeleton extends Monster {

    //public static final double COMMON = 0.15;
    public static final double COMMON = 0.4; // HARD MODE

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
        return (conjugate) ? "The Skeleton" : "Skeleton";
    }

    @Override
    public String getAttackHitMessage(Creature creature) {

        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Skeleton, throws its rusty sheild at you, it hits";
        } else if (rand < 5) {
            return "The Skeleton Strikes you with it´s rusty sword, you start to bleed.";
        } else {
            return "Skeleton picks up a rock from the ground and then throws it at the Hero, it hits.";
        }
    }

    @Override
    public String getAttackMissMessage(Creature creature) {

        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Skeleton, throws its rusty shield at you, but it lands infron of you.";
        } else if (rand < 5) {
            return "The Skeleton strikes at you with it´s rusty sword but you parried it.";
        } else {
            return "Skeleton picks up a rock from the ground and then throws it but it missed you by a mile.";
        }
    }

    @Override
    public String getEntryMessage() { return "A Skeleton rise from the groud!"; }

    @Override
    public String getKilledByMessage() {
        return "The Skeleton grabs you by your neck and ripps out your spine, you die SCREAMING."; }

    @Override
    public String getDeathMessage() { return "The Skeleton becomes a pile of life less bones."; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() {
        return "The Theif stricks the skeleton so hard that it´s bones shatter.";
    }

}
