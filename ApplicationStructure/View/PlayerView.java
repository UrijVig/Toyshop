package ApplicationStructure.View;

import ApplicationStructure.Controller.PlayerController;
import ApplicationStructure.Module.StorageStructure.Storage.GameStock;
import ApplicationStructure.Module.UserHierarchy.AbstractUser.User;
import ApplicationStructure.Module.UserHierarchy.Player;

public class PlayerView {
    private final PlayerController playerCtrl;
    private final Player player;

    public PlayerView(User visitor) {
        this.playerCtrl = new PlayerController();
        this.player = new Player(visitor);
    }

    public GameStock runPlayerRole() {
        System.out.print("\033[H\033[2J");
        System.out.println(player.viewProduct());
        return this.player.viewProduct();
    }
}
