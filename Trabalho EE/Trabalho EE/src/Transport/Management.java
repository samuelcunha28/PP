package Transport;

import exceptions.DeliveryException;
import exceptions.ManagementException;
import hr.ICustomer;
import hr.IDestination;
import hr.IDriver;
import transport.IDelivery;
import transport.IItem;
import transport.IManagement;
import transport.IVehicle;
import transport.ItemStatus;
import transport.TransportationTypes;
import transport.VehicleStatus;
import Exceptions.ManagementExceptionImpl;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Management implements IManagement {

    /**
     * Represents the management items.
     */
    private IItem[] items;

    /**
     * The status of the item.
     */
    private ItemStatus status;

    /**
     * The number of items.
     */
    private int numberOfItems;

    /**
     * Representes the management vehicles.
     */
    private IVehicle[] vehicles;
    
    /**
     * The number of vehicles
     */
    private int numberOfVehicles;
    
    /**
     * Representes the management drivers.
     */
    private IDriver[] drivers;
    
    /**
     * The number of drivers
     */
    private int numberOfDrivers;

    public Management() {
        this.numberOfItems = 0;
        this.items = new IItem[5];
        this.numberOfVehicles = 0;
        this.vehicles = new IVehicle[5];
        this.numberOfDrivers = 0;
        this.drivers = new IDriver[5];
    }

    /**
     * Adds a new item to be delivered
     *
     * @param iitem item to be delivered
     * @return true if the item is inserted, throws a exception if the item
     * exists
     * @throws ManagementException if item is not NON_DELIVERED or item is null
     * or item has no transportation type
     */
    @Override
    public boolean addItem(IItem iitem) throws ManagementException {
        /*
        if (this.status != ItemStatus.NON_DELIVERED) {
            throw new ManagementExceptionImpl("The item is not delivered");
        } */
        if (iitem == null) {
            throw new ManagementExceptionImpl("The parameter is null");
        }

        if (iitem.getTransportationTypes() == null) {
            throw new ManagementExceptionImpl("The item has no transportation type");
        }

        /**
         * if (iitem == iitem) { throw new ManagementExceptionImpl("The item
         * already exists"); }
         */
        if (this.items.length == this.numberOfItems) {
            IItem[] clone = this.items;
            this.items = new IItem[this.items.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.items[i] = clone[i];
            }
        }

        this.items[this.numberOfItems] = iitem;
        this.numberOfItems++;

        return true;
    }

    /**
     * Removes an item
     *
     * @param iitem item to be removed
     * @return true if the item is removed
     * @throws ManagementException if the parameter is null
     */
    @Override
    public boolean removeItem(IItem iitem) throws ManagementException {
        if (iitem == null) {
            throw new ManagementExceptionImpl("The parameter is null");
        }

        for (int i = 0; i < this.numberOfItems; ++i) {
            if (this.items[i].equals(iitem)) {
                for (; i < this.numberOfItems - 1; i++) {
                    this.items[i] = this.items[i + 1];
                }
                this.items[i] = null;
                this.numberOfItems--;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a copy of the collection of item.
     *
     * @return the items.
     */
    @Override
    public IItem[] getItems() {
        IItem[] copyItems = new IItem[this.numberOfItems];
        for (int i = 0; i < this.numberOfItems; i++) {
            copyItems[i] = this.items[i];
        }
        return copyItems;
    }

    /**
     * Returns a copy of the collection of item from the given customer.
     * 
     * @param customer the number of items of the customer.
     * @return the items of the customer.
     */
    @Override
    public IItem[] getItems(ICustomer customer) {
        int count = 0;
        IItem[] copyItems = new IItem[this.numberOfItems];
        for (int i = 0; i < this.numberOfItems; i++) {
            if (this.items[i].getCustomer().equals(customer)) {
                copyItems[count] = this.items[i];
                count++;
            }
        }
        return copyItems;
    }

    /**
     * Returns a copy of the collection of item with a given destination.
     * 
     * @param destination the destination of the items.
     * @return the items of the destination.
     */
    @Override
    public IItem[] getItems(IDestination destination) {
        int count = 0;
        IItem[] copyItems = new IItem[this.numberOfItems];
        for (int i = 0; i < this.numberOfItems; i++) {
            if (this.items[i].getDestination().equals(destination)) {
                copyItems[count] = this.items[i];
                count++;
            }
        }
        return copyItems;
    }

    /**
     * Returns a cop+y of the collection of item with the given transportation type.
     * 
     * @param transportationType the transportation types.
     * @return the items of the transportation types.
     */
    @Override
    public IItem[] getItems(TransportationTypes transportationType) {
        int count = 0;
        IItem[] copyItems = new IItem[this.numberOfItems];
        for (int i = 0; i < this.numberOfItems; i++) {
            if (this.items[i].getTransportationTypes().equals(transportationType)) {
                copyItems[count] = this.items[i];
                count++;
            }
        }
        return copyItems;
    }

    /**
     * Returns a copy of the collection of item with the given item status.
     * 
     * @param itemStatus the item status.
     * @return the items of the item status.
     */
    @Override
    public IItem[] getItems(ItemStatus itemStatus) {
        int count = 0;
        IItem[] copyItems = new IItem[this.numberOfItems];
        for (int i = 0; i < this.numberOfItems; i++) {
            if (this.items[i].getStatus().equals(itemStatus)) {
                copyItems[count] = this.items[i];
                count++;
            }
        }
        return copyItems;
    }

    /**
     * Adds a vehicle to the fleet.
     * 
     * @param vehicle the vehicle to be added to the fleet.
     * @return true if the vehicle was inserted, false if the vehicle already exists.
     * @throws ManagementException if the parameter is null.
     */
    @Override
    public boolean addVehicle(IVehicle vehicle) throws ManagementException {
        if (vehicle == null) {
            throw new ManagementExceptionImpl("The parameter is null");
        }
         
        if (this.vehicles.length == this.numberOfVehicles) {
            IVehicle[] clone = this.vehicles;
            this.vehicles = new IVehicle[this.vehicles.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.vehicles[i] = clone[i];
            }
        }

        this.vehicles[this.numberOfVehicles] = vehicle;
        this.numberOfVehicles++;

        return true;
    }

    /**
     * Removes a vehicle from the fleet.
     * 
     * @param vehicle the vehicle to be removed from the fleet.
     * @return true if the vehicle was removed, false if the vehicle do not exists.
     * @throws ManagementException if the parameter is null.
     */
    @Override
    public boolean removeVehicle(IVehicle vehicle) throws ManagementException {
        if (vehicle == null) {
            throw new ManagementExceptionImpl("The parameter is null");
        }

        for (int i = 0; i < this.numberOfVehicles; ++i) {
            if (this.vehicles[i].equals(vehicle)) {
                for (; i < this.numberOfVehicles - 1; i++) {
                    this.vehicles[i] = this.vehicles[i + 1];
                }
                this.vehicles[i] = null;
                this.numberOfVehicles--;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Adds a driver to the system.
     * 
     * @param driver the driver to be added to the system.
     * @return true if the driver was inserted, false if the driver already exists.
     * @throws ManagementException if the parameter is null.
     */
    @Override
    public boolean addDriver(IDriver driver) throws ManagementException {
        if (driver == null) {
            throw new ManagementExceptionImpl("The parameter is null");
        }
         
        if (this.drivers.length == this.numberOfDrivers) {
            IDriver[] clone = this.drivers;
            this.drivers = new IDriver[this.drivers.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.drivers[i] = clone[i];
            }
        }

        this.drivers[this.numberOfDrivers] = driver;
        this.numberOfDrivers++;

        return true;
    }

    @Override
    public boolean removeDriver(IDriver id) throws ManagementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IVehicle[] getFleet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IVehicle[] getFleet(VehicleStatus vs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IVehicle[] getFleet(TransportationTypes tt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IVehicle[] getFleet(VehicleStatus vs, TransportationTypes tt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addDelivery(IDelivery id) throws ManagementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deliveredItem(String string, String string1) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deliveredItem(String string, IDestination id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemStatus checkItemStatus(String string) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startDelivery(String string) throws DeliveryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stopDelivery(String string) throws DeliveryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
