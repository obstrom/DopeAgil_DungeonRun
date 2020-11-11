package dopeAgile;

import java.util.ArrayList;
import java.util.Scanner;

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
        allCombatants.add(playerCharacter);
        allCombatants.addAll(allMonsters);

        // TODO: "allCombatants" needs to be sorted on initiative

        while (!allMonsters.isEmpty()) {
            combatLoop();
        }
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

        Boolean playerDead = false;

        // Run through all combatants once in initiative order
        for (Creature combatant: allCombatants) {

            if (combatant instanceof Character) {
                System.out.println("\nMONSTER:");
                for (Monster monster: allMonsters) {
                    System.out.println("> " + monster.toString(false) + " - HP[" + monster.getCombatEndurance() + "/" + monster.getEndurance() + "] | ATK[" + monster.getAttack() + "]");
                }

                boolean fightFleeOption = getInputOptionFight();
                if (fightFleeOption) {
                    // TODO: ASK FOR TARGET?
                    combatantAttacks(combatant);
                    playerDead = checkAllCombatantsStatus();
                } else {
                    // TODO: FLEE
                }
            } else if (combatant instanceof Monster && !playerDead) {

                // TODO: HANDLE MONSTER TURN

            }

        }
    }

    // Gets input from player whether to fight or flee
    // Returns true for fight, false for run
    private boolean getInputOptionFight() {
        boolean returnBoolean = false;

        System.out.println("\nVÄLJ HANDLING:");
        System.out.println("1. Attackera");
        System.out.println("2. Fly");

        for (int i = 0; i < 1; i++) {
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine().toLowerCase();

            if (userInput.equals("1") || userInput.contains("attack")) {
                returnBoolean = true;
            } else if (userInput.equals("2") || userInput.contains("fly")) {
                returnBoolean = false;
            } else {
                System.out.println("Ogiltigt kommando! Försök igen.");
                --i;
            }

        }

        return returnBoolean;
    }

    private boolean checkAllCombatantsStatus() {
        boolean playerDied = false;
        for (Creature combatant: allCombatants) {
            if (combatant.getCombatEndurance() <= 0) {
                if (combatant instanceof Character) {
                    // TODO: Player died
                    playerDied = true;
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
        return playerDied;
    }

    // Removes a monster from all lists it occur in
    // Getting rid off all references to it
    // Effectively de-instancing the monster
    private void deallocMonster(Monster targetMonster) {
        allCombatants.remove(targetMonster);
        allMonsters.remove(targetMonster);
        currentRoom.getRoomMonsters().remove(targetMonster);
    }

    private void combatantAttacks(Creature combatant) {
        if (combatant instanceof Character) {
            Character combatantPlayer = (Character) combatant;
            Boolean attackSuccess = playerAttackSuccess(allMonsters.get(0)); // ALWAYS TAKES FIRST MONSTER
        } else if (combatant instanceof Monster) {
            Monster combatantMonster = (Monster) combatant;
            Boolean attackSuccess = monsterAttackSuccess(combatantMonster);
        }
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