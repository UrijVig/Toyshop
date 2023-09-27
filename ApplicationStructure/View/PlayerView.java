package ApplicationStructure.View;

import ApplicationStructure.Controller.PlayerController;
import ApplicationStructure.Module.UserHierarchy.Visitor;

import java.util.Scanner;

public class PlayerView {
    private final PlayerController playerCtrl;

    public PlayerView(Visitor visitor) {
        this.playerCtrl = new PlayerController(visitor);
    }

    public void runPlayerRole(Scanner scanner) {
        System.out.print("\033[H\033[2J");
        System.out.println("Player menu:");
        boolean flag = true;
        String action;
        while (flag) {
            System.out.println("Для получения списка игрушек введите: 1");
            System.out.println("Для розыгрыша игрушки введите: 2");
            System.out.println("Для получения списка выиграных призов введите: 3");
            System.out.println("Для того чтобы выйти в главное меню введите: \"exit\"");
            action = playerCtrl.inputData(scanner);
            try {
                int number = Integer.parseInt(action);
                switch (number) {
                    case (1) -> {
                        System.out.println("Игрушки доступные лдля розыгрыша: ");
                        System.out.println(playerCtrl.viewProduct());
                    }
                    case (2) -> {
                        System.out.println("Вы получили: ");
                        System.out.println("\t" + playerCtrl.getPrize());
                    }
                    case (3) -> {
                        System.out.println("Общий выигрыш: ");
                        System.out.println("\t" + playerCtrl.getFullPrize());
                    }
                    default -> System.out.println("Данного числа пока нет в предложеных вариантах!");
                }
            } catch (NumberFormatException e) {
                if ("exit".equals(action)) {
                    flag = false;
                } else {
                    System.out.println("Введены некорректные данные! ");
                }
            }
        }
    }
}
