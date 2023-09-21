package ApplicationStructure.Module.StorageStructure.Storage;

import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.StorageStructure.Storage.Stock.Stock;

public class GameStock extends Stock<PlayableToy> implements Comparable<GameStock>{
    public void updateChance(String nameItem, double newChance) {
        for (PlayableToy item : this.data) {
            if (item.getName().equals(nameItem)) {
                item.setChance(newChance);
            }
        }
    }

    @Override
    public int compareTo(GameStock o) {
        for (int i = 0; i < this.data.size(); i++){
            if (this.get(i).getChance() > o.get(i).getChance()) return 1;
            else if (this.get(i).getChance() < o.get(i).getChance()) return -1;
        }
        return 0;
    }
}


