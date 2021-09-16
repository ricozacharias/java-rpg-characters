package Characters;

import Equipment.Armor;
import Equipment.Weapon;

public class Warrior extends BaseCharacter {

    public Warrior(String name) {
        super(name, 1, PrimaryAttributes.AttributType.Strength);
        this.levelUpAttributeBoni = new PrimaryAttributes(5, 3, 2, 1);
        this.setAttributes(10,5,2,1);
        this.allowedArmor = new Armor.Type[]{Armor.Type.Mail, Armor.Type.Plate};
        this.allowedWeapons = new Weapon.Type[]{Weapon.Type.Axe, Weapon.Type.Hammer, Weapon.Type.Sword};
    }

}
