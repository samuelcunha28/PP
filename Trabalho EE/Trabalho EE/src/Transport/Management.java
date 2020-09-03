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
import java.util.Arrays;
import transport.IItemPacked;

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
     * The number of items.
     */
    private int numberOfItems;

    /**
     * Representes the management vehicles.
     */
    private IVehicle[] vehicles;

    /**
     * The number of vehicles.
     */
    private int numberOfVehicles;

    /**
     * Representes the management drivers.
     */
    private IDriver[] drivers;

    /**
     * The number of drivers.
     */
    private int numberOfDrivers;

    /**
     * Represents the management deliveries.
     */
    private IDelivery[] deliveries;

    /**
     * The number of deliveries.
     */
    private int numberOfDeliveries;

    /**
     * The management delivery.
     */
    private IDelivery delivery;

    /**
     * Constructor of management
     */
    public Management() {
        this.numberOfItems = 0;
        this.items = new IItem[5];
        this.numberOfVehicles = 0;
        this.vehicles = new IVehicle[5];
        this.numberOfDrivers = 0;
        this.drivers = new IDriver[5];
        this.numberOfDeliveries = 0;
        this.deliveries = new IDelivery[5];
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
     * Returns a cop+y of the collection of item with the given transportation
     * type.
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
     * @return true if the vehicle was inserted, false if the vehicle already
     * exists.
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
     * @return true if the vehicle was removed, false if the vehicle do not
     * exists.
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
     * @return true if the driver was inserted, false if the driver already
     * exists.
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

    /**
     * Removes a driver from the system.
     *
     * @param driver the driver to be removed.
     * @return true if the driver was removed, false if the driver do no exists
     * @throws ManagementException if parameter is null
     */
    @Override
    public boolean removeDriver(IDriver driver) throws ManagementException {
        if (driver == null) {
            throw new ManagementExceptionImpl("The parameter is null");
        }

        for (int i = 0; i < this.numberOfDrivers; ++i) {
            if (this.drivers[i].equals(driver)) {
                for (; i < this.numberOfDrivers - 1; i++) {
                    this.drivers[i] = this.drivers[i + 1];
                }
                this.drivers[i] = null;
                this.numberOfDrivers--;
                return true;
            }
        }
        return false;
    }

    /**
     * Getter for all vehicle fleet.
     *
     * @return A copy of all vehicle fleet.
     */
    @Override
    public IVehicle[] getFleet() {
        IVehicle[] copyFleet = new IVehicle[this.numberOfVehicles];
        for (int i = 0; i < this.numberOfVehicles; i++) {
            copyFleet[i] = this.vehicles[i];
        }
        return copyFleet;
    }

    /**
     * Getter for all vehicle fleet based on the status.
     *
     * @param status the status for retrieving vehicles.
     * @return a copy of all vehicle fleet with given status.
     */
    @Override
    public IVehicle[] getFleet(VehicleStatus status) {
        int count = 0;
        IVehicle[] copyFleet = new IVehicle[this.numberOfVehicles];
        for (int i = 0; i < this.numberOfVehicles; i++) {
            if (this.vehicles[i].getStatus().equals(status)) {
                copyFleet[count] = this.vehicles[i];
                count++;
            }
        }
        return copyFleet;
    }

    /**
     * Getter for all vehicle fleet based on the transportation type.
     *
     * @param transportationType transportation types for retrieving vehicles.
     * @return a copy of all vehicle fleet with given transportation type.
     */
    @Override
    public IVehicle[] getFleet(TransportationTypes transportationType) {
        int count = 0;
        IVehicle[] copyFleet = new IVehicle[this.numberOfVehicles];
        for (int i = 0; i < this.numberOfVehicles; i++) {
            if (this.vehicles[i].getTransportationTypes().equals(transportationType)) {
                copyFleet[count] = this.vehicles[i];
                count++;
            }
        }
        return copyFleet;
    }

    /**
     * Getter for all vehicle fleet based on the status and transportation type.
     *
     * @param status the status for retrieving vehicles.
     * @param transportationType transportation types for retrieving vehicles.
     * @return a copy of all vehicle fleet with given status and transportation
     * type.
     */
    @Override
    public IVehicle[] getFleet(VehicleStatus status, TransportationTypes transportationType) {
        int count = 0;
        IVehicle[] copyFleet = new IVehicle[this.numberOfVehicles];
        for (int i = 0; i < this.numberOfVehicles; i++) {
            if (this.vehicles[i].getStatus().equals(status) && this.vehicles[i].getTransportationTypes().equals(transportationType)) {
                copyFleet[count] = this.vehicles[i];
                count++;
            }
        }
        return copyFleet;
    }

    /**
     * Adds a new delivery in the system. All items of the delivery must have
     * previously been created in the system and must have a ASSIGNED.
     *
     * @param delivery delivery to be inserted in the system.
     * @return true if the delivery is inserted, false if the delivery already
     * exists.
     * @throws ManagementException if delivery is null; if delivery with items
     * not in the system; if delivery items with status not ASSIGNED; if
     * delivery has no items or the items cannot be stored inside the vehicle;
     * if delivery has no vehicle or cannot transport specific items if delivery
     * has no driver or cannot drive the specific vehicle
     */
    @Override
    public boolean addDelivery(IDelivery delivery) throws ManagementException {
        if (delivery == null) {
            throw new ManagementExceptionImpl("The delivery is null");
        } 
        /*
        Delivery del1 = (Delivery) delivery;
        if (del1.getItemStatus() != ItemStatus.ASSIGNED) {
            throw new ManagementExceptionImpl("The item status is not assigned");
        }
        */
        if (delivery.isEmpty()) {
            throw new ManagementExceptionImpl("The delivery has no items");
        }
        if (delivery.getVehicle() == null) {
            throw new ManagementExceptionImpl("The delivery has no vehicles available");
        }
        if (delivery.getCurrentWeight() > delivery.getVehicle().getMaxWeight()) {
            throw new ManagementExceptionImpl("The delivery has no capacity");
        }
        Delivery del2 = (Delivery) delivery;
        if (del2.getDriver() == null) {
            throw new ManagementExceptionImpl("The delivery has no driver");
        }

        if (this.deliveries.length == this.numberOfDeliveries) {
            IDelivery[] clone = this.deliveries;
            this.deliveries = new IDelivery[this.deliveries.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.deliveries[i] = clone[i];
            }
        }

        this.deliveries[this.numberOfDeliveries] = delivery;
        this.numberOfDeliveries++;
        return true;
    }

    /**
     * Confirms a delivered item. The item must have a state of ASSIGNED. Item
     * status must be changed to delivered.
     *
     * @param idDelivery The delivery id
     * @param reference The item reference
     * @throws Exception if delivery or item is null; 
     
     */
    @Override
    public void deliveredItem(String idDelivery, String reference) throws Exception {
        if (idDelivery == null || reference == null) {
            throw new ManagementExceptionImpl("The delivery id and/or reference are null");
        }

        int deliveryPosition = -1;
        for (int i = 0; i < deliveries.length; i++) {
            if (idDelivery == deliveries[i].getId()) {
                deliveryPosition = i;
                break;
            }
        }

        Delivery tmp = (Delivery) deliveries[deliveryPosition];
        IItemPacked[] items = tmp.getPackedItems();

        for (int i = 0; i < items.length; i++) {
            if (reference == items[i].getItem().getReference()) {
                items[i].getItem().setStatus(ItemStatus.DELIVERED);
                break;
            }
        }
        System.out.println(Arrays.toString(items));
    }

    /**
     * Confirms delivered items to a given destination. The items must have a
     * previous state of ASSIGNED Item status must be changed to DELIVERED
     *
     * @param idDelivery The delivery id
     * @param destination The item destination
     * @throws ManagementException if delivery or item is null; 
     * delivery or item is invalid; 
     * Item do not have a ASSIGNED status.
     */
    @Override
    public void deliveredItem(String idDelivery, IDestination destination) throws Exception {
        if (idDelivery == null || destination == null) {
            throw new ManagementExceptionImpl("The delivery id and/or destination are null");
        }
        Delivery del = (Delivery) delivery;
        if (del.getItemStatus() != ItemStatus.ASSIGNED) {
            throw new ManagementExceptionImpl("The item status  is not assigned");
        }

        int deliveryPosition = -1;
        for (int i = 0; i < deliveries.length; i++) {
            if (idDelivery == deliveries[i].getId()) {
                deliveryPosition = i;
                break;
            }
        }

        Delivery tmp = (Delivery) deliveries[deliveryPosition];
        IItemPacked[] items = tmp.getPackedItems();

        for (int i = 0; i < items.length; i++) {
            if (destination == items[i].getItem().getDestination()) {
                items[i].getItem().setStatus(ItemStatus.DELIVERED);
            }
        }

        System.out.println(Arrays.toString(items));
    }

    /**
     * Checks the state of a item in the system.
     *
     * @param reference The item reference.
     * @return The item status.
     * @throws ManagementException if the item does not exist
     */
    @Override
    public ItemStatus checkItemStatus(String reference) throws Exception {
        if (reference == null) {
            throw new ManagementExceptionImpl("The reference is null");
        }

        for (int i = 0; i < deliveries.length; i++) {
            Delivery tmp = (Delivery) deliveries[i];
            IItemPacked[] items = tmp.getPackedItems();
            for (int j = 0; j < items.length; j++) {
                if (items[j].getItem().getReference() == reference) {
                    return items[j].getItem().getStatus();

                }
            }
        }
        throw new ManagementExceptionImpl("Item does not exist");
    }

    /**
     * Starts a given delivery.
     *
     * @param idDelivery The delivery reference.
     * @throws DeliveryException From starts method.
     */
    @Override
    public void startDelivery(String idDelivery) throws DeliveryException {
        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i].getId() == idDelivery) {
                deliveries[i].start();
                break;
            }
        }
        System.out.println("Delivery " + idDelivery + " has started");
    }

    /**
     * Ends a given delivery.
     *
     * @param idDelivery The delivery reference.
     * @throws DeliveryException From end method.
     */
    @Override
    public void stopDelivery(String idDelivery) throws DeliveryException {
        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i].getId() == idDelivery) {
                deliveries[i].end();
                break;
            }
        }
        System.out.println("Delivery " + idDelivery + " has ended");
    }
}