
package dopeAgile;

public class Spider extends Monster {

    //private static final double COMMON = 0.2;
    private static final double COMMON = 0.5; // HARD MODE

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
        return (conjugate) ? "The Gaiantspider" : "Gaiantspider";
    }

    @Override
    public String getAttackHitMessage(Creature creature) {
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "The spider strikes with one of it´s legs and hits the hero.";
        } else if (rand < 5) {
            return "Spider spits a sticky ball of web it hits the hero.";
        } else {
            return "The Spider bites the hero in the arm.";
        }

    }

    @Override
    public String getAttackMissMessage(Creature creature) {

        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "The Spider strikes with one of it´s legs at the hero but it missed.";
        } else if (rand < 5) {
            return "Spider spits a sticky ball of web it lands infron of the hero.";
        } else {
            return "The Spider rushes to bite the hero, but the hero step aside so the spider miss.";
        }
    }

    @Override
    public String getEntryMessage() { return "A nasty big spider drops from the celling!"; }

    @Override
    public String getKilledByMessage() {
        return "The Spider rushes the hero, binds the hero with its webb so it can lay it´s eggs, you died some days later as the eggs hached.."; }

    @Override
    public String getDeathMessage() { return "The Spider makes one last sound befor it dies: SCHREEEEE….."; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() {
        return "The Theif starts to sprint at the spider, then slides under the spider,\n"
                + " with a dagger pointing up and cuts the Sider open so it´s intestens fall out, the Spider: SCHREEEEE… in pain";
    }
    
}
