package Management_Implementation;

import java.io.FileWriter;
import java.io.IOException;
import order.management.IExporter;
import order.management.IOrder;
import order.management.IShipping;
import order.management.ShipmentStatus;
import order.packing.IContainer;
import order.packing.IItem;
import order.packing.IItemPacked;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import packing_gui.PackingGUI;

/**
 * This class implements {@link IExporter}.
 *
 * Nome: José Pedro Fernandes 
 * Número: 8190239 
 * Turma: LEI T4
 * 
 * Nome: Hugo Maia Alves
 * Número: 8160521
 * Turma: LEIT2
 * 
 */
public class Exporter implements IExporter {

    /**
     * Exporter's order.
     */
    private IOrder order;

    /**
     * Exporter's Order's to draw graphs.
     */
    private IOrder[] GraphOrders;

    /**
     * Exporter's path to a file were Order's info will be stored.
     */
    private String GUIpath;

    /**
     * Exporter's path to a file were a bar graph info will be stored.
     */
    private String GraphBarPath;

    /**
     * Exporter's path to a file were a circular graph info will be stored.
     */
    private String GraphPiePath;

    /**
     * Exporter's path to a file where the {@link IOrder order} iformation will
     * be stored.
     */
    private String OrderInfoPath;

    /**
     * Creates an instance of <code>Exporter</code> .
     *
     * @param order The Exporter's {@link IOrder order}.
     * @param path The Exporter's path.
     */
    public Exporter(IOrder order, String path) {
        this.order = order;
        this.GUIpath = path;
    }

    /**
     * Setter of the attribute {@link Exporter#order order}.
     *
     * @param order The {@link Exporter#order Exporter's order}.
     */
    public void setorder(IOrder order) {
        this.order = order;
    }

    /**
     * Setter of the attribute {@link Exporter#GUIpath}.
     *
     * @param GUIpath The {@link Exporter#GUIpath}.
     */
    public void setGUIpath(String GUIpath) {
        this.GUIpath = GUIpath;
    }

    /**
     * Setter of the attribute {@link Exporter#GraphOrders graph orders}.
     *
     * @param GraphOrders The
     * {@link Exporter#GraphOrders Exporter's graph orders}.
     */
    public void setGraphOrders(IOrder[] GraphOrders) {
        this.GraphOrders = GraphOrders;
    }

    /**
     * Setter of the attribute {@link Exporter#GraphBarPath}.
     *
     * @param GraphBarPath The {@link Exporter#GraphBarPath}.
     */
    public void setGraphBarPath(String GraphBarPath) {
        this.GraphBarPath = GraphBarPath;
    }

    /**
     * Setter of the attribute {@link Exporter#GraphPiePath}.
     *
     * @param GraphPiePath The {@link Exporter#GraphPiePath}.
     */
    public void setGraphPiePath(String GraphPiePath) {
        this.GraphPiePath = GraphPiePath;
    }

    /**
     * Setter of the attribute {@link Exporter#OrderInfoPath}.
     *
     * @param OrderInfoPath The {@link Exporter#OrderInfoPath}
     */
    public void setOrderInfoPath(String OrderInfoPath) {
        this.OrderInfoPath = OrderInfoPath;
    }

    /**
     * Serialize an {@link IOrder order} to a specific format that can be stored.
     *
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred. This class is the general class of exceptions produced by
     * failed or interrupted I/O operations.
     */
    @Override
    public void export() throws IOException {
        try ( FileWriter file = new FileWriter(this.GUIpath)) {
            file.write(serializeGUI().toJSONString());
        }

        try ( FileWriter file = new FileWriter(this.GraphBarPath)) {
            file.write(serializeBarGraph().toJSONString());
        }

        try ( FileWriter file = new FileWriter(this.GraphPiePath)) {
            file.write(serializePieGraph().toJSONString());
        }

        try ( FileWriter file = new FileWriter(this.OrderInfoPath)) {
            file.write(serializeOrderInfo().toJSONString());
        }

    }

