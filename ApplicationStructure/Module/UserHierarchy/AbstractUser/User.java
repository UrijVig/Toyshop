package ApplicationStructure.Module.UserHierarchy.AbstractUser;

import ApplicationStructure.Module.FileManager.FileManager;
import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.StorageStructure.Storage.GameStock;

import java.io.IOException;

public abstract class User{
    protected FileManager<PlayableToy> fm;
    protected GameStock stock;


    public User(GameStock stock) {
        this.fm = new FileManager<>();
        this.stock = stock;
    }

    public User() throws IOException {
        this.fm = new FileManager<>();
        this.stock = new GameStock();
        this.stock.merger(fm.importDataFromFile());
    }

    public void setStock(GameStock stock) {
        this.stock = stock;
    }

    public GameStock viewProduct() {
        return this.stock;
    }

}
