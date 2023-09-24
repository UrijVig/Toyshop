package ApplicationStructure.Module.StorageStructure.Storage.Stock;

import ApplicationStructure.Module.StorageStructure.Element.Product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Stock<T extends Product> implements Iterable<T> {
    protected List<T> data;

    public Stock(List<T> data) {
        this.data = data;
    }

    public Stock() {
        this.data = new LinkedList<>();
    }

    public void add(T item) {
        this.data.add(item);
    }

    public List<T> readAll() {
        return this.data;
    }

    public void delete(String nameItem) {
        this.data.removeIf(item -> item.getName().equals(nameItem));
    }

    public void delete(String nameItem, int number) {
        for (T item : this.data) {
            if (item.getName().equals(nameItem)) {
                item.setAmount(item.getAmount() - number);
                if (item.getAmount() == 0) {
                    this.delete(item.getName());
                }
                return;
            }
        }
    }

    public void updateName(String nameItem, String newName) {
        for (T item : this.data) {
            if (item.getName().equals(nameItem)) {
                item.setName(newName);
            }
        }
    }

    public void updateAmount(String nameItem, int newAmount) {
        for (T item : this.data) {
            if (item.getName().equals(nameItem)) {
                item.setAmount(newAmount);
                if (item.getAmount() == 0) {
                    this.delete(item.getName());
                }
                return;
            }
        }
    }

    public void updateAmount(String nameItem) {
        this.delete(nameItem, 1);
    }

    public T get(int idx) {
        return this.data.get(idx);
    }

    public void merger(List<T> data) {
        this.data.addAll(data);
    }

    @Override
    public Iterator<T> iterator() {
        return new StockIterator<>(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock<?>)) return false;

        return data.equals(o);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        String result = null;
        for (T item : data) {
            result += item.toString() + '\n';
        }
        return result;
    }

    public int size() {
        return this.data.size();
    }
}
