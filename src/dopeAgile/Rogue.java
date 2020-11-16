
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
    public String getAttackHitMessage(Creature creature) {

        Monster monster = (Monster) creature;

        if (monster instanceof Orc) {

            // Kod Orc
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven hugger orcen i bröstet och orcen rytter i smärta. ";
            } else {
                return "Tjuven springer fram och lyckas skära orcen på baksidan av låret så att den faller till marken.";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven kastar en kniv mot spindeln, den träffar och spindeln skriker i smärta.";
            } else {
                return "Tjuven tar sin kniv och hugger av av ena benet på spindeln.";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven hoppar upp i luften och sparkar av skelettets huvud så att det flyger iväg.";
            } else {
                return "Tjuven tacklar skelettet så att det faller till marken.";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven springer fram och hugger trollet i magen, blod sprutar ut från såret.";
            } else {
                return "Tjuven lyckas hugga av ett antal fingrar på trollet.";
            }

        } else {
            return " ";
        }
    }

    @Override
    public String getAttackMissMessage(Creature creature) {
        Monster monster = (Monster) creature;

        if (monster instanceof Orc) {

            // Kod Orc
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven försöker hugga orcen men puttas enkelt undan av orcen.";
            } else {
                return "Tjuven springer fram och försöker skära orcen, men missar.";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven kastar en kniv mot spindeln, spindeln hinner hoppa åt sidan och kniven missar.";
            } else {
                return "Tjuven tar sin kniv och förbereder sig för att attackera spindeln, men spindeln springer iväg.";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven hoppar upp i luften och försöker sparka av skelettets huvud, men missar och faller till marken.";
            } else {
                return "Tjuven försöker tackla skelettet, men det hoppar undan.";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Tjuven springer fram och försöker hugga trollet, men trollet hoppar undan.";
            } else {
                return "Tjuven försöker hugga trollet men sparkas bort. ";
            }

        } else {
            return " ";
        }
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