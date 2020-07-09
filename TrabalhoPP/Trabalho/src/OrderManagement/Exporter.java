package OrderManagement;

import java.io.IOException;
import java.io.FileWriter;
import com.google.gson.Gson;
import order.management.IExporter;
import order.management.IShipping;

/**
 *
 * @author samue
 */
public class Exporter implements IExporter {

    private String filePath = "example2.json";
    IShipping shipping;
    
    @Override
    public void export() throws IOException {
        try {
            Gson gson = new Gson();
            FileWriter fileWriter = new FileWriter(filePath);
            gson.toJson(shipping, fileWriter);
            fileWriter.close();
            System.out.println("JSON string write to a file successfully");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}