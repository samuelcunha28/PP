package OrderManagement;

import java.io.IOException;
import java.io.FileWriter;
import com.google.gson.Gson;
import order.management.IExporter;
import order.management.IShipping;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T3>
*/
public class Exporter implements IExporter {

    private String filePath = "example2.json";
    
    @Override
    public void export() throws IOException {
    }
    
    /**
     * Metodo que ira fazer export da order/shipping para json
     * 
     * @param shipping shipping a ser exportado
     * @throws IOException 
     */
    public void export(IShipping shipping) throws IOException {
        try {
            Gson gson = new Gson();
            FileWriter fileWriter = new FileWriter(filePath);
            gson.toJson(shipping, fileWriter);
            fileWriter.close();
            System.out.println("Formato JSON escrito com sucesso para o ficheiro: " + filePath);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}