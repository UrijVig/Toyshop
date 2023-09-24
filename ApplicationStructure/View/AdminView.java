package ApplicationStructure.View;

import ApplicationStructure.Controller.AdminController;
import ApplicationStructure.Module.StorageStructure.Storage.GameStock;
import ApplicationStructure.Module.UserHierarchy.AbstractUser.User;
import ApplicationStructure.Module.UserHierarchy.Admin;

public class AdminView {
    private final AdminController adminCtrl;
    private final Admin admin;

    public AdminView(User visitor) {
        this.adminCtrl = new AdminController();
        this.admin = new Admin(visitor);
    }

    public GameStock runAdminRole() {
        System.out.print("\033[H\033[2J");
        System.out.println(admin.viewProduct());
        return this.admin.viewProduct();
    }
}
