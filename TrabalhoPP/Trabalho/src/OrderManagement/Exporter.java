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

    private String filePath = "export.json";
    private String file = "graphicBar.json";
    private IOrder[] totalOrders;
    private IOrder order;
    private String GUIpath;
    private String GraphBarPath;
    private String GraphPiePath;
    private String OrderInfoPath;

    

    public Exporter() {
    }
    
    public Exporter(IOrder order) {
        this.order = order;
    }
    
    public IOrder[] getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(IOrder[] totalOrders) {
        this.totalOrders = totalOrders;
    }

    public IOrder getOrder() {
        return order;
    }

    public void setOrder(IOrder order) {
        this.order = order;
    }

    public String getGUIpath() {
        return GUIpath;
    }

    public void setGUIpath(String GUIpath) {
        this.GUIpath = GUIpath;
    }

    public String getGraphBarPath() {
        return GraphBarPath;
    }

    public void setGraphBarPath(String GraphBarPath) {
        this.GraphBarPath = GraphBarPath;
    }

    public String getGraphPiePath() {
        return GraphPiePath;
    }

    public void setGraphPiePath(String GraphPiePath) {
        this.GraphPiePath = GraphPiePath;
    }

    public String getOrderInfoPath() {
        return OrderInfoPath;
    }

    public void setOrderInfoPath(String OrderInfoPath) {
        this.OrderInfoPath = OrderInfoPath;
    }
       
    
    
    @Override
    public void export() throws IOException {
        try (FileWriter file = new FileWriter(this.GraphBarPath)){
            file.write(WriteBarGraph().toJSONString());
        }
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
        }
        
        catch (IOException e) {
            System.out.println(e.toString());
        }

    }
    
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
        for (IOrder order : this.totalOrders){
            orderCostArray.add(order.getCost()); // adicionar o custo das orders
            for (IShipping ship : order.getShippings()){
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
        for (int i = 0; i < this.totalOrders.length; i++){
            labels.add("Order" + (i + 1));
        }
        
        data.put("datasets", dataSets);
        data.put("labels", labels);
        
        object.put("data", data);
        object.put("type", "bar");
        object.put("title", "Order costs and number of containers");
        
        return object;
    }
}
