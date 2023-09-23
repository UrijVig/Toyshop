package ApplicationStructure.View;

import ApplicationStructure.Controller.PlayerController;
import ApplicationStructure.Module.UserHierarchy.Player;

public class PlayerView {
    private PlayerController playerCtrl;
    private final Player player;

    public PlayerView() {
        this.playerCtrl = new PlayerController();
        this.player = new Player();
    }

    public void runPlayerRole(){
        System.out.print("\033[H\033[2J");
        System.out.println(player.viewProduct());
    }
}
