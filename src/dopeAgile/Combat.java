package dopeAgile;

import java.util.ArrayList;
import java.util.Scanner;

public class Combat {

    Character playerCharacter;
    Room currentRoom;
    ArrayList<Monster> allMonsters;
    ArrayList<Creature> allCombatants = new ArrayList<Creature>(); // sorted by Initiative
    boolean playerIsFleeing = false;
    MusicPlayer music = new MusicPlayer();

    Combat(Character playerCharacter, ArrayList<Monster> allMonsters, Room currentRoom) {
        this.playerCharacter = playerCharacter;
        this.allMonsters = allMonsters;
        this.currentRoom = currentRoom;
        
        // Add player and monsters to allCombatants
        allCombatants.add(playerCharacter);
        allCombatants.addAll(allMonsters);

        // TODO: "allCombatants" needs to be sorted on initiative

        boolean playerDead = false;
        while (!allMonsters.isEmpty() && playerCharacter.isAlive() && !playerIsFleeing) {
            combatLoop();
        }
    }

    public boolean isPlayerIsFleeing() {
        return playerIsFleeing;
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

        boolean playerDead = false;
        ArrayList<Monster> killedMonstersDuringRound = new ArrayList<Monster>();

        // Run through all combatants once in initiative order
        for (Creature combatant: allCombatants) {

            if (combatant.isAlive()) {
                // If combatant is the player
                if (combatant instanceof Character) {

                    // Print all monsters in the room
                    System.out.println(ConsoleColors.NEWLINE + "MONSTER:");
                    for (Monster monster: allMonsters) {
                        System.out.println("> " + monster.toString(false) + " - Hälsa " + displayColoredHealth(monster.getCombatEndurance(), monster.getEndurance()) + " | Attackstyrka [" + monster.getAttack() + "]");
                    }

                    // Get user action and check whether it is to attack or flee
                    boolean fightFleeOption = getInputOptionFight();
                    if (fightFleeOption) {

                        // Attack the target
                        combatantAttacks(combatant);

                    } else {

                        // Attempt to flee the room
                        playerIsFleeing = attemptToFlee();

                    }

                // Else if the combatant is a monster
                } else if (combatant instanceof Monster && !playerDead) {
                    // Monster always attacks the player
                    combatantAttacks(combatant);
                }

                // Check if the combatant died
                Creature deadCreature = checkAllCombatantsStatus();
                if (deadCreature instanceof Character) {
                    playerDead = true;
                } else if (deadCreature instanceof Monster) {
                    Monster deadMonster = (Monster) deadCreature;
                    killedMonstersDuringRound.add(deadMonster);
                }

                // Stop for loop if player died
                if (playerDead) {
                    playerCharacter.setIsAlive(false);
                    break;
                }

                // Stop for loop if player is fleeing
                if (playerIsFleeing) {
                    break;
                }

            }

        }

        // If there are killedMonster remove them from lists
        if (!killedMonstersDuringRound.isEmpty()) {
            for (Monster monster: killedMonstersDuringRound) {
                deallocMonster(monster);
            }
            killedMonstersDuringRound.clear();
        }

    }

