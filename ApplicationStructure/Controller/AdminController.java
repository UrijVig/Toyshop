package ApplicationStructure.Controller;

import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.UserHierarchy.Admin;
import ApplicationStructure.Module.UserHierarchy.Visitor;

import java.io.IOException;

public class AdminController extends UserController {
    private final Admin admin;

    public AdminController(Visitor visitor) {
        super(visitor);
        this.admin = new Admin(super.viewProduct());
    }

    public String checkTheMachine() {
        return this.admin.playAToy();
    }

    public void createAPosition(String namePosition, int amountPosition) {
        PlayableToy newPosition = new PlayableToy(namePosition, amountPosition);
        newPosition.setChance((double) 100 / this.admin.getFullAmount() * newPosition.getAmount());
        this.admin.addNewToy(newPosition);
    }

    public void editNamePosition(String oldNamePosition, String newNamePosition) {
        this.admin.updateToyName(oldNamePosition, newNamePosition);
    }

    public void editAmountPosition(String oldNamePosition, int amountPosition) {
        this.admin.updateToyAmount(oldNamePosition, amountPosition);
    }

    public void editChancePosition(String oldNamePosition, double chancePosition) {
        this.admin.updateToyChance(oldNamePosition, chancePosition);
    }

    public void removePosition(String oldNamePosition) {
        this.admin.removeToy(oldNamePosition);
    }

    public void export(String fileName) throws IOException {
        this.admin.exportDataBase(fileName);
    }

    public void importFile(String fileName) throws IOException {
        this.admin.importDataBase(fileName);
    }
}
