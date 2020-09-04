package Transport;

import java.io.IOException;
import transport.IDelivery;
import transport.IExporter;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import transport.IItemPacked;
import transport.IVehicle;


/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Exporter implements IExporter {

    /**
     * The exporter delivery.
     */
    private IDelivery delivery;

    /**
     * Exporter path to a file were the delivery info will be stored.
     */
    private String GUIpath;

    /**
     * Constructor of Exporter.
     *
     * @param delivery The exporter delivery
     * @param GUIpath The
     */
    public Exporter(IDelivery delivery, String GUIpath) {
        this.delivery = delivery;
        this.GUIpath = GUIpath;
    }
    
    /**
     * Getter for the exporter delivery.
     * 
     * @return The exporter delivery. 
     */
    public IDelivery getDelivery() {
        return delivery;
    }
    
    /**
     * Setter for the exporter delivery.
     * 
     * @param delivery The Delivery.
     */
    public void setDelivery(IDelivery delivery) {
        this.delivery = delivery;
    }
    
    /**
     * Getter for the path file were delivery info will be stored
     * @return 
     */
    public String getGUIpath() {
        return GUIpath;
    }

    /**
     * Setter for Gui path.
     * 
     * @param GUIpath The GUI path.
     */
    public void setGUIpath(String GUIpath) {
        this.GUIpath = GUIpath;
    }
    
    /**
     * Serialize an object to a specific format that can be stored.
     * 
     * @param string The file system location in which the data will be stored.
     * @throws IOException 
     */
    @Override
    public void export(String string) throws IOException {
        try (FileWriter file = new FileWriter(this.GUIpath)) {
            file.write(serializeDeliveryGUI().toJSONString());
        } 
    }

    /**
     * Serializes an Delivery acording to render method.
     * 
     * @return an JSONObject that can be written to a file
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred. This class is the general class of exceptions produced by
     * failed or interrupted I/O operations.
     */
    private JSONObject serializeDeliveryGUI() throws IOException {
        JSONObject obj = new JSONObject();
        JSONObject item;
        JSONArray items = new JSONArray();

        Delivery deliver = (Delivery) delivery;

        IVehicle vcl = deliver.getVehicle();
        Box box = (Box) vcl.getCargoBox();

        obj.put("depth", box.getDepth());
        obj.put("color", box.getColor().toString());
        obj.put("length", box.getLength());

        IItemPacked[] temp = deliver.getPackedItems();

        for (int i = 0; i < temp.length; i++) {
            item = new JSONObject();
            item.put("depth", temp[i].getItem().getDepth());
            Item tmpItem = (Item) temp[i].getItem();
            item.put("color", tmpItem.getColor().toString());
            item.put("x", temp[i].getPosition().getX());
            item.put("length", temp[i].getItem().getLength());
            item.put("y", temp[i].getPosition().getY());
            item.put("z", temp[i].getPosition().getZ());
            item.put("height", temp[i].getItem().getHeight());
            items.add(item);
        }

        obj.put("items", items);
        obj.put("height", box.getHeight());

        return obj;
    }
}