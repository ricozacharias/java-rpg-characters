import Characters.*;
import Equipment.*;
import Equipment.Execptions.*;

public class Main {

    public static void main(String[] args) throws InvalidItemException {

            var warrior = new Warrior("Hero");
            var axe = new Weapon("Holzaxt", Weapon.Type.Axe, 1, 1, 1);
            warrior.addEquipment(axe);

            warrior.printCharacter();


            warrior.levelUp();

            warrior.printCharacter();

            var weapon = new Weapon("Bergspalter", Weapon.Type.Axe, 50, 1, 2);
            var shield1 = new Armor("Lederüstung", Armor.Type.Plate, 1, Item.SlotType.Body,
                    new PrimaryAttributes(10, 1, -1, 0));

            var shield2 = new Armor("Eisenrüstung", Armor.Type.Plate, 1, Item.SlotType.Body,
                    new PrimaryAttributes(10, 1, -1, 0));

            var helm = new Armor("Helm der Erleuchtung", Armor.Type.Plate, 1, Item.SlotType.Head,
                    new PrimaryAttributes(1, 0, 1, 8));

            var greave = new Armor("Beinschienen der Macht", Armor.Type.Plate, 1, Item.SlotType.Legs,
                    new PrimaryAttributes(5, 10, 1, 0));

            warrior.addEquipment(weapon);
            warrior.addEquipment(shield1);
            warrior.addEquipment(shield2);
            warrior.addEquipment(helm);
            warrior.addEquipment(greave);

            warrior.printCharacter();
            warrior.printEquipment();

    }
}
