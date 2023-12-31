package ApplicationStructure.Module.UserHierarchy;

import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.StorageStructure.Storage.GameStock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Admin extends Player {

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
        stock.setTwist(true);
    }

    public void importDataBase(String filename) throws IOException {
        stock.merger(this.fm.importDataFromFile(filename));
    }

    public void exportDataBase(String filename) throws IOException {
        this.fm.exportDataToFile(filename, this.stock.readAll());
    }

    public void importDataBase() throws IOException {
        stock.merger(this.fm.importDataFromFile());
    }

    public void exportDataBase() throws IOException {
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
