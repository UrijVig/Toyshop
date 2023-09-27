import ApplicationStructure.View.UserVew;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            UserVew view = new UserVew();
            view.run();
        } catch (IOException e) {
            System.out.println("Что-то пошло не так :( ");
            throw new RuntimeException(e);
        }
    }
}
