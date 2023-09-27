package ApplicationStructure.Controller;

import ApplicationStructure.Module.StorageStructure.Storage.GameStock;
import ApplicationStructure.Module.UserHierarchy.Visitor;
import ApplicationStructure.View.AdminView;
import ApplicationStructure.View.PlayerView;

import java.util.Scanner;

public class UserController {
    private final Visitor visitor;

    public UserController(Visitor visitor) {
        this.visitor = visitor;
    }

    public String inputData(Scanner scanner){
        try {
            return scanner.nextLine();
        } catch (Exception e){
            System.out.println("Ошибка при вводе информации: " + e.getMessage());
            throw new RuntimeException();
        }
    }
    public int inputInteger(Scanner scanner){
        try {
            return scanner.nextInt();
        }catch (NumberFormatException e){
            System.out.println("Невозможно преобразовать в int" + e.getMessage());
            throw new NumberFormatException();
        }
    }
    public double inputDouble(Scanner scanner){
        try {
            return scanner.nextDouble();
        }catch (NumberFormatException e){
            System.out.println("Невозможно преобразовать в double" + e.getMessage());
            throw new NumberFormatException();
        }
    }
    public boolean isFound(String searchName){
        return this.visitor.viewProduct().search(searchName);
    }

    public void getTheAdminRole(Scanner scanner){
        AdminView adminView = new AdminView(visitor);
        adminView.runAdminRole(scanner);
    }
    public void getThePlayerRole(Scanner scanner){
        PlayerView playerView = new PlayerView(visitor);
        playerView.runPlayerRole(scanner);
    }

    public GameStock viewProduct(){
        return visitor.viewProduct();
    }

}
