package ApplicationStructure.View;

import ApplicationStructure.Controller.AdminController;
import ApplicationStructure.Module.UserHierarchy.Visitor;

import java.util.Scanner;

public class AdminView {
    private final AdminController adminCtrl;

    public AdminView(Visitor visitor) {
        this.adminCtrl = new AdminController(visitor);
    }

    public void runAdminRole(Scanner scanner) {
        System.out.print("\033[H\033[2J");
        System.out.println("Admin menu:");
        boolean flag = true;
        String action;
        while (flag) {
            System.out.println("Для получения списка игрушек введите: 1");
            System.out.println("Для проверки игрового автомата введите: 2");
            System.out.println("Для создания новой позиции введите: 3");
            System.out.println("Для редактирования данных введите: 4");
            System.out.println("Для работы с файлами введите: 5");
            System.out.println("Для удаления позиции введите: 6");
            System.out.println("Для того чтобы выйти в главное меню введите: \"exit\"");
            action = adminCtrl.inputData(scanner);
            try {
                int number = Integer.parseInt(action);
                switch (number) {
                    case (1) -> {
                        System.out.println("Игрушки доступные лдля розыгрыша: ");
                        System.out.println(adminCtrl.viewProduct());
                    }
                    case (2) -> {
                        System.out.println("Вы получили: ");
                        System.out.println("\t" + adminCtrl.checkTheMachine());
                    }
                    case (3) -> {
                        System.out.println("Создание новой позиции: ");
                        boolean inputflag = true;
                        System.out.println("Введите название позиции: ");
                        String namePosition = adminCtrl.inputData(scanner);
                        int amountPosition;
                        while (inputflag) {
                            try {
                                System.out.println("Введите количество: ");
                                amountPosition = adminCtrl.inputInteger(scanner);
                                adminCtrl.createAPosition(namePosition, amountPosition);
                                inputflag = false;
                            } catch (Exception e) {
                                System.out.println("Ошибка ввода! ");
                            }
                        }
                    }
                    case (4) -> {
                        boolean inputflag = true;
                        int amountPosition;
                        String newNamePosition, oldNamePosition;
                        double chancePosition;
                        boolean found = true;
                        boolean inputNumber;
                        while (found) {
                            System.out.println("Введите имя позиции для редактирования! ");
                            oldNamePosition = adminCtrl.inputData(scanner);
                            if (adminCtrl.isFound(oldNamePosition)) {
                                while (inputflag) {
                                    System.out.println("Для редактирования имени введите: 1");
                                    System.out.println("Для редактирования количества введите: 2");
                                    System.out.println("Для редактирвоания шанса выпадения введите: 3");
                                    System.out.println("Для для завершения редактирования введите: \"exit\"");
                                    action = adminCtrl.inputData(scanner);
                                    try {
                                        number = Integer.parseInt(action);
                                        switch (number) {
                                            case (1) -> {
                                                System.out.println("Введите новое имя!");
                                                newNamePosition = adminCtrl.inputData(scanner);
                                                adminCtrl.editNamePosition(oldNamePosition, newNamePosition);
                                            }
                                            case (2) -> {
                                                inputNumber = true;
                                                while (inputNumber) {
                                                    try {
                                                        System.out.println("Введите количество: ");
                                                        amountPosition = adminCtrl.inputInteger(scanner);
                                                        adminCtrl.editAmountPosition(oldNamePosition, amountPosition);
                                                        inputNumber = false;
                                                    } catch (Exception e) {
                                                        System.out.println("Ошибка ввода! ");
                                                    }
                                                }
                                            }
                                            case (3) -> {
                                                inputNumber = true;
                                                while (inputNumber) {
                                                    try {
                                                        System.out.println("Введите шанс: ");
                                                        chancePosition = adminCtrl.inputDouble(scanner);
                                                        adminCtrl.editChancePosition(oldNamePosition, chancePosition);
                                                        inputNumber = false;
                                                    } catch (Exception e) {
                                                        System.out.println("Ошибка ввода! ");
                                                    }
                                                }
                                            }
                                            default ->
                                                    System.out.println("Данного числа пока нет в предложеных вариантах!");
                                        }
                                    } catch (NumberFormatException e) {
                                        if ("exit".equals(action)) {
                                            inputflag = false;
                                        } else {
                                            System.out.println("Введены некорректные данные! ");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Данного имени нет в списке позиций! ");
                            }
                            System.out.println("Для того чтобы закончить настройки редактирования введите: \"exit\"");
                            System.out.println("Для того чтобы продолжить введите новое имя позиции: ");
                            action = adminCtrl.inputData(scanner);
                            if ("exit".equals(action)) {
                                found = false;
                            } else {
                                System.out.println("Введены некорректные данные! ");
                            }
                        }

                    }
                    case (5) -> {
                        boolean inputflag = true;
                        while (inputflag) {
                            System.out.println("Для экспорта введите: 1");
                            System.out.println("Для импорта введите: 2");
                            System.out.println("Для для завершения введите: \"exit\"");
                            action = adminCtrl.inputData(scanner);
                            try {
                                number = Integer.parseInt(action);
                                switch (number) {
                                    case (1) -> {
                                        System.out.println("Введите название файла в формате name.txt");
                                        String fileName = adminCtrl.inputData(scanner);
                                        try {
                                            adminCtrl.export(fileName);
                                            System.out.println("Успешно! ");
                                        } catch (Exception e) {
                                            System.out.println("Не удалось експортировать файл!" + e.getMessage());
                                        }
                                    }
                                    case (2) -> {
                                        System.out.println("Введите название файла в формате name.txt");
                                        String fileName = adminCtrl.inputData(scanner);
                                        try {
                                            adminCtrl.importFile(fileName);
                                            System.out.println("Успешно! ");
                                        } catch (Exception e) {
                                            System.out.println("Не удалось импортировать файл!" + e.getMessage());
                                        }
                                    }
                                    default -> System.out.println("Данного числа пока нет в предложеных вариантах!");
                                }
                            } catch (NumberFormatException e) {
                                if ("exit".equals(action)) {
                                    inputflag = false;
                                } else {
                                    System.out.println("Введены некорректные данные! ");
                                }
                            }
                        }
                    }
                    case (6) -> {
                        boolean found = true;
                        String oldNamePosition;
                        while (found) {
                            System.out.println("Введите имя позиции для редактирования! ");
                            oldNamePosition = adminCtrl.inputData(scanner);
                            if (adminCtrl.isFound(oldNamePosition)) {
                                adminCtrl.removePosition(oldNamePosition);
                                found = false;
                            } else {
                                System.out.println("Позиция с таким именем не найдена! ");
                            }
                        }
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
