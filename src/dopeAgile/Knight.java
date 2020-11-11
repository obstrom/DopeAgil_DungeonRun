
package dopeAgile;


public class Knight extends Character {

    public Knight(){
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
    public void setRole(Role newRole) {
        super.role = newRole;
    }

    @Override
    public Role getRole() {
        return super.role;
    }

}
