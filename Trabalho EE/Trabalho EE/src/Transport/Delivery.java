package Transport;

import exceptions.DeliveryException;
import Exceptions.DeliveryExceptionImpl;
import HumanResources.Destination;
import HumanResources.Driver;
import hr.IDestination;
import hr.IDriver;
import hr.LicenseType;
import java.util.Arrays;
import transport.DriverStatus;
import transport.IDelivery;
import transport.IItem;
import transport.IPosition;
import transport.IVehicle;
import transport.ItemStatus;
import transport.VehicleStatus;

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
     * Constructor of Delivery.
     *
     * @param id The delivery id.
     * @param vehicle The delivery vehicle.
     * @param driver The delivery driver.
     * @param items The delivery items.
     * @param destination The delivery destination.
     * @param status The delivery item status.
     */
    public Delivery(String id, IVehicle vehicle, IDriver driver, IItem[] items, IDestination destination, ItemStatus status) {
        this.id = id;
        this.vehicle = vehicle;
        this.driver = driver;
        this.items = items;
        this.destination = destination;
        this.status = status;
    }

    /**
     * Getter for delivery id that acts as unique identifier for the delivery.
     *
     * @return the delivery id.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Assigns the vehicle and the driver to the delivery. The vehicle must have
     * the free status and after assignment, the status must be changed to IN
     * PREPARATION. The driver must have the free status and after assignment
     * must be changed to ASSIGNED
     *
     * @param vehicle The vehicle to be assigned to the delivery
     * @param driver The driver to be assigned to the delivery
     * @throws DeliveryException if any parameter is null if any item was
     * already assigned to the delivery if the vehicle status is different from
     * free if the Driver status is different from free if the driver do not
     * have a license type that matched the allowed vehicle license types
     */
    @Override
    public void setVehicle(IVehicle vehicle, IDriver driver) throws DeliveryException {
        if (vehicle == null) {
            throw new DeliveryExceptionImpl("The parameter vehicle is null");
        }
        if (driver == null) {
            throw new DeliveryExceptionImpl("The parameter driver is null");
        }
        if (items != null) {
            throw new DeliveryExceptionImpl("Any item was already assigned");
        }
        if (vehicle.getStatus() != vehicle.getStatus().FREE) {
            throw new DeliveryExceptionImpl("Vehicle status is different from free");
        }
        if (driver.getStatus() != driver.getStatus().FREE) {
            throw new DeliveryExceptionImpl("Driver status is different from free");
        }
        this.vehicle = vehicle;
        vehicle.setStatus(VehicleStatus.IN_PREPARATION);
        this.driver = driver;
        driver.setStatus(DriverStatus.ASSIGNED);

    }

    /**
     * Getter for the vehicle assigned to the delivery.
     * 
     * @return the vehicle assigned to the delivery, null if none. 
     */
    @Override
    public IVehicle getVehicle() {
        return this.vehicle;
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

    /**
     * To String method representing the Delivery.
     *
     * @return String with all the information about the delivery.
     */
    @Override
    public String toString() {
        return "\nID: " + id + "\nVehicle: " + vehicle + "\nDriver: " + driver
                + "\nItems: " + Arrays.toString(items)
                + "\nDestination: " + destination + "\nItem status: " + status;
    }
}
