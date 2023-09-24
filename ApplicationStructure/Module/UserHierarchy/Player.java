package ApplicationStructure.Module.UserHierarchy;

import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.StorageStructure.Storage.GameStock;
import ApplicationStructure.Module.UserHierarchy.AbstractUser.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player extends Visitor {
    private final List<String> prize;

    public Player(User user) {
        super(user);
        this.reBalance();
        this.prize = new ArrayList<>();
    }

    public Player(GameStock stock) {
        super(stock);
        this.reBalance();
        this.prize = new ArrayList<>();
    }

    public Player() {
        super();
        this.reBalance();
        this.prize = new ArrayList<>();
    }

    public List<String> getPrize() {
        return prize;
    }

    public int getFullAmount() {
        int temp = 0;
        for (PlayableToy toy : stock) {
            temp += toy.getAmount();
        }
        return temp;
    }

    private void reBalance() {
        double temp = this.getFullAmount();
        temp = 100 / temp;
        for (PlayableToy toy : stock) {
            toy.setChance(toy.getAmount() * temp);
        }
    }


    public String playAToy() {
        List<String> temp = new ArrayList<>();
        for (PlayableToy toy : stock) {
            for (int j = 0; j < toy.getAmount(); j++) {
                temp.add(toy.getName());
            }
        }
        Collections.shuffle(temp);
        Random random = new Random();
        String win = temp.get(random.nextInt(0, temp.size()));
        stock.updateAmount(win);
        if (!stock.getTwist())
            this.reBalance();
        this.prize.add(win);
        return win;
    }

}
