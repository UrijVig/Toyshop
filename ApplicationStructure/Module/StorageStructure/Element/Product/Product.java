package ApplicationStructure.Module.StorageStructure.Element.Product;

public class Product {
    private static int idx = 0;
    protected String name;
    protected int amount;

    public Product(String name, int amount) {
        Product.idx++;
        this.name = name;
        this.amount = amount;
    }

    public static int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
