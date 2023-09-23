package ApplicationStructure.Module.FileManager;

import ApplicationStructure.Module.FileManager.Mapper.impl.ProductMapper;
import ApplicationStructure.Module.StorageStructure.Element.PlayableToy;
import ApplicationStructure.Module.StorageStructure.Element.Product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileManager<T extends Product> {
    private final ProductMapper mapper;
    private final String fileName;

    public FileManager() {
        Connector.createFile();
        this.mapper = new ProductMapper();
        this.fileName = Connector.PATH;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<T> importDataFromFile(String filename){
        List<String> data = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    data.add(line);
                }
            } while (line != null);
            fr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        List<T> importData = new LinkedList<>();
        for (String line : data) {
            importData.add((T) mapper.toOutput(line));
        }
        return importData;
    }
    public List<T> importDataFromFile(){
        return this.importDataFromFile(this.fileName);
    }

    public void exportDataToFile(List<T> data){
        this.exportDataToFile(this.fileName,data);
    }
    public void exportDataToFile(String filename,List<T> data){
        List<String> exportData = new ArrayList<>();
        for (T item : data) {
            exportData.add(mapper.toInput((PlayableToy) item));
        }
        try (FileWriter writer = new FileWriter(fileName, false)){
            for (String line : exportData) {
                writer.write(line);
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
