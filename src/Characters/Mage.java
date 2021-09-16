package Characters;

import Equipment.Armor;
import Equipment.Weapon;

public class Mage extends BaseCharacter
{
    public Mage(String name) {
        super(name, 1, PrimaryAttributes.AttributType.Intelligence);
        this.levelUpAttributeBoni = new PrimaryAttributes(3, 1, 1, 5);
        this.setAttributes(5,1,1, 8);
        this.allowedArmor = new Armor.Type[]{Armor.Type.Cloth};
        this.allowedWeapons = new Weapon.Type[]{Weapon.Type.Staff, Weapon.Type.Wand};
    }

}
