package dopeAgile;

import java.util.ArrayList;

public class Combat {

    Character playerCharacter;
    ArrayList<Monster> allMonsters;

    Combat(Character playerCharacter, ArrayList<Monster> allMonsters) {
        this.playerCharacter = playerCharacter;
        this.allMonsters = allMonsters;
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
