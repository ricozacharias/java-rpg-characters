package Characters;

import Equipment.*;
import Equipment.Execptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Warrior warrior;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Conan");
    }

    @AfterEach
    void tearDown() {
        warrior = null;
    }

    @Test
    void setAttributes_validInput_showAttributes() {
        var attributeType = PrimaryAttributes.AttributType.Strength;
        int expected = 2;

        warrior.setAttributes(1,2,3,4);
        int actual = warrior.getBaseAttribute(attributeType);

        assertEquals(expected, actual);
    }

    @Test
    void getDamagePerSecond_withoutWeapon_shouldThrowException() throws InvalidWeaponException {
        double expect = 1.05;
        double actual = warrior.getDamagePerSecond();

        assertEquals(expect, actual);
    }

    @Test
    void getDamagePerSecond_withValidWeapon_shouldReturnValidDPS() throws InvalidItemException {

        var weapon = new Weapon("Axe", Weapon.Type.Axe, 7, 1.1, 1);
        warrior.addEquipment(weapon);

        double expect = 8.085;
        double actual = warrior.getDamagePerSecond();

        assertEquals(expect, actual);
    }

    @Test
    void getDamagePerSecond_withValidWeaponAndArmor_shouldReturnValidDPS() throws InvalidItemException {

        var weapon = new Weapon("Axe", Weapon.Type.Axe, 7, 1.1, 1);
        warrior.addEquipment(weapon);

        var armor = new Armor("Plate", Armor.Type.Plate, 1, Item.SlotType.Body,
                new PrimaryAttributes(2, 1, 0, 0));
        warrior.addEquipment(armor);

        double expect = 8.162;
        double actual = warrior.getDamagePerSecond();

        assertEquals(expect, actual);
    }

    @Test
    void getBaseAttribute_validInput_returnAttributeValue() {
        var attributeType = PrimaryAttributes.AttributType.Strength;
        int expected = 5;

        int actual = warrior.getBaseAttribute(attributeType);

        assertEquals(expected, actual);
    }

    @Test
    void getTotalAttribute_withoutEquipment_returnBaseValue() {
        int expected = 5;
        int actual = warrior.getTotalAttribute(PrimaryAttributes.AttributType.Strength);

        assertEquals(expected, actual);
    }

    @Test
    void getTotalAttribute_withEquipment_returnBaseValue() throws InvalidItemException {

        var item = new Armor("Harnish", Armor.Type.Mail, 1, Item.SlotType.Body,
                new PrimaryAttributes(1, 3, 1, 1));

        warrior.addEquipment(item);

        int expected = 8; // base 5 + 3 from armor
        int actual = warrior.getTotalAttribute(PrimaryAttributes.AttributType.Strength);

        assertEquals(expected, actual);
    }

    @Test
    void addEquipment_addValidWeapon_shouldReturnTrue() throws InvalidItemException {
        var item = new Weapon("Axe", Weapon.Type.Axe, 1, 1, 1);

        var expected = true;
        var actual = warrior.addEquipment(item);

        assertEquals(expected, actual);
    }

    @Test
    void addEquipment_addInValidWeaponType_shouldFail() throws InvalidItemException {
        var item = new Weapon("Wand", Weapon.Type.Staff, 1, 1, 1);

        assertThrows(InvalidWeaponException.class, () -> {
            warrior.addEquipment(item);
        });
    }

    @Test
    void addEquipment_addValidArmor_shouldReturnTrue() throws InvalidItemException {
        var item = new Armor("Chestplate", Armor.Type.Plate, 1, Item.SlotType.Body,
                new PrimaryAttributes(1,1,1,1));

        var expected = true;
        var actual = warrior.addEquipment(item);

        assertEquals(expected, actual);
    }

    @Test
    void addEquipment_addInvalidArmorType_shouldFail()  {
        var item = new Armor("Cloth", Armor.Type.Cloth, 1, Item.SlotType.Body,
                new PrimaryAttributes(1,1,1,1));

        assertThrows(InvalidArmorException.class, () -> {
            warrior.addEquipment(item);
        });
    }

    @Test
    void addEquipment_addInvalidItem_shouldFail() {
        var item = new Item("Axe", 10, Item.SlotType.Body);

        assertThrows(InvalidItemException.class, () -> {
            warrior.addEquipment(item);
        });
    }

    @Test
    void levelUp_shouldIncrease_characterLevel() {
        int expected = 2;
        warrior.levelUp();
        int actual = warrior.level;

        assertEquals(expected, actual);
    }

    @Test
    void levelUp_shouldIncrease_attributeValue() {
        var attributeType = PrimaryAttributes.AttributType.Strength;
        int expected = 8;
        warrior.levelUp();
        int actual = warrior.getBaseAttribute(attributeType);

        assertEquals(expected, actual);
    }
}