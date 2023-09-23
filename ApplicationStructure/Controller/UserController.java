package ApplicationStructure.Controller;

import java.util.Scanner;

public class UserController {
    public String inputData(Scanner sc ){
        try {
            return sc.nextLine();
        } catch (Exception e){
            System.out.println("Ошибка при вводе информации: " + e.getMessage());
            throw new RuntimeException();
        }
    }


}
