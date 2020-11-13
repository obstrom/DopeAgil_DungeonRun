F
package dopeAgile;

public class Rouge extends Character {
       
    public Rouge() {
        super();
        this.initiative = 7;
        this.endurance = 5;
        this.attack = 5;
        this.agility = 7;
        setRole(Role.ROUGE);
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