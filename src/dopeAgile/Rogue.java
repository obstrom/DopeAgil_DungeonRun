
package dopeAgile;

public class Rogue extends Character {
       
    public Rogue() {
        super();
        this.initiative = 7;
        this.endurance = 5;
        this.attack = 5;
        this.agility = 7;
        setRole(Role.ROGUE);
        super.refreshCombatEndurance();
    }

    public void specialAbility() {

    }

    @Override
    public String toString(boolean conjugate) {
        return (conjugate) ? "Tjuven" : "Tjuv";
    }

    @Override
    public String getAttackMessage() {
        return "";
    }

    @Override
    public String getAttackHitMessage(Creature creature) {
        
        Monster monster = (Monster) creature;
        if (monster instanceof Orc) {

            // Kod Orc
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven hugger orcen i bröstet och orcen ryter i smärta.";
            } else {
                return "Tjuven springer fram och lyckas skära orcen på baksidan av låret så att den faller till marken.";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie();
            
            if (rand < 4) {
                return "Tjuven kastar en kniv mot spindeln, den träffar och spindeln skriker i smärta.";
            } else {
                return "Tjuven kastar en kniv mot spindeln, spindeln hinner hoppa åt sidan och kniven missar.";
            }


        } else if (monster instanceof Skeleton) {


        } else if (monster instanceof Troll ) {


        } else {
            return "";
        }
        return"";
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