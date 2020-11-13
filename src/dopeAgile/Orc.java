package dopeAgile;

public class Orc extends Monster {

    public static final double COMMON = 0.1;

    public Orc() {
        super();
        this.initiative = 6;
        this.endurance = 3;
        this.attack = 4;
        this.agility = 4;
    }

    public static double getCommon() {
        return COMMON;
    }

    @Override
    public String getAttackMessage() {
        return "Orc";
    }

    @Override
    public String getEntryMessage() {
        return "En orc kommer ut ur skuggan!";
    }
}
