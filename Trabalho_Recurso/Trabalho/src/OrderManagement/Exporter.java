package OrderManagement;

import java.io.IOException;
import java.io.FileWriter;
import com.google.gson.Gson;
import order.management.IExporter;
import order.management.IOrder;
import order.management.IShipping;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    private String exportPath = "export.json";
    private String barPath = "barGraphic.json";
    private IOrder[] totalOrders;
    private IOrder order;
    private String BarGraphPath;

    public Exporter() {
    }

    /**
     * Construtor de Exporter
     *
     * @param order order do tipo IOrder
     */
    public Exporter(IOrder order) {
        this.order = order;
    }

    /**
     * Metodo para obter o total de orders
     *
     * @return total de orders do tipo IOrder
     */
    public IOrder[] getTotalOrders() {
        return totalOrders;
    }

    /**
     * Metodo para atribuir o total das orders
     *
     * @param totalOrders a atribuir do tipo IOrder
     */
    public void setTotalOrders(IOrder[] totalOrders) {
        this.totalOrders = totalOrders;
    }

    /**
     * Metodo para obter o caminho do grafico de barras
     *
     * @return caminho do grafico de barras
     */
    public String getBarGraphPath() {
        return BarGraphPath;
    }

    /**
     * Metodo que atribui o caminho do grafico de barras
     *
     * @param path caminho a atribuir (String)
     */
    public void setBarGraphPath(String path) {
        this.BarGraphPath = path;
    }

    /**
     * Metodo que faz o export do grafico de barras para o formato json
     *
     * @throws IOException
     */
    @Override
    public void export() throws IOException {
        try ( FileWriter file = new FileWriter(this.BarGraphPath)) {
            file.write(WriteBarGraph().toJSONString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Metodo que faz o export da order para o formato json
     *
     * @param order order a ser exportada
     * @throws IOException
     */
    public void export(IOrder order) throws IOException {
        try {
            Gson gson = new Gson();
            FileWriter fileWriter = new FileWriter(exportPath);
            gson.toJson(order, fileWriter);
            fileWriter.close();
            System.out.println("Formato JSON escrito com sucesso para o ficheiro: " + exportPath);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Metodo que ira fazer o grafico de barras de acordo com o proferido no
     * enunciado do trabalho pratico
     * @return 
     */
    private JSONObject WriteBarGraph() {
        JSONObject object = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray dataSets = new JSONArray();
        JSONArray labels = new JSONArray();
        JSONObject orderCost = new JSONObject();
        JSONArray orderCostArray = new JSONArray();
        JSONObject numberOfContainers = new JSONObject();
        JSONArray numberOfContainersArray = new JSONArray();
        int count = 0;

        // percorrer todas as orders
        for (IOrder order : this.totalOrders) {
            orderCostArray.add(order.getCost()); // adicionar o custo das orders
            for (IShipping ship : order.getShippings()) {
                count += ship.getContainers().length; // buscar o numero de containers da order
            }
            numberOfContainersArray.add(count);
        }

        orderCost.put("data", orderCostArray); // escrever o custo da order no array de custo
        orderCost.put("label", "Order cost"); // apresentar a label

        numberOfContainers.put("data", numberOfContainersArray); // escrever o numero de containers da order no array de containers
        numberOfContainers.put("label", "Number of containers"); // apresentar a label

        dataSets.add(orderCost); // adicionar o custo da Order ao dataset
        dataSets.add(numberOfContainers); // adicionar o numero de containers da order ao dataset

        // percorrer todas as orders para adicionar às labels
        for (int i = 0; i < this.totalOrders.length; i++) {
            labels.add("Order" + (i + 1));
        }

        data.put("datasets", dataSets);
        data.put("labels", labels);

        object.put("data", data);
        object.put("type", "bar");
        object.put("title", "Order costs and number of containers");

        System.out.println("Grafico de barras escrito com sucesso para o ficheiro: " + barPath);

        return object;
    }
}
