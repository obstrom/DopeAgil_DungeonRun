
package dopeAgile;

public class Orc extends Monster {

    // public static final double COMMON = 0.1;
    public static final double COMMON = 0.3; // HARD MODE

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
        return (conjugate) ? "The Ork" : "Ork";
    }

    @Override
    public String getAttackHitMessage(Creature creature) {
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "The Ork jumps on top of you and bites you with its shap teeth.";
        } else if (rand < 5) {
            return "Ork throws it´s axe at you and hits your leg and you start to bleed.";
        } else {
            return "The Orke charges you with its axe at the ready, and strikes you.";
        }
    }

    @Override
    public String getAttackMissMessage(Creature creature) {
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "THe Ork jumps at you, but you saw it coming and gracefuly step out of it´s attack.";
        } else if (rand < 5) {
            return "Ork throws it´s axe at you and it hits the wall behind you. ";
        } else {
            return "The Ork charges you with its axe at the ready, and during the charge the ork fails to see the indent on the ground and faceplants hard.";
        }
    }

    @Override
    public String getEntryMessage() { return "A Big Ork steps out of the shadow´s!"; }

    @Override
    public String getKilledByMessage() { return "The Ork bites you by the neck and you sufficate by you´re own blood."; }

    @Override
    public String getDeathMessage() { return "The Ork grows as it falls life less to the ground."; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() {
        return "The Thef throws a knife at the Ork and hit´s one of it´s eyes, the Ork SCREAMS IN PAIN.";
    }

}