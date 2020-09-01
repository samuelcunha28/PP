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
import transport.IItemPacked;

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

    private double weight;

    /**
     * The delivery driver.
     */
    private IDriver driver;

    /**
     * The delivery items.
     */
    private IItem[] items;

    private IPosition[] positions;

    private IItem item;

    private IItemPacked[] packedItems;

    private int numberItems;

    /**
     * The delivery destination.
     */
    private IDestination destination;

    /**
     * The delivery item status
     */
    private ItemStatus itemStatus;

    private DriverStatus driverStatus;

    private VehicleStatus vehicleStatus;

    private IPosition position;

    /**
     * Constructor of Delivery.
     *
     * @param id The delivery id.
     * @param vehicle The delivery vehicle.
     * @param driver The delivery driver.
     * @param destination The delivery destination.
     * @param status The delivery item status.
     */
    public Delivery(String id, IVehicle vehicle, IDriver driver, IDestination destination, ItemStatus status) {
        this.id = id;
        this.vehicle = vehicle;
        this.driver = driver;
        this.destination = destination;
        this.itemStatus = status;
        this.packedItems = new ItemPacked[5];
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

    /**
     * This method Checks if two {@link IItemPacked items} overlap, returning
     * true if they do or false if they don't.
     *
     * @param item1 First {@link IItemPacked item} to check overlap.
     * @param item2 Second {@link @link IItemPacked item} to check overlap.
     * @return true if {@link @link IItemPacked items} overlap or false if they
     * don't.
     */
    private boolean checkoverlap(IItemPacked item1, IItemPacked item2) {

        if (item1 == null || item2 == null) {
            return false;
        }

        if ((item2.getPosition().getX() < item1.getPosition().getX() + item1.getItem().getLength())
                && (item2.getPosition().getX() + item2.getItem().getLength() > item1.getPosition().getX())
                && (item2.getPosition().getY() < item1.getPosition().getY() + item1.getItem().getHeight())
                && (item2.getPosition().getY() + item2.getItem().getHeight() > item1.getPosition().getY())
                && (item2.getPosition().getZ() < item1.getPosition().getZ() + item1.getItem().getDepth())
                && (item2.getPosition().getZ() + item2.getItem().getDepth() > item1.getPosition().getZ())) {
            return true;
        }
        return false;
    }

    /**
     * Validates the {@link IContainer container} structure.Considering: if the
     * {@link Box#volume volume} if lesser or equal to the current volume;if all
     * {@link IItem items} are inside the {@link IContainer container};if non of
     * the {@link IItem items} inside the {@link IContainer container} are
     * overlapping.
     *
     * @throws Exceptions.DeliveryExceptionImpl
     */
    public void validate() throws DeliveryExceptionImpl {

        IItemPacked[] packedItems = this.getPackedItems();

        for (int i = 0; i < packedItems.length; i++) {
            for (int j = i + 1; j < packedItems.length; j++) {
                if (checkoverlap(packedItems[i], packedItems[j])) {
                    throw new DeliveryExceptionImpl("Box overlap");
                }
            }
        }

    }

    /**
     * Returns an array (without null positions) for the
     * {@link IItemPacked items packed} in the {@link IContainer container}.
     *
     * @return the {@link IItemPacked items packed} in the
     * {@link IContainer container}.
     */
    public IItemPacked[] getPackedItems() {
        int i;

        IItemPacked[] array = new ItemPacked[this.numberItems];

        if (!this.isEmpty()) {
            for (i = 0; i < this.numberItems; i++) {
                array[i] = this.packedItems[i];
            }
        } else {
            return null;
        }
        return array;
    }

    /**
     * Load/add a new item to the delivery in a given position considering
     * transportation restrictions. When the item is loaded/added/inserted, the
     * delivery weight is updated to control the weight. If there isn't enough
     * space in the collection, should be adjusted to store more packed items.
     * Item status must be set to ASSIGNED.
     *
     * @param item item to be added.
     * @param position position in which the item will be placed.
     * @return true if inserted, false if the item already exists in the
     * delivery.
     * @throws DeliveryException if any parameter is null; if item status is not
     * NON_DELIVERED; if no vehicle and/or driver are assigned; if the vehicle
     * status is different from IN PREPARATION; if some item is ouside (or is
     * overflowing) the delivery or if some item is overlapping with other item;
     * if weight is exceeded; if transportation restrictions of the current are
     * not valid for the item
     */
    @Override
    public boolean load(IItem item, IPosition position) throws DeliveryException {
        if (item == null || position == null) {
            throw new DeliveryExceptionImpl("The parameter is null");
        }
        if (item.getStatus() != ItemStatus.NON_DELIVERED) {
            throw new DeliveryExceptionImpl("The item status is non delivered");
        }
        if ((driver.getStatus() != DriverStatus.ASSIGNED) || (vehicle == null)) {
            throw new DeliveryExceptionImpl("Null vehicle or no driver assigned");
        }
        if (vehicle.getStatus() != VehicleStatus.IN_PREPARATION) {
            throw new DeliveryExceptionImpl("The vehicle status is not in preparation");
        }
        if (vehicle.getMaxWeight() < item.getWeight()) {
            throw new DeliveryExceptionImpl("The vehicle status is not in preparation");
        }

        if (this.numberItems != 0) {
            for (IItemPacked itempacked : this.getPackedItems()) {
                if (itempacked.getItem().equals(item)) {
                    return false;
                }
            }
        }

        if (this.packedItems.length == this.numberItems) {
            IItemPacked[] clone = this.packedItems;
            this.packedItems = new ItemPacked[this.packedItems.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.packedItems[i] = clone[i];
            }
        }

        this.packedItems[this.numberItems] = new ItemPacked(item, position);

        this.numberItems++;

        weight = vehicle.getMaxWeight() - item.getWeight();

        // validate();
        return true;
    }

    /**
     * Unloads/Removes an item from the delivery. When the item is removed, the
     * weight should be managed to validate delivery weight.
     *
     * @param item The item to be removed.
     * @param itemStatus The status to be set for the items.
     * @return True if removed, false if the item doesn't exists in the
     * delivery.
     * @throws DeliveryException if the parameter is null; if no vehicle and/or
     * driver are assigned; parameter itemStatus is not ItemStatus.DELIVERED or
     * ItemStatus.NON_DELIVERED; the vehicle status is different from in
     * preparation or in transit.
     */
    @Override
    public boolean unload(IItem item, ItemStatus itemStatus) throws DeliveryException {
        if (item == null || itemStatus == null) {
            throw new DeliveryExceptionImpl("The parameter is null");
        }
        if ((itemStatus != (ItemStatus.NON_DELIVERED)) && (itemStatus != (ItemStatus.DELIVERED))) {
            throw new DeliveryExceptionImpl("The item status is different than non delivered or delivered");
        }
        if ((driver.getStatus() != DriverStatus.ASSIGNED) || (vehicle == null)) {
            throw new DeliveryExceptionImpl("Null vehicle or no driver assigned");
        }
        if (vehicle.getStatus() != VehicleStatus.IN_PREPARATION) {
            throw new DeliveryExceptionImpl("The vehicle status is not in preparation");
        }
        /*
        if (vehicle.getStatus() != VehicleStatus.IN_TRANSIT) {
            throw new DeliveryExceptionImpl("The vehicle status is not in transit");
        }
         */

        for (int i = 0; i < this.numberItems; ++i) {

            if (((Item) item).equals(this.packedItems[i].getItem())) {
                this.weight -= this.packedItems[i].getItem().getWeight();

                for (; i < this.numberItems - 1; i++) {
                    this.packedItems[i] = this.packedItems[i + 1];
                }
                this.packedItems[this.numberItems - 1] = null;
                this.numberItems--;
                this.itemStatus = itemStatus;
                return true;
            }
        }
        return false;
    }

    /**
     * Unloads/Removes all items considering a destination. When the item are
     * removed, the weight should be managed to validate delivery weight.
     *
     * @param destination The item to be removed.
     * @param itemStatus The status to be set for the items.
     * @return True if removed, false if the item doesn't exists in the
     * delivery.
     * @throws DeliveryException if the parameter is null; if no vehicle and/or
     * driver are assigned; parameter itemStatus is not ItemStatus.DELIVERED or
     * ItemStatus.NON_DELIVERED; the vehicle status is different from in
     * preparation or in transit.
     */
    @Override
    public boolean unload(IDestination destination, ItemStatus itemStatus) throws DeliveryException {
        if (destination == null || itemStatus == null) {
            throw new DeliveryExceptionImpl("The parameter is null");
        }
        if ((itemStatus != (ItemStatus.NON_DELIVERED)) && (itemStatus != (ItemStatus.DELIVERED))) {
            throw new DeliveryExceptionImpl("The item status is different than non delivered or delivered");
        }
        if ((driver.getStatus() != DriverStatus.ASSIGNED) || (vehicle == null)) {
            throw new DeliveryExceptionImpl("Null vehicle or no driver assigned");
        }
        if (vehicle.getStatus() != VehicleStatus.IN_PREPARATION) {
            throw new DeliveryExceptionImpl("The vehicle status is not in preparation");
        }
        /*
        if (vehicle.getStatus() != VehicleStatus.IN_TRANSIT) {
            throw new DeliveryExceptionImpl("The vehicle status is not in transit");
        }
         */
        for (int i = 0; i < this.numberItems; ++i) {

            if (((Destination) destination).equals(this.packedItems[i].getItem().getDestination())) {
                this.weight -= this.packedItems[i].getItem().getWeight();

                for (; i < this.numberItems - 1; i++) {
                    this.packedItems[i] = this.packedItems[i + 1];
                }
                this.packedItems[this.numberItems - 1] = null;
                this.numberItems--;
                this.itemStatus = itemStatus;
                return true;
            }
        }
        return false;
    }

    /**
     * Method that returns if delivery is empty.
     *
     * @return true if delivery is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (this.numberItems == 0);
    }

    /**
     * Method that returns the items that are not delivered
     *
     * @return items that are not delivered.
     */
    @Override
    public IItem[] getRemainingItems() {
        IItem[] copyRemaining = new IItem[this.numberItems];
        if (itemStatus == ItemStatus.NON_DELIVERED) {
            for (int i = 0; i < this.numberItems; i++) {
                copyRemaining[i] = this.items[i];
            }
        }
        return copyRemaining;
    }

    /**
     * Method that returns the destination of the items to be delivered.
     *
     * @return The destinations of the items to be delivered, null if none
     * exist.
     */
    @Override
    public IDestination[] getRemainingDestinations() {
        IDestination[] copyRemaining = new IDestination[this.numberItems];

        for (int i = 0; i < this.numberItems; i++) {
            copyRemaining[i] = this.packedItems[i].getItem().getDestination();
        }

        return copyRemaining;
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
                + "\nDestination: " + destination + "\nItem status: " + itemStatus;
    }
}