    // Gets input from player whether to fight or flee
    // Returns true for fight, false for run
    private boolean getInputOptionFight() {
        boolean returnBoolean = false;

        System.out.println(ConsoleColors.NEWLINE + "VÄLJ HANDLING:");
        System.out.println("1. Attackera " + allMonsters.get(0).toString(true));
        System.out.println("2. Fly");
        music.swordSound();

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

    private Creature checkAllCombatantsStatus() {
        Creature deadCreature = null;
        for (Creature combatant: allCombatants) {
            if (combatant.getCombatEndurance() <= 0) {
                if (combatant instanceof Character) {
                    // Player died
                    deadCreature = combatant;

                    // TODO: Print better death text
                    System.out.println(ConsoleColors.RED_BOLD + "Äventyraren dog!" + ConsoleColors.RESET);
                    music.gameOverSound();
                } else if (combatant instanceof Monster) {
                    // Monster died
                    // TODO: Print better monster death text?
                    Monster monsterCombatant = (Monster) combatant;
                    System.out.println(ConsoleColors.ITALIC + ConsoleColors.YELLOW + monsterCombatant.toString(true) + " faller död mot marken." + ConsoleColors.RESET);

                    // Mark monster as dead
                    monsterCombatant.setIsAlive(false);
                    deadCreature = combatant;
                }
            }
        }

        return deadCreature;
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
            Monster targetMonster = allMonsters.get(0); // ALWAYS ATTACK FIRST MONSTER

            combatantPlayer.getAttackMessage();
            Attack playerAttack = new Attack(combatantPlayer, targetMonster);

            System.out.println(ConsoleColors.NEWLINE + combatantPlayer.getName() + " gör sig redo för attack!");

            if (playerAttack.isSuccess()) {

                combatantPlayer.getAttackHitMessage();
                boolean isCrit = combatantPlayer.checkIfCritical();
                if (isCrit) {
                    System.out.println(ConsoleColors.YELLOW_BOLD + combatantPlayer.getName() + " landar en kritisk träff!" + ConsoleColors.RESET);
                    System.out.println(targetMonster.getPlayerCritMessage());
                } else {
                    System.out.print(ConsoleColors.GREEN_BOLD + "Träff!" + ConsoleColors.RESET);
                }

                targetMonster.lowerCombatEndurance(isCrit);

            } else {
                System.out.print(ConsoleColors.RED_BOLD + "Miss" + ConsoleColors.RESET);
            }

            System.out.println(" - " + playerCharacter.getName() + " attackerar för " + ConsoleColors.RED_BOLD + playerAttack.getAttackScore() + ConsoleColors.RESET + " och " + targetMonster.toString(true) + " försvarar sig för " + ConsoleColors.BLUE_BOLD + playerAttack.getDefenseScore() + ConsoleColors.RESET + ".");

        } else if (combatant instanceof Monster) {
            Monster combatantMonster = (Monster) combatant;

            //System.out.println(combatantMonster.getAttackMessage()); // TODO: LÄGG TILL MONSTER ATTACK
            Attack monsterAttack = new Attack(combatantMonster, playerCharacter);

            System.out.println(ConsoleColors.NEWLINE + combatantMonster.toString(true) + " gör sig redo för attack!");

            if (monsterAttack.isSuccess()) {
                System.out.print(ConsoleColors.RED_BOLD + "Träff!" + ConsoleColors.RESET);
                playerCharacter.lowerCombatEndurance();
            } else {
                System.out.print(ConsoleColors.CYAN_BOLD + "Miss" + ConsoleColors.RESET);
            }

            System.out.println(" - Den attackerar för " + ConsoleColors.RED_BOLD + monsterAttack.getAttackScore() + ConsoleColors.RESET + " och du försvarar dig för " + ConsoleColors.BLUE_BOLD + monsterAttack.getDefenseScore() + ConsoleColors.RESET + ".");

            if (monsterAttack.isSuccess() || allCombatants.indexOf(combatant) == allCombatants.size()-1 ) {
                System.out.println(ConsoleColors.NEWLINE + playerCharacter.toString(true) + " " + playerCharacter.getName() + " - Hälsa " + displayColoredHealth(playerCharacter.getCombatEndurance(), playerCharacter.getEndurance()));
            }

        }
    }

    private class Attack {

        private final int attackScore;
        private final int defenseScore;
        private final boolean success;

        Attack(Creature attacker, Creature defender) {
            attackScore = attacker.calcAttackScore();
            defenseScore = defender.calcDefenseScore();
            success = attackScore > defenseScore;
        }

        public int getAttackScore() {
            return attackScore;
        }

        public int getDefenseScore() {
            return defenseScore;
        }

        public boolean isSuccess() {
            return success;
        }
    }

    private String displayColoredHealth(int currentHealth, int maxHealth) {
        String outputString = "(";
        double healthPercentage = ((double) currentHealth) / ((double) maxHealth);
        if (healthPercentage < 0.34) {
            outputString += ConsoleColors.RED_BOLD;
        } else if (healthPercentage < 0.67) {
            outputString += ConsoleColors.YELLOW;
        } else {
            outputString += ConsoleColors.GREEN;
        }
        outputString += currentHealth + "/" + maxHealth + ConsoleColors.RESET + ")";
        return outputString;
    }

    private boolean attemptToFlee() {
        boolean fleeSuccess = false;
        double chanceToFleePercentage = playerCharacter.getAgility() * 0.1;

        if (playerCharacter instanceof Wizard) {
            chanceToFleePercentage = 0.8;
            System.out.println(ConsoleColors.PURPLE_BOLD + "Ljussken: " + playerCharacter.getName() + " bländar fienden med ett starkt magiskt ljus!" + ConsoleColors.RESET);
        }

        if (chanceToFleePercentage > Math.random()) {
            fleeSuccess = true;
            System.out.println(ConsoleColors.GREEN + playerCharacter.getName() + " lyckas fly oskadd från striden.");
            for (Monster monster: allMonsters) {
                monster.refreshCombatEndurance();
            }
        } else {
            System.out.println(ConsoleColors.RED + playerCharacter.getName() + " misslyckades med att fly! Striden fortsätter.");
        }

        return fleeSuccess;
    }

}