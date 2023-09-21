package ApplicationStructure.Module.StorageStructure.Storage.Stock;

import ApplicationStructure.Module.StorageStructure.Element.Product.Product;

import java.util.Iterator;

public class StockIterator<T extends Product> implements Iterator<T> {

    private final Stock<T> stock;
    private int index;

    public StockIterator(Stock<T> stock) {
        this.stock = stock;
    }

    @Override
    public boolean hasNext() {
        return index < stock.readAll().size();
    }

    @Override
    public T next() {
        return stock.readAll().get(index++);
    }
}
