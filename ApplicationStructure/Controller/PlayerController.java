package ApplicationStructure.Controller;

import ApplicationStructure.Module.UserHierarchy.Player;
import ApplicationStructure.Module.UserHierarchy.Visitor;

public class PlayerController extends UserController{
    private final Player player;

    public PlayerController(Visitor visitor) {
        super(visitor);
        this.player = new Player(super.viewProduct());
    }
    public String getPrize() {
        return this.player.playAToy();
    }

    public String getFullPrize() {
        return this.player.getPrize().toString();
    }

}
