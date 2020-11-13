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
        return (conjugate) ? "Trollkarlen" : "Trollkarl";
    }

    @Override
    public String getAttackMessage() {
        return "";
    }

    
    
    

    @Override
    public String getAttackHitMessage(Creature creature) {
        
        Monster monster = (Monster) creature;
        
        if (Monster instanceof Orc) {

            // Kod Orc
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Trollkarlen säger en besvärjelse och en magisk pil skapas och avfyras, den träffar orcen i knäet.";
            } else {
                return "Trollkarlen tar sin stav med två händer och svingar underifrån. Den träffar undersidan av orcens haka och orcen faller till marken ";
            }

        } else if (monster instanceof Spider) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Trollkarlen skapar ett eldklot och avfyrar det mot spindeln. Eldklotet träffar, spindeln skriker i smärta.";
            } else {
                return "Trollkarlen tar sin stav med två händer över huvudet och slår ner i mitten av spindelns kropp så att spindel faller platt ner på marken.";
            }

        } else if (monster instanceof Skeleton) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Trollkarlen slår ner sin stav i marken och avfyrar en blixt från sin trollstav, den träffar och skelettet flyger bakåt. ";
            } else {
                return "Trollkarlen tar sin stav med två händer och träffar skelettets huvud så att det flyger iväg. Skelettet springer iväg för hämta sitt huvud.";
            }

        } else if (monster instanceof Troll ) {
            int rand = Utility.throwSixSidedDie(); // random number 1 <-> 6

            if (rand < 4) {
                return "Trollkarlen säger en besvärjelse och en rot växer ut från marken som sedan med sin vassa ände hugger trollet i benet.";
            } else {
                return "Trollkarlen tar sin stav med två händer och använder sin stav som ett spjut och skjuter in änden av staven i trollets bröst så att han faller till marken. ";
            }

        } else {
            return " ";
        }
    }

    @Override
    public String getAttackMissMessage() {
        return "Miss";
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
