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
     * The number of licenses.
     */
    private int numberOfitems;

    /**
     * Representes the management vehicles.
     */
    private IVehicle[] vehicles;

    /**
     * Representes the management drivers.
     */
    private IDriver[] drivers;

    public Management() {
        this.numberOfitems = 0;
        this.items = new IItem[5];
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
            throw new ManagementExceptionImpl("The item is null");
        }

        if (iitem.getTransportationTypes() == null) {
            throw new ManagementExceptionImpl("The item has no transportation type");
        }

        /**
         * if (iitem == iitem) { throw new ManagementExceptionImpl("The item
         * already exists"); }
         */
        if (this.items.length == this.numberOfitems) {
            IItem[] clone = this.items;
            this.items = new IItem[this.items.length + 1];
            for (int i = 0; i < clone.length; i++) {
                this.items[i] = clone[i];
            }
        }

        this.items[this.numberOfitems] = iitem;
        this.numberOfitems++;

        return true;
    }

    /**
     * Removes an item
     *
     * @param iitem item to be removed
     * @return true if the item is removed
     * @throws ManagementException if the item is null
     */
    @Override
    public boolean removeItem(IItem iitem) throws ManagementException {
        if (iitem == null) {
            throw new ManagementExceptionImpl("The item is null");
        }

        for (int i = 0; i < this.numberOfitems; ++i) {
            if (this.items[i].equals(iitem)) {
                for (; i < this.numberOfitems - 1; i++) {
                    this.items[i] = this.items[i + 1];
                }
                this.items[i] = null;
                this.numberOfitems--;
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
        IItem[] copyItems = new IItem[this.numberOfitems];
        for (int i = 0; i < this.numberOfitems; i++) {
            copyItems[i] = this.items[i];
        }
        return copyItems;
    }

    @Override
    public IItem[] getItems(ICustomer customer) {
        int count = 0;
        IItem[] copyItems = new IItem[this.numberOfitems];
        for (int i = 0; i < this.numberOfitems; i++) {
            if (this.items[i].getCustomer().equals(customer)) {
                copyItems[count] = this.items[i];
                count++;
            }
        }
        return copyItems;
    }

    @Override
    public IItem[] getItems(IDestination id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItem[] getItems(TransportationTypes tt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItem[] getItems(ItemStatus is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addVehicle(IVehicle iv) throws ManagementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addDriver(IDriver id) throws ManagementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeDriver(IDriver id) throws ManagementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeVehicle(IVehicle iv) throws ManagementException {
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
