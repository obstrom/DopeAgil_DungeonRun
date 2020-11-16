
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
        return (conjugate) ? "Trollet" : "Troll";
    }

    @Override
    public String getAttackHitMessage(Creature crature) {
        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Trollet skapar ett lazzo av sin svans, svingar det mot dig och lyckas fånga dig.";
        } else if (rand < 5) {
            return "Trollet förtrollar dig så du blir förstenad för en sekund.";
        } else {
            return "Trollet går SNABBT till attack innan du hinner reagera och du får ett slag i magen.";
        }
    }

    @Override
    public String getAttackMissMessage(Creature creature) {

        int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

        if (rand < 3) {
            return "Trollet skapar ett lazzo av sin svans, svingar det mot dig men missar sitt kast.";
        } else if (rand < 5) {
            return "Trollet försöker förtrolla dig, men du hinner undvika dess förtrollning.";
        } else {
            return "Trollet gör sig redo för att slå dig i magen, men du hinner parera slaget.";
        }
    }

    @Override
    public String getEntryMessage() { return "Ett troll kommer in genom en av dörrarna!"; }

    @Override
    public String getKilledByMessage() { return "Trollet lyfter upp dig från huvudet och bryter nacken."; }

    @Override
    public String getDeathMessage() { return "Trollet faller livlös till marken med en hög duns."; }

    @Override
    public String getPlayerHitMessage() { return ""; }

    @Override
    public String getPlayerCritMessage() {
        return "Tjuven kastar en kniv den träffar höftkulan. Trollets ena ben verkar inte vara fungerande längre.";
    }

}