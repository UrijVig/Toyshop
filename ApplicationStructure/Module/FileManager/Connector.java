package ApplicationStructure.Module.FileManager;

import java.io.File;

public class Connector {
    public static final String PATH = "DataFile.txt";
    public static void createFile() {
        try {
            File file = new File(PATH);
            if (file.createNewFile()) {
                System.out.println("File created");
            }
            else {
                System.out.println("File already exists");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
