package OrderManagement;

import java.io.IOException;
import java.io.FileWriter;
import com.google.gson.Gson;
import order.management.IExporter;
import order.management.IOrder;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class Exporter implements IExporter {

    private final String filePath = "export.json";
    private IOrder order;

    public Exporter() {
    }
    
    public Exporter(IOrder order) {
        this.order = order;
    }

    public IOrder getOrder() {
        return order;
    }

    public void setOrder(IOrder order) {
        this.order = order;
    }
       
    @Override
    public void export() throws IOException {
    }
    
    /**
     * Metodo que ira fazer export da order para json
     * 
     * @param order order a ser exportada
     * @throws IOException 
     */
    public void export(IOrder order) throws IOException {
        try {
            Gson gson = new Gson();
            FileWriter fileWriter = new FileWriter(filePath);
            gson.toJson(order, fileWriter);
            fileWriter.close();
            System.out.println("Formato JSON escrito com sucesso para o ficheiro: " + filePath);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}