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
        return (conjugate) ? "The Wizard" : "Wizard";
    }

    @Override
    public String getAttackHitMessage(Creature creature) {

        Monster monster = (Monster) creature;

        if (monster instanceof Orc) {

            // Kod Orc
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Wizard is conuring a spell, an arcane arrrow apears and hits the ork in the knee.";
            } else {
                return "The Wizard swings around the staff, it hits the ork under the chin the ork falls to the ground confuesd. ";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Wizard conuring a fire spell, a ball of fire apears in the hand of the Wizard and throws it at the spider, it hits and the spider squells in pain.";
            } else {
                return "The Wizard swings the staff ower the head and slams the spider on its back, the spider falls flat on the ground.";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Wizard strikes the back end of the staff in the ground and it sends out a bolt of lighting that strikes the skeleton so hard that it fly´s backwards. ";
            } else {
                return "Wizard uses his staff like a baseball bat, swings it at the skeleton and hits its skull clean of and it fly´s of in the distance.";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Wizard conuring a spell, a chilly frezing fog apears the fog turns in to a floating sharp shard of ice it hits the leg of the oger and blood flushes out of the wound.";
            } else {
                return "Wizard is couning a rooky spike on the top end of the staff and pokes the oger in the chest, the spike explodes and the oger falls to the ground on its back. ";
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
                return "Wizard is conuring a spell, a arcane arrow apears and fires away at the ork, it lands in front of its intended target and the ork looks at you and start to laught at you.";
            } else {
                return "The Wizard swing the staff around and hits the celling, the ork just looks at you with a grin. ";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Wizard conuring a fire spell, a ball of fire apears in the hand of the Wizard and fires it at the spider, but you aimed to high and it flyes ower the spider and hits the wall behind it. ";
            } else {
                return "Wizard swings the staff apove and tryies to smash the spider, the spider moves away and the strike hits the ground";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Wizard Srikes the back end of the staff in the ground a bolt of lightning apears and stirkes at the skeleton, but it passes and hits the wall behind the skeleton. ";
            } else {
                return "Wizard swings his staff like a baseball bat, takes aim at the skull of the skeleton but, trips druing the swing and lands on the butt. ";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Wizard conuring a spell that apears under the oger a root grows up but the oger eats it. ";
            } else {
                return "Wizard is conuring a rock spike on the top side of his staff and try to poke the oger, but tripps on the mentel instead and the spike shatters when it tuches the ground.  ";
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
