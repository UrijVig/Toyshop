package ApplicationStructure.Module.StorageStructure.Element;

import ApplicationStructure.Module.StorageStructure.Element.Product.Product;

public class PlayableToy extends Product{
private int id;
private double chance;
    public PlayableToy(String name, int amount) {
        super(name, amount);
        this.id = Product.getIdx();
        this.chance = 1;
    }

    public int getId() {
        return id;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    @Override
    public String toString() {
        return "PlayableToy{" + "id=" + id + ", name='" + name + '\'' + ", amount=" + amount + ", chance=" + chance + '}';
    }
}
