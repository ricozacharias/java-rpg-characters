package Characters;

import Equipment.Armor;
import Equipment.Execptions.InvalidArmorException;
import Equipment.Execptions.InvalidItemException;
import Equipment.Execptions.InvalidWeaponException;
import Equipment.Item;
import Equipment.Weapon;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseCharacter {

    protected PrimaryAttributes.AttributType primaryAttribute; // main attribute type of specific character

    protected String name;
    protected int level;

    protected PrimaryAttributes attributes; // character attribute values
    protected HashMap<Item.SlotType, Item> equipment = new HashMap<>(); // equipped items

    protected Armor.Type[] allowedArmor; // armor which specific character can wear
    protected Weapon.Type[] allowedWeapons; // weapon which specific character can wear
    protected PrimaryAttributes levelUpAttributeBoni;

    // gets character name
    public String getName()
    {
        return this.name;
    }

    // gets character level
    public int getLevel()
    {
        return this.level;
    }

    // initialize character base values
    public BaseCharacter(String name, int level, PrimaryAttributes.AttributType primaryAttribute) {
        this.name = name;
        this.level = level;
        this.primaryAttribute = primaryAttribute;
    }

    // sets characters primary attributes
    public void setAttributes(int vitality, int strength, int dexterity, int intelligence) {
        this.attributes = new PrimaryAttributes(vitality, strength, dexterity, intelligence);
    }

    // calculates characters DPS (damage per second) based on equipped weapon
    public double getDamagePerSecond() throws InvalidWeaponException {

        var weapon = (Weapon) this.equipment.get(Item.SlotType.Weapon);

        double dps = (weapon != null) ? weapon.GetDamagePerSecond() : 1;

        return dps * (1 + (double)this.getTotalAttribute(primaryAttribute) / 100);
    }

    // increase characters level and attribute values
    public void levelUp() {
        this.level++;
        this.attributes.increaseAttributes(this.levelUpAttributeBoni);
    }

    // gets the base character attribute value without attribute bonuses from equipment
    public int getBaseAttribute(PrimaryAttributes.AttributType type)
    {
        return this.attributes.getAttributeValue(type);
    }

    // gets the total character attribute value with added attribute bonuses from equipment
    public int getTotalAttribute(PrimaryAttributes.AttributType type) {
        int value = this.getBaseAttribute(type);

        for(var item : this.equipment.values().stream()
                .filter(x -> x instanceof Armor)
                .collect(Collectors.toList())) {

            value+= ((Armor)item).getAttributeValue(type);
        }

        return value;
    }

    // adds item to equipment and checks if item fits to character (level + type of item)
    public boolean addEquipment(Item item) throws InvalidItemException {
        if (this.level < item.getRequiredLevel())
            throw new InvalidItemException(String.format("Item needs a min character level of %s!", item.getRequiredLevel()));

        if (item instanceof Armor) {
            if (!Arrays.stream(this.allowedArmor).anyMatch(x -> x == ((Armor) item).type))
            throw new InvalidArmorException("Armor not allowed for this character!");
        }
        if (item instanceof Weapon) {
            if (!Arrays.stream(this.allowedWeapons).anyMatch(x -> x == ((Weapon) item).type))
            throw new InvalidWeaponException("Weapon not allowed for this character!");
        }

        this.equipment.put(item.getSlotType(), item);

        return true;
    }

    // shows which slot is equipped with which item
    public void printEquipment() {
        for(Map.Entry<Item.SlotType, Item> entry : this.equipment.entrySet()) {
            Item.SlotType slotType = entry.getKey();
            Item item = entry.getValue();

            System.out.println("Equipment.Slot: "+slotType+" - "+item.getName());
        }
    }

    // shows basic character statistics
    public void printCharacter() throws InvalidItemException {
        StringBuilder sb = new StringBuilder();
        sb.append("NewCharacters.Character name: "+this.getName()+"\n");
        sb.append("NewCharacters.Character level: "+this.getLevel()+"\n");
        sb.append(String.format("Strength: %s (base: %s)\n",
                this.getTotalAttribute(PrimaryAttributes.AttributType.Strength),
                this.getBaseAttribute(PrimaryAttributes.AttributType.Strength)));
        sb.append(String.format("Dexterity: %s (base: %s)\n",
                this.getTotalAttribute(PrimaryAttributes.AttributType.Dexterity),
                this.getBaseAttribute(PrimaryAttributes.AttributType.Dexterity)));
        sb.append(String.format("Intelligence: %s (base: %s)\n",
                this.getTotalAttribute(PrimaryAttributes.AttributType.Intelligence),
                this.getBaseAttribute(PrimaryAttributes.AttributType.Intelligence)));
        sb.append(String.format("Vitality: %s (base: %s)\n",
                this.getTotalAttribute(PrimaryAttributes.AttributType.Vitality),
                this.getBaseAttribute(PrimaryAttributes.AttributType.Vitality)));

        sb.append("DPS: "+this.getDamagePerSecond()+"\n");

        System.out.println(sb);
    }

}

