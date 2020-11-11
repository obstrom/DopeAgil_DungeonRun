
package dopeAgile;

public class Wizard extends Character {

    public Wizard(){
        super();
        initiative = 6;
        endurance = 4;
        attack = 9;
        agility = 5;
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
    public void setRole(Role newRole) {
        super.role = newRole;
    }

    @Override
    public Role getRole() {
        return super.role;
    }

}
