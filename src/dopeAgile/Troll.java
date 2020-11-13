package dopeAgile;

public class Troll extends Monster {

    public static final double COMMON = 0.05;

    public Troll() {
        super();
        this.initiative = 2;
        this.endurance = 4;
        this.attack = 7;
        this.agility = 2;
    }

    public static double getCommon() {
        return COMMON;
    }

    @Override
    public String getAttackMessage() {
        return "";
    }

    @Override
    public String getEntryMessage() {
        return "Ett troll kommer in genom en av dörrarna!";
    }

}
