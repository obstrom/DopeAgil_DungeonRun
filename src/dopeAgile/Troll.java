
package dopeAgile;

public class Troll extends Monster {

    // public static final double COMMON = 0.05;
    public static final double COMMON = 0.15; // HARD MODE

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
        return (conjugate) ? "The Oger" : "Oger";
    }

    @Override
    public String getAttackHitMessage(Creature crature) {
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Oger charges you and slams you in to the wall.";
        } else if (rand < 5) {
            return "Oger throws a rock it hits you and you´re stunned for a second.";
        } else {
            return "Oger rushes, you diden´t reakt in time and got punched hard";
        }
    }

    @Override
    public String getAttackMissMessage(Creature creature) {

        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Oger charges you but misses and slams into the wall behind you";
        } else if (rand < 5) {
            return "Oger throws a rock but it misses you";
        } else {
            return "Oger rushes, but it trips and kisses the floor";
        }
    }

    @Override
    public String getEntryMessage() { return "An Oger apears from the door a head"; }

    @Override
    public String getKilledByMessage() { return "The Oger grabs you by the head and lift you up and breaks you´re neck."; }

    @Override
    public String getDeathMessage() { return "The Oger falls life less to the ground with a loud boom."; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() {
        return "The Theif throws a knife, you hear a cracking sound as the knife hits the knee and the Oger SCREAMS in pain.";
    }

}