package Characters;

import Equipment.Execptions.InvalidWeaponException;
import Equipment.Item;

public class Warlock extends BaseCharacter {

    public Warlock(String name) {
        super(name, 20, null);
        this.levelUpAttributeBoni = new PrimaryAttributes(10, 8, 5, 3);
        this.setAttributes(100,80,60, 40);
    }

    @Override
    public double getDamagePerSecond() throws InvalidWeaponException {
        return super.getDamagePerSecond() + 100; // gets a 100 points damage boni
    }

    @Override
    public boolean addEquipment(Item item) // can wear every item
    {
        this.equipment.put(item.getSlotType(), item);
        return true;
    }

    @Override
    public void levelUp() {
        super.levelUp();
    }
}
