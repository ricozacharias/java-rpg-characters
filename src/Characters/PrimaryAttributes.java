package Characters;

import java.util.HashMap;

public class PrimaryAttributes {

    public enum AttributType{
        Vitality,
        Strength,
        Dexterity,
        Intelligence
    }

    private HashMap<AttributType, Integer> attributes = new HashMap<>();

    public PrimaryAttributes(int vitality, int strength, int dexterity, int intelligence)
    {
        setAttributeValue(AttributType.Vitality, vitality);
        setAttributeValue(AttributType.Strength, strength);
        setAttributeValue(AttributType.Dexterity, dexterity);
        setAttributeValue(AttributType.Intelligence, intelligence);
    }

    public int getAttributeValue(AttributType type)
    {
        return attributes.get(type);
    }

    public void setAttributeValue(AttributType type, int value)
    {
        attributes.put(type, value);
    }

    public void increaseAttributes(PrimaryAttributes attributeBoni)
    {
        increaseAttributes(attributeBoni.getAttributeValue(AttributType.Vitality),
                attributeBoni.getAttributeValue(AttributType.Strength),
                attributeBoni.getAttributeValue(AttributType.Dexterity),
                attributeBoni.getAttributeValue(AttributType.Intelligence)
        );
    }

    public void increaseAttributes(int vitality, int strength, int dexterity, int intelligence)
    {
        this.setAttributeValue(AttributType.Vitality, this.getAttributeValue(AttributType.Vitality) + vitality);
        this.setAttributeValue(AttributType.Strength, this.getAttributeValue(AttributType.Strength) + strength);
        this.setAttributeValue(AttributType.Dexterity, this.getAttributeValue(AttributType.Dexterity) + dexterity);
        this.setAttributeValue(AttributType.Intelligence, this.getAttributeValue(AttributType.Intelligence) + intelligence);
    }
}
