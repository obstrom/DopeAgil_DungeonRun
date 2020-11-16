
package dopeAgile;

public class Knight extends Character {

    public Knight() {
        super();
        initiative = 5;
        endurance = 9;
        attack = 6;
        agility = 4;
        setRole(Role.KNIGHT);
        super.refreshCombatEndurance();
    }
    
    public void specialAbility() {
        
    }

    @Override
    public String toString(boolean conjugate) {
        return (conjugate) ? "Riddaren" : "Riddare";
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
                return "Riddaren tar tag i orcen och skallar den med sin hjälm.";
            } else {
                return "Riddaren tar sitt svärd, hugger och träffar höften på orcen. ";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Riddaren tar sitt svärd och hugger av ett av benen på spindeln. ";
            } else {
                return "Riddaren tar sitt svärd spetsar ut ett av ögonen på spindeln. ";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Riddaren tar sin sköld och slår till skelettet. ";
            } else {
                return "Riddaren sparkar skelettet så att det faller ner till marken. ";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Riddaren sparkar trollet i bröstet så att det faller bakåt. ";
            } else {
                return "Riddaren tar sitt svärd och hugger mot magen, den träffar och blod sprutar ut. ";
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
                return "Riddaren tar tag i orcen för att skalla den, men orcen hinner ducka. ";
            } else {
                return "Riddaren tar sitt svärd och missar sitt hugg. ";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Riddaren försöker spetsa ett av ögonen på spindeln men missar. ";
            } else {
                return "Riddaren tar sitt svärd och försöker hugga av ett av benen, men missar.";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Riddaren försöker slå skelettet med sin sköld, men missar. ";
            } else {
                return "Riddaren försöker sparka skelettet men snubblar och faller ner till marken.  ";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Riddaren försöker sparka trollet men halkar och missar.";
            } else {
                return "Riddaren tar sitt svärd och hugger mot magen, men missar.";
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