    /**
     * Serializes an {@link IOrder order} acording {@link PackingGUI#render(java.lang.String) render method}.
     * 
     * @return an JSONObject that can be written to a file
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred. This class is the general class of exceptions produced by
     * failed or interrupted I/O operations.
     */
    private JSONObject serializeGUI() throws IOException {
        JSONObject obj = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject destination = new JSONObject();
        JSONObject address = new JSONObject();
        JSONArray shippings = new JSONArray();
        JSONObject shippup;
        JSONObject shipping;
        JSONArray containers;
        JSONObject container;
        JSONArray items;
        JSONObject item;
        JSONObject customer = new JSONObject();
        JSONObject billingAddress = new JSONObject();

        data.put("day", order.getDate().getDayOfMonth());
        data.put("month", order.getDate().getMonthValue());
        data.put("year", order.getDate().getYear());

        destination.put("name", order.getDestination().getName());
        address.put("country", order.getDestination().getAddress().getCountry());
        address.put("number", order.getDestination().getAddress().getNumber());
        address.put("street", order.getDestination().getAddress().getStreet());
        address.put("city", order.getDestination().getAddress().getCity());
        address.put("state", order.getDestination().getAddress().getState());
        destination.put("address", address);

        for (IShipping shipment : order.getShippings()) {
            shippup = new JSONObject();
            shipping = new JSONObject();
            containers = new JSONArray();
            for (IContainer contentor : shipment.getContainers()) {
                container = new JSONObject();
                items = new JSONArray();
                container.put("volume", contentor.getVolume());
                container.put("reference", contentor.getReference());
                container.put("depth", contentor.getDepth());
                container.put("color", contentor.getColor().toString());
                container.put("length", contentor.getLenght());
                container.put("closed", contentor.isClosed());
                container.put("colorEdge", contentor.getColorEdge().toString());
                container.put("height", contentor.getHeight());
                container.put("occupiedVolume", contentor.getOccupiedVolume());
                for (IItemPacked it : contentor.getPackedItems()) {
                    item = new JSONObject();
                    item.put("reference", it.getItem().getReference());
                    item.put("depth", it.getItem().getDepth());
                    item.put("color", it.getColor().toString());
                    item.put("x", it.getPosition().getX());
                    item.put("length", it.getItem().getLenght());
                    item.put("y", it.getPosition().getY());
                    item.put("description", it.getItem().getDescription());
                    item.put("z", it.getPosition().getZ());
                    item.put("colorEdge", it.getColor().toString());
                    item.put("height", it.getItem().getHeight());
                    items.add(item);
                }
                container.put("items", items);
                containers.add(container);
            }
            shippup.put("cost", shipment.getCost());
            shippup.put("containers", containers);
            shippup.put("status", shipment.getShipmentStatus().toString());
            shipping.put("shipping", shippup);
            shippings.add(shipping);
        }

        address = new JSONObject();
        address.put("country", order.getCustomer().getAddress().getCountry());
        address.put("number", order.getCustomer().getAddress().getNumber());
        address.put("street", order.getCustomer().getAddress().getStreet());
        address.put("city", order.getCustomer().getAddress().getCity());
        address.put("state", order.getCustomer().getAddress().getState());

        billingAddress.put("country", order.getCustomer().getBillingAddress().getCountry());
        billingAddress.put("number", order.getCustomer().getBillingAddress().getNumber());
        billingAddress.put("street", order.getCustomer().getBillingAddress().getStreet());
        billingAddress.put("city", order.getCustomer().getBillingAddress().getCity());
        billingAddress.put("state", order.getCustomer().getBillingAddress().getState());

        customer.put("address", address);
        customer.put("name", order.getCustomer().getName());
        customer.put("id", order.getCustomer().getCustomerId());
        customer.put("billingAddress", billingAddress);

        obj.put("id", order.getId());
        obj.put("date", data);
        obj.put("destination", destination);
        obj.put("shippings", shippings);
        obj.put("customer", customer);

        return obj;
    }

