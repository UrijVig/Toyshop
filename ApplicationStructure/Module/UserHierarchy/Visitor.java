package ApplicationStructure.Module.UserHierarchy;

import ApplicationStructure.Module.FileManager.FileManager;
import ApplicationStructure.Module.StorageStructure.Storage.GameStock;
import ApplicationStructure.Module.UserHierarchy.AbstractUser.User;

import java.io.IOException;

public class Visitor extends User {
    public Visitor(User user) throws IOException {
        super();
        this.fm = new FileManager<>();
        this.stock = user.viewProduct();
    }

    public Visitor(GameStock stock) {
        super(stock);
    }

    public Visitor() throws IOException {
        super();
    }
}

