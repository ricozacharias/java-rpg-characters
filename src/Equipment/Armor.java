package Equipment;

import Characters.PrimaryAttributes;

public class Armor extends Item {

    protected PrimaryAttributes attributBoni;

    public enum Type {
        Cloth,
        Leather,
        Mail,
        Plate
    }

    public Type type;

    public Armor(String name, Type type, int requiredLevel, SlotType slot, PrimaryAttributes attributBoni) {
        super(name, requiredLevel, slot);
        this.attributBoni = attributBoni;
        this.type = type;
    }

    public int getAttributeValue(PrimaryAttributes.AttributType type)
    {
        return this.attributBoni.getAttributeValue(type);
    }
}

