package dopeAgile;

public class Wizard extends Character {

    public Wizard() {
        super();
        this.initiative = 6;
        this.endurance = 4;
        this.attack = 9;
        this.agility = 5;
        setRole(Role.WIZARD);
        super.refreshCombatEndurance();
    }

    public void specialAbility() {

    }

    @Override
    public String toString(boolean conjugate) {
        return (conjugate) ? "Trollkarlen" : "Trollkarl";
    }

    @Override
    public String getAttackMessage() {
        return "";
    }

    /*
    @Override
    public String getAttackMessage(Monster monster) {

        if (monster instanceof Orc) {

            // Kod Orc
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Här är Orc attack 1";
            } else {
                return "Här är Orc attack 2";
            }

        } else if (monster instanceof Spider) {


        } else if (monster instanceof Skeleton) {


        } else if (monster instanceof Troll ) {


        } else {
            return "";
        }

    }
    */

    @Override
    public String getAttackHitMessage() {
        return "Hit";
    }

    @Override
    public String getAttackMissMessage() {
        return "Miss";
    }

    @Override
    public void setRole(Role newRole) {
        super.role = newRole;
    }

    @Override
    public Role getRole() {
        return super.role;
    }

}
