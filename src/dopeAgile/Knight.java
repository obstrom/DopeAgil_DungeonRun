package dopeAgile;

public class Knight extends Character {

    public Knight() {
        super();
        this.initiative = 5;
        this.endurance = 9;
        this.attack = 6;
        this.agility = 4;
        setRole(Role.KNIGHT);

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
