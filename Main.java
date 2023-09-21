import ApplicationStructure.Module.UserHierarchy.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("player.viewProduct()");
        Player player = new Player();
        System.out.println(player.viewProduct());
        System.out.println("Вы получили: " + player.playAToy());
        System.out.println(player.viewProduct());
        System.out.println("Вы получили: " + player.playAToy());
        System.out.println(player.viewProduct());

    }
}
