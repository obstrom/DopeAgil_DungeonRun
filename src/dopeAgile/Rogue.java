
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
        return (conjugate) ? "The Theif" : "Theif";
    }

    @Override
    public String getAttackHitMessage(Creature creature) {

        Monster monster = (Monster) creature;

        if (monster instanceof Orc) {

            // Kod Orc
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Theif stabs the ork in the chest and the ork growls in pain. ";
            } else {
                return "The Theif dashes forward gets behind the ork and slashes it´s leg so it falls to the ground.";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Trowing a dagger at the spider, it hits and the spider squells in pain. ";
            } else {
                return "The Theif slahes of a limb of the spider.";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Theif jumps up in the air and kicks of the head of skeleton, so the skull fly´s away like a ball.";
            } else {
                return "The Theif runns at the skeleton and tackles it down to the gorund.";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Theif dashes forward and stabs the oger in the belly, blood flushes out of the wound.";
            } else {
                return "The Theif sprints in and slashes of some finger´s of the oger.";
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
                return "Trying to Stab the ork but it pushes you easly away...";
            } else {
                return "The Theif sprints to get behind the ork but stumbles and you land on you´re back.";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Trowing a dagger at the spider, but the spider jumps to the side.";
            } else {
                return "The Theif draws his dagger and prepar to charge at the spider, but the spider sees this coming and runns away.";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The Theif jumps up and trying to kick the skeleton of the head, but misses and falls to the ground.";
            } else {
                return "The Theif charges the skeleton to tackel it, but stumbles in the charge and faceplants the ground.";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "You run up to the oger and try to stab it, the oger sees this coming and steps to the side.";
            } else {
                return "You try to get closer to the oger, but it push you away. ";
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