package ApplicationStructure.Module.UserHierarchy;

import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.StorageStructure.Storage.GameStock;
import ApplicationStructure.Module.UserHierarchy.AbstractUser.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Admin extends Player {
    public Admin(User user) {
        super(user);
    }

    public Admin(GameStock stock) {
        super(stock);
    }

    public void updateToyName(String name, String newName) {
        stock.updateName(name, newName);
    }

    public void updateToyAmount(String name, int newAmount) {
        stock.updateAmount(name, newAmount);
    }

    public void updateToyChance(String name, double newChance) {
        stock.updateChance(name, newChance);
    }

    public void importDataBase(String filename) {
        stock.merger(this.fm.importDataFromFile(filename));
    }

    public void exportDataBase(String filename) {
        this.fm.exportDataToFile(filename, this.stock.readAll());
    }

    public void importDataBase() {
        stock.merger(this.fm.importDataFromFile());
    }

    public void exportDataBase() {
        this.fm.exportDataToFile(this.stock.readAll());
    }

    public void addNewToy(PlayableToy newToy) {
        this.stock.add(newToy);
    }

    public void removeToy(String toyName) {
        stock.delete(toyName);
    }

    public void removeToy(String toyName, int number) {
        stock.delete(toyName, number);
    }

    @Override
    public String playAToy() {
        List<String> temp = new ArrayList<>();
        for (PlayableToy toy : stock) {
            for (int j = 0; j < toy.getChance(); j++) {
                temp.add(toy.getName());
            }
        }
        Collections.shuffle(temp);
        Random random = new Random();
        return temp.get(random.nextInt(0, temp.size()));
    }
}
