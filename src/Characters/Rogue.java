package Characters;

import Equipment.Armor;
import Equipment.Weapon;

public class Rogue extends BaseCharacter
{
    public Rogue(String name) {
        super(name, 1, PrimaryAttributes.AttributType.Dexterity);
        this.levelUpAttributeBoni = new PrimaryAttributes(3, 1, 4, 1);
        this.setAttributes(8,2,6, 1);
        this.allowedArmor = new Armor.Type[]{Armor.Type.Mail, Armor.Type.Leather};
        this.allowedWeapons = new Weapon.Type[]{Weapon.Type.Dagger, Weapon.Type.Sword};
    }

}
