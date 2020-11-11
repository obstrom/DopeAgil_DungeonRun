package dopeAgile;

import java.util.ArrayList;

public class Combat {

    Character playerCharacter;
    Room currentRoom;
    ArrayList<Monster> allMonsters;
    ArrayList<Creature> allCombatants; // sorted by Initiative

    Combat(Character playerCharacter, ArrayList<Monster> allMonsters, Room currentRoom) {
        this.playerCharacter = playerCharacter;
        this.allMonsters = allMonsters;
        this.currentRoom = currentRoom;
        
        // Add player and monsters to allCombatants
        // TODO: this needs to be sorted on initiative
        allCombatants.add(playerCharacter);
        allCombatants.addAll(allMonsters);

        combatLoop();
    }

    private void combatLoop() {
        // TODO:
        //  1. Check initiatives
        //  2. Highest initiative gets an action
        //   2.1. initiative taker is player
        //    2.1.A Player gets option to ATTACK or FLEE
        //    2.1.B Player picks ATTACK
        //     - Player gets to pick target?
        //     - Target is attacked, check if hit is scored
        //     - SUCCESS -> Target takes 1 dmg -> Check if monster dies
        //     - FAIL -> Print miss message
        //     - Player turn over
        //    2.1.C Player picks FEELING
        //     - Check if fleeing succeeds
        //     - SUCCESS -> Move player back and restore monster health
        //     - FAIL -> Player turn ends and monster turn begins
        //   2.2. initiative taker is monster
        //    2.2.A Monster attacks player
        //     - Monster always targets player
        //     - Target is attacked, check if hit is scored
        //     - SUCCESS -> Player takes 1 dmg (unless ability) -> Check if player dies (GAME OVER)
        //     - FAIL -> Print miss message
        //     - Monster turn over
    }

    private boolean checkCombatantStatus() {
        for (Creature combatant: allCombatants) {
            if (combatant.getCombatEndurance() <= 0) {
                if (combatant instanceof Character) {
                    // TODO: Player died
                    System.out.println("Äventyraren dog!");
                    System.out.println("Död behöver hanteras!");
                } else if (combatant instanceof Monster) {
                    // Monster died
                    // TODO: Print better monster death text?
                    Monster monsterCombatant = (Monster) combatant;
                    System.out.println(monsterCombatant.toString(true) + " faller död ner mot marken.");
                    deallocMonster(monsterCombatant);
                }
            }
        }
        return false; // DEFAULT
    }

    // Removes a monster from all lists it occur in
    // Getting rid off all references to it
    // Effectively de-instancing the monster
    private void deallocMonster(Monster targetMonster) {
        allCombatants.remove(targetMonster);
        allMonsters.remove(targetMonster);
        currentRoom.getRoomMonsters().remove(targetMonster);
    }

    // Method for player to attack given monster
    // Returns boolean. True = monster takes 1 dmg, False = attack misses
    private boolean playerAttackSuccess(Monster targetMonster) {
        int playerAttackScore = playerCharacter.calcAttackScore();
        int monsterEndurance = targetMonster.getEndurance();
        return playerAttackScore > monsterEndurance;
    }

    // Method for monster to attack player
    // Returns boolean. True = monster takes 1 dmg, False = attack misses
    private boolean monsterAttackSuccess(Monster attackingMonster) {
        int monsterAttackScore = attackingMonster.calcAttackScore();
        int playerAgility = playerCharacter.getAgility();
        return monsterAttackScore > playerAgility;
    }

}
