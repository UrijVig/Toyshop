package ApplicationStructure.Module.UserHierarchy.AbstractUser;

import ApplicationStructure.Module.FileManager.FileManager;
import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.StorageStructure.Storage.GameStock;
import ApplicationStructure.Module.StorageStructure.Storage.Stock.Stock;

public abstract class User{
    protected FileManager <PlayableToy> fm;
    protected Stock<PlayableToy> stock = new GameStock();

    public User() {
        this.fm = new FileManager<>();
        if (!fm.importDataFromFile().isEmpty()){
            this.stock.merger(fm.importDataFromFile());
        }
    }
    public Stock<PlayableToy> viewProduct(){
        return this.stock;
    }
}