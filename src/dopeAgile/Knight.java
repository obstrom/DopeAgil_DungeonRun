
package dopeAgile;

public class Knight extends Character {

    private static boolean shieldBlockUsed = false;

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
        return (conjugate) ? "The Knight" : "Knight";
    }

    @Override
    public String getAttackHitMessage(Creature creature) {
        Monster monster = (Monster) creature;

        if (monster instanceof Orc) {

            // Kod Orc
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The knight grabs the ork, headbutt it right in the face.";
            } else {
                return "The knight draws his sword, stabs the ork in the leg. ";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The knight grabs his sword and cutts of a limb on the spider. ";
            } else {
                return "The knight draws the blade, takes out one of the spiders eyes. ";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Bashing the skeleton with the shield. ";
            } else {
                return "Knight kicks the skeleton, so it falls to the ground. ";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "The knight kicks oger, in the chest and it falls backwards. ";
            } else {
                return "Kight draws the sword, slashes the belly on oger, blood flushes out. ";
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
                return "The Knight is trying to grab the ork to headbutt it, but the ork doges away. ";
            } else {
                return " the sword swing misses the ork. ";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Kight trying to poke out one of the spiders eyes, spider moves away from the blow. ";
            } else {
                return "Swings the Sword at the spider but the spider dodges the swing.";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Trying to bash the skeleton with the shield, but the kight stumbles in the charge and misses. ";
            } else {
                return "The knight stumbles when trying to kick the skelleton and falls to the gound instead.  ";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "You slipp when trying to kick the oger and miss.";
            } else {
                return "Swings the sword, aims for the belly of the oger but you miss.";
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

    public static boolean isShieldBlockUsed() {
        return shieldBlockUsed;
    }

    public static void setShieldBlockUsed(boolean shieldBlockUsed) {
        Knight.shieldBlockUsed = shieldBlockUsed;
    }

    public static void resetShieldBlock() {
        shieldBlockUsed = false;
    }

}
