package Equipment;

public class Item {

    public enum SlotType {
        Head,
        Body,
        Legs,
        Weapon
    }

    protected String name;
    protected int requiredLevel;
    protected SlotType slotType;

    public Item(String name, int requiredLevel, SlotType slot)
    {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slotType = slot;
    }

    public String getName() {
        return this.name;
    }

    public int getRequiredLevel() {
        return this.requiredLevel;
    }

    public SlotType getSlotType() {
        return this.slotType;
    }

}

