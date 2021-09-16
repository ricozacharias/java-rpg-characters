package Characters;

import Equipment.Armor;
import Equipment.Weapon;

public class Ranger extends BaseCharacter
{
    public Ranger(String name) {
        super(name, 1, PrimaryAttributes.AttributType.Dexterity);
        this.levelUpAttributeBoni = new PrimaryAttributes(3, 1, 5, 1);
        this.setAttributes(8,1,7, 1);
        this.allowedArmor = new Armor.Type[]{Armor.Type.Mail, Armor.Type.Leather};
        this.allowedWeapons = new Weapon.Type[]{Weapon.Type.Bow};
    }

}
