
package dopeAgile;

public class Wizard extends Character {

    public Wizard(){
        super();
        initiative = 6;
        endurance = 4;
        attack = 9;
        agility = 5;
        setRole(Role.WIZARD);
    }
    
    public void specialAbility() {
        
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
