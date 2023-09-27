package ApplicationStructure.View;


import ApplicationStructure.Controller.UserController;
import ApplicationStructure.Module.UserHierarchy.Visitor;

import java.util.Scanner;


public class UserVew {
    private final UserController userCtrl;

    public UserVew() {
        Visitor visitor = new Visitor();
        this.userCtrl = new UserController(visitor);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в магазин игрушек!");
        boolean flag = true;
        String action;
        while (flag) {
            System.out.println("Выберите необходимую роль: ");
            System.out.println("Для получения роли Администратора введите: 1");
            System.out.println("Для получения роли Игрока введите: 2");
            System.out.println("Для завершения работы программы введите \"exit\"");
            action = userCtrl.inputData(sc);
            try {
                int number = Integer.parseInt(action);
                switch (number) {
                    case (1) -> userCtrl.getTheAdminRole(sc);
                    case (2) -> userCtrl.getThePlayerRole(sc);
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
        sc.close();
    }


}
