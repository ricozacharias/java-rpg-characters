package Characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactersTest {

    @Test
    void mageLevelUp_increaseLevel_showIncreasedLevel() {
        var hero = new Mage("Hero");

        hero.levelUp();

        int expected = 2;
        int actual = hero.getLevel();

        assertEquals(expected, actual);
    }

    @Test
    void rogueLevelUp_increaseLevel_showIncreasedLevel() {
        var hero = new Rogue("Hero");

        hero.levelUp();

        int expected = 2;
        int actual = hero.getLevel();

        assertEquals(expected, actual);
    }

    @Test
    void rangerLevelUp_increaseLevel_showIncreasedLevel() {
        var hero = new Rogue("Hero");

        hero.levelUp();

        int expected = 2;
        int actual = hero.getLevel();

        assertEquals(expected, actual);
    }

    @Test
    void warriorLevelUp_increaseLevel_showIncreasedLevel() {
        var hero = new Warrior("Hero");

        hero.levelUp();

        int expected = 2;
        int actual = hero.getLevel();

        assertEquals(expected, actual);
    }

    @Test
    void warriorLevelUp_increaseAttributes_showAttributesIncreased() {
        var hero = new Warrior("Hero");

        hero.levelUp();

        int[] expected = { 15, 8, 4, 2 }; // [10, 5, 2, 1] + [5, 3, 2, 1]

        int vit = hero.getBaseAttribute(PrimaryAttributes.AttributType.Vitality);
        int str = hero.getBaseAttribute(PrimaryAttributes.AttributType.Strength);
        int dex = hero.getBaseAttribute(PrimaryAttributes.AttributType.Dexterity);
        int itl = hero.getBaseAttribute(PrimaryAttributes.AttributType.Intelligence);

        int[] actual = { vit, str, dex, itl };

        assertArrayEquals(expected, actual);
    }

    @Test
    void mageLevelUp_increaseAttributes_showAttributesIncreased() {
        var hero = new Mage("Hero");

        hero.levelUp();

        int[] expected = { 8, 2, 2, 13 }; // [5, 1, 1, 8] + [3, 1, 1, 5]

        int vit = hero.getBaseAttribute(PrimaryAttributes.AttributType.Vitality);
        int str = hero.getBaseAttribute(PrimaryAttributes.AttributType.Strength);
        int dex = hero.getBaseAttribute(PrimaryAttributes.AttributType.Dexterity);
        int itl = hero.getBaseAttribute(PrimaryAttributes.AttributType.Intelligence);

        int[] actual = { vit, str, dex, itl };

        assertArrayEquals(expected, actual);
    }

    @Test
    void rangerLevelUp_increaseAttributes_showAttributesIncreased() {
        var hero = new Ranger("Hero");

        hero.levelUp();

        int[] expected = { 11, 2, 12, 2 }; // [8, 1, 7, 1] + [3, 1, 5, 1]

        int vit = hero.getBaseAttribute(PrimaryAttributes.AttributType.Vitality);
        int str = hero.getBaseAttribute(PrimaryAttributes.AttributType.Strength);
        int dex = hero.getBaseAttribute(PrimaryAttributes.AttributType.Dexterity);
        int itl = hero.getBaseAttribute(PrimaryAttributes.AttributType.Intelligence);

        int[] actual = { vit, str, dex, itl };

        assertArrayEquals(expected, actual);
    }

    @Test
    void rogueLevelUp_increaseAttributes_showAttributesIncreased() {
        var hero = new Rogue("Hero");

        hero.levelUp();

        int[] expected = { 11, 3, 10, 2 }; // [8, 2, 6, 1] + [3, 1, 4, 1]

        int vit = hero.getBaseAttribute(PrimaryAttributes.AttributType.Vitality);
        int str = hero.getBaseAttribute(PrimaryAttributes.AttributType.Strength);
        int dex = hero.getBaseAttribute(PrimaryAttributes.AttributType.Dexterity);
        int itl = hero.getBaseAttribute(PrimaryAttributes.AttributType.Intelligence);

        int[] actual = { vit, str, dex, itl };

        assertArrayEquals(expected, actual);
    }
}
