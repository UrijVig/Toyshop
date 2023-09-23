package ApplicationStructure.View;

import ApplicationStructure.Controller.AdminController;
import ApplicationStructure.Module.UserHierarchy.Admin;

public class AdminView {
    private AdminController adminCtrl;
    private final Admin admin;
    public AdminView() {
        this.adminCtrl = new AdminController();
        this.admin = new Admin();
    }

    public void runAdminRole(){
        System.out.print("\033[H\033[2J");
        System.out.println(admin.viewProduct());
    }
}
