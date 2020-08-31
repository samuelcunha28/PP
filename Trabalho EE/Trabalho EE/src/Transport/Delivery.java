package Transport;
import exceptions.DeliveryException;
import hr.IDestination;
import hr.IDriver;
import transport.IDelivery;
import transport.IItem;
import transport.IPosition;
import transport.IVehicle;
import transport.ItemStatus;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Delivery extends Exporter implements IDelivery {

    /**
     * The delivery id.
     */
    private String id;

    /**
     * The delivery vehicle.
     */
    private IVehicle vehicle;
    
    /**
     * The delivery driver.
     */
    private IDriver driver;
    
    /**
     * The delivery items.
     */
    private IItem[] items;
    
    /**
     * The delivery destination.
     */
    private IDestination destination;
    
    /**
     * The delivery item status
     */
    private ItemStatus status;

    /**
     * 
     * @param id
     * @param vehicle
     * @param driver
     * @param items
     * @param destination
     * @param status 
     */
    public Delivery(String id, IVehicle vehicle, IDriver driver, IItem[] items, IDestination destination, ItemStatus status) {
        this.id = id;
        this.vehicle = vehicle;
        this.driver = driver;
        this.items = items;
        this.destination = destination;
        this.status = status;
    }
    
    
    
    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVehicle(IVehicle iv, IDriver id) throws DeliveryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IVehicle getVehicle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean load(IItem iitem, IPosition ip) throws DeliveryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean unload(IItem iitem, ItemStatus is) throws DeliveryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean unload(IDestination id, ItemStatus is) throws DeliveryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItem[] getRemainingItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDestination[] getRemainingDestinations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start() throws DeliveryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void end() throws DeliveryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getCurrentWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
