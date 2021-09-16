package Equipment;

public class Weapon extends Item {

    private int damage;
    private double attackSpeed;

    public enum Type {
        Axe,
        Bow,
        Dagger,
        Hammer,
        Staff,
        Sword,
        Wand
    }

    public Type type;

    public Weapon(String name, Type type,
                  int damage, double attackSpeed,
                  int requiredLevel) {
        super(name, requiredLevel, SlotType.Weapon);
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.type = type;
    }

    public double GetDamagePerSecond()
    {
        return (this.damage * this.attackSpeed);
    }
}