    /**
     * Serializes an {@link IOrder order} to a specific format that will be used to draw a bar graph.
     * 
     * @return an JSONObject that can be written to a file.
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred. This class is the general class of exceptions produced by
     * failed or interrupted I/O operations.
     */
    private JSONObject serializeBarGraph() throws IOException {
        JSONObject obj = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray dataSets = new JSONArray();
        JSONArray labels = new JSONArray();
        JSONObject cost = new JSONObject();
        JSONArray costarray = new JSONArray();
        JSONObject nShippings = new JSONObject();
        JSONArray nShippingssarray = new JSONArray();
        JSONObject nContainers = new JSONObject();
        JSONArray nContainerssarray = new JSONArray();
        int contador = 0;

        for (IOrder ord : this.GraphOrders) {
            costarray.add(ord.getCost());
            nShippingssarray.add(ord.getShippings().length);
            for (IShipping shipment : ord.getShippings()) {
                contador += shipment.getContainers().length;
            }
            nContainerssarray.add(contador);
        }
        cost.put("data", costarray);
        cost.put("label", "Order cost");

        nShippings.put("data", nShippingssarray);
        nShippings.put("label", "Number of shipments");

        nContainers.put("data", nContainerssarray);
        nContainers.put("label", "Number of containers");

        dataSets.add(cost);
        dataSets.add(nContainers);
        dataSets.add(nShippings);

        for (int i = 0; i < this.GraphOrders.length; i++) {
            labels.add("Order " + (i + 1));
        }

        data.put("datasets", dataSets);

        data.put("labels", labels);

        obj.put("type", "pie");
        obj.put("data", data);
        obj.put("type", "bar");
        obj.put("title", "Order costs and number of shipments and containers");

        return obj;
    }

    /**
     * Serializes an {@link IOrder order} to a specific format that will be used to draw a pie graph.
     * 
     * @return an JSONObject that can be written to a file.
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred. This class is the general class of exceptions produced by
     * failed or interrupted I/O operations.
     */
    private JSONObject serializePieGraph() throws IOException {
        JSONObject obj = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray dataSets = new JSONArray();
        JSONObject cost = new JSONObject();
        JSONArray costArray = new JSONArray();
        JSONArray labels = new JSONArray();

        for (IOrder ord : this.GraphOrders) {
            costArray.add(ord.getCost());
        }
        
        cost.put("data", costArray);
        cost.put("label", "cost");

        for (int i = 0; i < this.GraphOrders.length; i++) {
            labels.add("Order " + (i + 1));
        }
        dataSets.add(cost);
        data.put("datasets", dataSets);
        data.put("labels", labels);

        obj.put("data", data);
        obj.put("type", "pie");
        obj.put("title", "Cost od orders");

        return obj;
    }

    /**
     * Serializes an {@link IOrder order} with every essencial detail about it.
     * 
     * @return an JSONObject that can be written to a file.
     * @throws IOException Signals that an I/O exception of some sort has
     * occurred. This class is the general class of exceptions produced by
     * failed or interrupted I/O operations.
     */
    private JSONObject serializeOrderInfo() throws IOException {
        JSONObject obj = new JSONObject();
        JSONObject remainingItems = new JSONObject();
        JSONObject ItemsObj = new JSONObject();
        JSONObject item = new JSONObject();
        int canceldedShips = 0;
        
        obj = serializeGUI();
        JSONArray Items = new JSONArray();

        for (IItem it : order.getRemainingItemsToSend()) {
            item = new JSONObject();
            item.put("reference", it.getReference());
            item.put("depth", it.getDepth());
            item.put("length", it.getLenght());
            item.put("description", it.getDescription());
            item.put("height", it.getHeight());
            Items.add(item);
        }

        obj.put("Price per cubic volume unit", Management.getCubicPrice());
        remainingItems.put("Number of remaining items to send", order.getNumberOfRemaingItemsToSend());
        remainingItems.put("Remaining items to send", Items);
        obj.put("Remaining items", remainingItems);
        Items = new JSONArray();
        
        for (IItem it : order.getItems()) {
            item = new JSONObject();
            item.put("reference", it.getReference());
            item.put("depth", it.getDepth());
            item.put("length", it.getLenght());
            item.put("description", it.getDescription());
            item.put("height", it.getHeight());
            Items.add(item);
        }
        ItemsObj.put("Total of items", order.getNumberOfItems());
        ItemsObj.put("Items", Items);
        
        obj.put("Items", ItemsObj);
        obj.put("closed", order.isClosed());
        
        for(IShipping shipment : order.getShippings()){
            if(shipment.getShipmentStatus() == ShipmentStatus.CANCELLED){
                canceldedShips++;
            }
        }
        obj.put("cancelled shippings", canceldedShips);
        
        return obj;
    }
}
