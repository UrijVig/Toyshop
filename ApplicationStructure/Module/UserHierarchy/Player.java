package ApplicationStructure.Module.UserHierarchy;

import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.UserHierarchy.AbstractUser.User;

public class Player extends User {
    public Player() {
        super();
        this.reBalance();
    }

    private void reBalance(){
        double temp = 0;
        for (PlayableToy toy : stock) {
            temp += toy.getAmount();
        }
        temp = 100 / temp;
        for (PlayableToy toy : stock) {
            toy.setChance(toy.getAmount() * temp);
        }
    }

    public String playAToy(){
        PlayableToy temp = stock.get(0);
        for (int i = 1; i < stock.size(); i++){
            if (temp.getChance() < stock.get(i).getChance()){
                temp = stock.get(i);
            }
        }
        stock.updateAmount(temp.getName(),temp.getAmount()-1);
        this.reBalance();
        return temp.getName();
    }
}
