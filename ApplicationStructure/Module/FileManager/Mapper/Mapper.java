package ApplicationStructure.Module.FileManager.Mapper;

import ApplicationStructure.Module.StorageStructure.Element.Product.Product;

public interface Mapper<T extends Product> {
    String toInput(T e);
    T toOutput(String str);
}
