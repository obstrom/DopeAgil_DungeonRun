
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
        return (conjugate) ? "Orcen" : "Orc";
    }

    @Override
    public String getAttackHitMessage(Creature creature) {
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Orcen tar sats, hoppar på dig och biter dig med sina huggtänder.";
        } else if (rand < 5) {
            return "Orcen tar upp sin yxa, kastar den mot dig och träffar dig i låret.";
        } else {
            return "Orcen tar upp en öltunna, lyfter den över sitt huvud och kastar den på dig.";
        }
    }

    @Override
    public String getAttackMissMessage(Creature creature) {
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Orcen hoppar mot dig för att bita dig med sina kraftiga huggtänder, men du hinner slänga dig åt sidan.";
        } else if (rand < 5) {
            return "Orcen tar upp sin yxa, kastar den mot dig, du hinner precis kasta dig bakom en pelare. ";
        } else {
            return "Orcen tar upp en öltunna, lyfter den över sitt huvud och kastar mot dig men missar.";
        }
    }

    @Override
    public String getEntryMessage() { return "En orc kommer ut ur skuggan!"; }

    @Override
    public String getKilledByMessage() { return "Orcen tar strypgrepp på dig, biter av halspulsådern och du förblöder till döds."; }

    @Override
    public String getDeathMessage() { return "Orcen ryter och faller livlöst till marken."; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() {
        return "Tjuven kastar en kniv och träffar ena ögat, orcen skriker i smärta.";
    }

}