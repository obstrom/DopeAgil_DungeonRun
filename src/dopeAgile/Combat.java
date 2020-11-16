package dopeAgile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Combat {

    Character playerCharacter;
    Room currentRoom;
    ArrayList<Monster> allMonsters;
    ArrayList<Creature> allCombatants = new ArrayList<Creature>(); // sorted by Initiative
    boolean playerIsFleeing = false;
    MusicPlayer music = new MusicPlayer();

    Combat(Character playerCharacter, ArrayList<Monster> allMonsters, Room currentRoom) throws InterruptedException {
        this.playerCharacter = playerCharacter;
        this.allMonsters = allMonsters;
        this.currentRoom = currentRoom;
        
        // Add player and monsters to allCombatants
        allCombatants.add(playerCharacter);
        allCombatants.addAll(allMonsters);

        if (playerCharacter instanceof Knight) {
            Knight.resetShieldBlock();
        }

        boolean playerDead = false;
        while (!allMonsters.isEmpty() && playerCharacter.isAlive() && !playerIsFleeing) {
            combatLoop();
        }
    }

    public boolean isPlayerIsFleeing() {
        return playerIsFleeing;
    }

    private void combatLoop() throws InterruptedException {

        boolean playerDead = false;
        ArrayList<Monster> killedMonstersDuringRound = new ArrayList<Monster>();

        for (Creature combatant : allCombatants) {
            combatant.calcNewCombatInitiative();
        }

        Collections.sort(allCombatants);

        // Print all monsters in the room
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(ConsoleColors.NEWLINE + "STRIDSORDNING:");
        for (int i = 0; i < allCombatants.size(); i++) {
            Creature thisCombatant = allCombatants.get(i);
            if (thisCombatant instanceof Character) {
                Character player = (Character) thisCombatant;
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("> " + (i+1) + "."
                        + " Initiativpoäng " + ConsoleColors.BLUE + String.format("%02d", player.getCombatRoundInitiativeScore()) + ConsoleColors.RESET
                        //+ " | Attackstyrka " + player.getAttack()
                        + " | Hälsa " + displayColoredHealth(player.getCombatEndurance(), player.getEndurance())
                        + " - " + ConsoleColors.GREEN + player.toString(true) + " " + player.getName() + ConsoleColors.RESET
                );
            } else {
                Monster monster = (Monster) thisCombatant;
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println("> " + (i+1) + "."
                        + " Initiativpoäng " + ConsoleColors.BLUE + String.format("%02d", monster.getCombatRoundInitiativeScore()) + ConsoleColors.RESET
                        //+ " | Attackstyrka " + monster.getAttack()
                        + " | Hälsa " + displayColoredHealth(monster.getCombatEndurance(), monster.getEndurance())
                        + " - " + ConsoleColors.YELLOW + monster.toString(true) + ConsoleColors.RESET
                );
            }
        }

        // Run through all combatants once in initiative order
        for (Creature combatant: allCombatants) {

            if (combatant.isAlive()) {
                // If combatant is the player
                if (combatant instanceof Character) {

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
    private boolean getInputOptionFight() throws InterruptedException {
        boolean returnBoolean = false;

        Monster nextMonster = null;
        if (allCombatants.get(0) instanceof Monster) {
            nextMonster = (Monster) allCombatants.get(0);
        } else {
            nextMonster = (Monster) allCombatants.get(1);
        }

        Thread.sleep(Utility.SLEEPTIME);
        System.out.println(ConsoleColors.NEWLINE + "VÄLJ HANDLING:");
        Thread.sleep(Utility.SLEEPTIME);
        System.out.println("1. Attackera " + nextMonster.toString(true));
        Thread.sleep(Utility.SLEEPTIME);
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

    private Creature checkAllCombatantsStatus() throws InterruptedException {
        Creature deadCreature = null;
        for (Creature combatant: allCombatants) {
            if (combatant.getCombatEndurance() <= 0) {
                if (combatant instanceof Character) {
                    // Player died
                    deadCreature = combatant;

                    // TODO: Print better death text
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println(ConsoleColors.RED_BOLD + "Äventyraren dog!" + ConsoleColors.RESET);
                    music.gameOverSound();
                } else if (combatant instanceof Monster) {
                    // Monster died
                    Monster monsterCombatant = (Monster) combatant;
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.println(ConsoleColors.ITALIC + ConsoleColors.YELLOW + monsterCombatant.getDeathMessage() + ConsoleColors.RESET);

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

    private void combatantAttacks(Creature combatant) throws InterruptedException {
        if (combatant instanceof Character) {
            Character combatantPlayer = (Character) combatant;
            Monster targetMonster = allMonsters.get(0); // ALWAYS ATTACK FIRST MONSTER

            Attack playerAttack = new Attack(combatantPlayer, targetMonster);

            Thread.sleep(Utility.SLEEPTIME);
            System.out.println(ConsoleColors.NEWLINE + combatantPlayer.getName() + " gör sig redo för attack!");

            boolean isCrit = combatantPlayer.checkIfCritical();

            if (playerAttack.isSuccess()) {

                if (isCrit) {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.print(ConsoleColors.YELLOW_BOLD + "Kritiskträff! " + targetMonster.toString(true) + " tar 2 skada." + ConsoleColors.RESET);
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.print(ConsoleColors.GREEN_BOLD + "Träff! " + targetMonster.toString(true) + " tar 1 skada." + ConsoleColors.RESET);
                }

                targetMonster.lowerCombatEndurance(isCrit);

            } else {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.print(ConsoleColors.RED_BOLD + "Miss" + ConsoleColors.RESET);
            }

            Thread.sleep(Utility.SLEEPTIME);
            System.out.println(" - " + playerCharacter.getName() + " attackerar för " + ConsoleColors.RED_BOLD + playerAttack.getAttackScore() + ConsoleColors.RESET + " och " + targetMonster.toString(true) + " försvarar sig för " + ConsoleColors.BLUE_BOLD + playerAttack.getDefenseScore() + ConsoleColors.RESET + ".");

            if (isCrit) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.YELLOW + ConsoleColors.ITALIC + targetMonster.getPlayerCritMessage() + ConsoleColors.RESET);
            } else if (playerAttack.isSuccess()) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.GREEN + ConsoleColors.ITALIC + combatantPlayer.getAttackHitMessage(targetMonster) + ConsoleColors.RESET);
            } else {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.RED + ConsoleColors.ITALIC + combatantPlayer.getAttackMissMessage(targetMonster) + ConsoleColors.RESET);
            }

        } else if (combatant instanceof Monster) {
            Monster combatantMonster = (Monster) combatant;

            Attack monsterAttack = new Attack(combatantMonster, playerCharacter);

            Thread.sleep(Utility.SLEEPTIME);
            System.out.println(ConsoleColors.NEWLINE + combatantMonster.toString(true) + " gör sig redo för attack!");

            boolean shieldBlockUsed = false;

            if (monsterAttack.isSuccess()) {

                if (playerCharacter instanceof Knight && !Knight.isShieldBlockUsed()) {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.print(ConsoleColors.BLUE_BOLD + "Sköldblock! " + ConsoleColors.RESET);
                    shieldBlockUsed = true;
                    Knight.setShieldBlockUsed(true);
                } else {
                    Thread.sleep(Utility.SLEEPTIME);
                    System.out.print(ConsoleColors.RED_BOLD + "Träff! " + playerCharacter.toString(true) + " " + playerCharacter.getName() + " tar 1 skada." + ConsoleColors.RESET);
                    playerCharacter.lowerCombatEndurance();
                }

            } else {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.print(ConsoleColors.CYAN_BOLD + "Miss" + ConsoleColors.RESET);
            }

            if (shieldBlockUsed) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(playerCharacter.getName() + " blockerar " + combatantMonster.toString(true) + "s attack med sin sköld.");
            } else {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(" - " + combatantMonster.toString(true)
                        + " attackerar för " + ConsoleColors.RED_BOLD + monsterAttack.getAttackScore() + ConsoleColors.RESET
                        + " och du försvarar dig för " + ConsoleColors.BLUE_BOLD + monsterAttack.getDefenseScore() + ConsoleColors.RESET + "."
                );
            }

            if (monsterAttack.isSuccess() && !shieldBlockUsed) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.RED + ConsoleColors.ITALIC + combatantMonster.getAttackHitMessage(null) + ConsoleColors.RESET);
            } else if (!monsterAttack.isSuccess() && !shieldBlockUsed) {
                Thread.sleep(Utility.SLEEPTIME);
                System.out.println(ConsoleColors.CYAN + ConsoleColors.ITALIC + combatantMonster.getAttackMissMessage(null) + ConsoleColors.RESET);
            }

            if (monsterAttack.isSuccess() || allCombatants.indexOf(combatant) == allCombatants.size()-1 ) {
                Thread.sleep(Utility.SLEEPTIME);
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

    private boolean attemptToFlee() throws InterruptedException {
        boolean fleeSuccess = false;
        double chanceToFleePercentage = playerCharacter.getAgility() * 0.1;

        if (playerCharacter instanceof Wizard) {
            chanceToFleePercentage = 0.8;
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println(ConsoleColors.PURPLE_BOLD + "Ljussken: " + playerCharacter.getName() + " bländar fienden med ett starkt magiskt ljus!" + ConsoleColors.RESET);
        }

        if (chanceToFleePercentage > Math.random()) {
            fleeSuccess = true;
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println(ConsoleColors.GREEN + playerCharacter.getName() + " lyckas fly oskadd från striden.");
            for (Monster monster: allMonsters) {
                monster.refreshCombatEndurance();
            }
        } else {
            Thread.sleep(Utility.SLEEPTIME);
            System.out.println(ConsoleColors.RED + playerCharacter.getName() + " misslyckades med att fly! Striden fortsätter.");
        }

        return fleeSuccess;
    }

}
