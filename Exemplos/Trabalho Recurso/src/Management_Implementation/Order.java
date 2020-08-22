package Management_Implementation;

import Exceptions.OrderException2;
import java.time.LocalDate;
import java.util.Arrays;
import order.base.ICustomer;
import order.base.IPerson;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.management.IOrder;
import order.management.IShipping;
import order.management.ShipmentStatus;
import order.packing.IContainer;
import order.packing.IItem;
import order.packing.IItemPacked;

/**
 * This class implements {@link IOrder}.
 *
 * Nome : José Pedro Fernandes 
 * Número: 8190239 
 * Turma: LEI T4
 *
 * Nome: Hugo Maia Alves
 * Número: 8160521
 * Turma: LEIT2
 * 
 */
public class Order implements IOrder {

    /**
     * The order's id.
     */
    private int id;

    /**
     * The order's customer.
     */
    private ICustomer customer;

    /**
     * The order's destination.
     */
    private IPerson destination;

    /**
     * The order's items.
     */
    private IItem[] items;

    /**
     * The order's number of items.
     */
    private int numberOfItems = 0;

    /**
     * The order's shippings.
     */
    private IShipping[] shippings;

    /**
     * The order's number of shippings.
     */
    private int numberOfShippings = 0;

    /**
     * The order's maximum shippings.
     */
    private int maxShippings;

    /**
     * The order's date.
     */
    private LocalDate date;

    /**
     * The order's status.
     */
    private ShipmentStatus status;

    /**
     * Creates an instance of <code>Order</code>.
     * 
     * @param id The order's id.
     * @param customer The order's customer.
     * @param destination The order's destination.
     * @param maxShippings The order's maximum shippings.
     */
    public Order(int id, ICustomer customer, IPerson destination, int maxShippings) {
        this.id = id;
        this.customer = customer;
        this.destination = destination;
        this.date = LocalDate.now();
        this.maxShippings = maxShippings;
        this.shippings = new IShipping[this.maxShippings];
        this.items = new IItem[5];
    }
    
    /**
     * Creates an instance of <code>Order</code>.
     * 
     * @param id The order's id.
     * @param maxShippings The order's maximum shippings.
     */ 
    public Order(int id ,int maxShippings) {
        this.date = LocalDate.now();
        this.maxShippings = maxShippings;
        this.shippings = new IShipping[this.maxShippings];
        this.items = new IItem[5];
    }

    /**
     * Getter of the attribute {@link Order#destination destination}.
     * 
     * @return The {@link Order#destination destination}.
     */
    @Override
    public IPerson getDestination() {
        return this.destination;
    }

    /**
     * Setter for {@link Order#destination destination}.
     * 
     * @param newDestination New {@link Order#destination destination} to replace previous one.
     */
    @Override
    public void setDestination(IPerson newDestination) {
        this.destination = newDestination;
    }

    /**
     * Getter of the attribute {@link Order#customer customer}.
     * 
     * @return The {@link Order#customer customer}.
     */
    @Override
    public ICustomer getCustomer() {
        return this.customer;
    }

    /**
     * Setter for {@link Order#customer customer}.
     * 
     * @param newCustomer New {@link Order#customer customer}.
     */
    @Override
    public void setCustomer(ICustomer newCustomer) {
        this.customer = newCustomer;
    }

    /**
     * Getter of the attribute {@link Order#items items} with no null positions.
     * 
     * @return The {@link Order#items items} with no null positions.
     */
    @Override
    public IItem[] getItems() {
        IItem[] array = new IItem[this.numberOfItems];

        for (int i = 0; i < this.numberOfItems; i++) {
            array[i] = this.items[i];
        }

        return array;
    }

    /**
     * Setter for {@link Order#id id}.
     * 
     * @param id New {@link Order#id id}.
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of the attribute {@link Order#id id}.
     * 
     * @return The {@link Order#id id}.
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Setter for {@link Order#date date}.
     * 
     * @param day New {@link Order order's} day.
     * @param month New {@link Order order's} month.
     * @param year New {@link Order order's} year.
     */
    @Override
    public void setDate(int day, int month, int year) {
        this.date = LocalDate.of(year, month, day);
    }

    /**
     * Getter of the attribute {@link Order#date date}.
     * 
     * @return The {@link Order#date date}.
     */
    @Override
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Adds a new {@link IItem Item} to the {@link IOrder order}.
     * 
     * @param item {@link IItem item} to be added.
     * @return
        {@link Boolean#TRUE true} if the item is inserted.
        {@link Boolean#FALSE false} if the item already exists in the container.

     * @throws OrderException if {@link IItem item} is null.
     */
    @Override
    public boolean add(IItem item) throws OrderException {
        if (item == null) {
            throw new OrderException2("Null parameter");
        }
        for (int i = 0; i < this.numberOfItems; i++) {
            if (item.equals(this.items[i])) {
                return false;
            }
        }

        if (this.numberOfItems == this.items.length) {
            IItem[] clone = this.items;
            this.items = new IItem[this.items.length * 2];
            for (int i = 0; i < this.numberOfItems; i++) {
                this.items[i] = clone[i];
            }
        }
        this.items[this.numberOfItems] = item;
        this.numberOfItems++;

        return true;
    }

    /**
     * Getter of the attribute {@link Order#shippings shippings} with no null positions.
     * 
     * @return The {@link Order#shippings shippings} with no null positions.
     */
    @Override
    public IShipping[] getShippings() {
        IShipping[] ships = new IShipping[this.numberOfShippings];

        for (int i = 0; i < this.numberOfShippings; i++) {
            ships[i] = this.shippings[i];
        }

        return ships;
    }

    /**
     * Add a {@link IShipping shipping} to the {@link IOrder order}.
     * 
     * @param shipping {@link IShipping shipping} details
     * @return
        {@link Boolean#TRUE true} if the {@link IShipping shipping} is inserted in the {@link IOrder order}. 
        The number of {@link IShipping shipping} should limited to the number defined for each {@link IOrder order}
        {@link Boolean#FALSE false} if there isn't more space in the {@link IOrder order}.

     * @throws OrderException if the {@link IOrder order} is {@link ShipmentStatus#CLOSED closed} or if @param shipping is null.
     */
    @Override
    public boolean addShipping(IShipping shipping) throws OrderException {

        if (this.status == ShipmentStatus.CLOSED) {
            throw new OrderException2("Order closed!");
        }
        if (shipping == null) {
            throw new OrderException2("Null parameter");
        }

        if (this.numberOfShippings < this.maxShippings) {
            this.shippings[this.numberOfShippings] = shipping;
            this.numberOfShippings++;
            return true;
        }

        return false;
    }

    /**
     * Remove a {@link IShipping shipping} from the {@link IOrder order}.
     * 
     * @param shipping {@link IShipping shipping} details
     * @return
        {@link Boolean#TRUE true} if the {@link IShipping shipping} is removed in the {@link IOrder order}.
        {@link Boolean#FALSE false} if the {@link IShipping shipping} doesn't exist

     * @throws OrderException if the {@link IOrder order} is {@link ShipmentStatus#CLOSED closed} or if @param shipping is null.
     */
    @Override
    public boolean removeShipping(IShipping shipping) throws OrderException {

        if (this.status == ShipmentStatus.CLOSED) {
            throw new OrderException2("Order closed!");
        }

        if (shipping == null) {
            throw new OrderException2("Null parameter");
        }

        for (int i = 0; i < this.numberOfShippings; i++) {
            if (this.shippings[i].equals(shipping)) {
                this.deleteShipping(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Removes a {@link Shipping shipping} in a certain position.
     *
     * @param i postion where the {@link Shipping shipping} to be removed is.
     */
    private void deleteShipping(int i) {

        for (; i < this.numberOfShippings - 1; i++) {
            this.shippings[i] = this.shippings[i + 1];
        }

        this.shippings[this.numberOfShippings - 1] = null;
        this.numberOfShippings--;
    }

    /**
     * Remove all {@link ShipmentStatus#CANCELLED cancelled} {@link Shipping shippings}
     * from the {@link IOrder order}.
     * 
     * @return Returns the number of {@link ShipmentStatus#CANCELLED cancelled} {@link Shipping shippings}.
     */
    @Override
    public int clean() {
        int deletedShips = 0;

        for (int i = 0; i < this.numberOfShippings; i++) {
            if (this.shippings[i].getShipmentStatus() == ShipmentStatus.CANCELLED) {
                this.deleteShipping(i);
                deletedShips++;
            }
        }

        return deletedShips;
    }

    /**
     * Validate if all containers are valid, if all items are placed inside containers, 
     * and if the same item is not placed inside multiple containers.
     * 
     * @throws OrderException if items are not placed into containers, and if the same item is placed inside multiple containers
     * @throws ContainerException if the {@link IContainer#getOccupiedVolume() volume} greater than the current volume
     * @throws PositionException  if some {@link IItem item} is outside (or is overflowing) the {@link IContainer container} 
     * or if some {@link IItem item} is overlapping with other {@link IItem item}.
     */
    @Override
    public void validate() throws OrderException, ContainerException, PositionException {
        boolean found = false;
        IShipping[] ships;
        IContainer[] conts;
        IItemPacked[] itemsPacked;

        for (IShipping ship : this.getShippings()) {
            ship.validate();
        }

        for (IItem item : this.getItems()) {
            ships = this.getShippings();
            for (IShipping ship : ships) {
                if (this.checkItem(item, ship)) {
                    if (found) {
                        throw new OrderException2("Item " + "\"" + item.getDescription() + "\"" + " is placed in multiple containers");
                    }
                    found = true;
                }
            }
            if (!found) {
                throw new OrderException2("Item " + "\"" + item.getDescription() + "\"" + " is not placed in any container");
            }

            found = false;
        }
    }

    /**
     * Checks if a {@link IItem item} is in a {@link IShipping shipping}.
     * 
     * @param item {@link IItem item} to search in the {@link IShipping shipping} .
     * @param shipping {@link IShipping shipping} where the {@link IItem item} will be searched.
     * @return {@link Boolean#TRUE true} if the item is found, else returns {@link Boolean#FALSE false}.
     */
    private boolean checkItem(IItem item, IShipping shipping) {
        IContainer[] conts = shipping.getContainers();
        IItemPacked[] itemsPacked;
        for (IContainer cont : conts) {
            itemsPacked = cont.getPackedItems();
            for (IItemPacked itemsPacked1 : itemsPacked) {
                if (item.equals(itemsPacked1.getItem())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Close the {@link IOrder order}. Before closing a {@link IOrder#validate() validation} procedure is performed. 
     * And, verifies if all {@link IItem items} were {@link ShipmentStatus#RECEIVED} by the {@link IPerson destination}. 
     * The {@link IShipping shippings} not {@link ShipmentStatus#RECEIVED} must be {@link ShipmentStatus#CANCELLED}.
     * 
     * @throws OrderException if items are not placed into containers, and if the same item is placed inside multiple containers
     * @throws ContainerException if the volume greater than the current volume
     * @throws PositionException if some item is outside (or is overflowing) the container or if some item is overlapping with other item
     */
    @Override
    public void close() throws OrderException, ContainerException, PositionException {
        this.validate();
        for(IShipping shipment : this.shippings){
            if(shipment.getShipmentStatus() != ShipmentStatus.RECEIVED){
                shipment.setShipmentStatus(ShipmentStatus.CANCELLED);
            }
        }
        this.status = ShipmentStatus.CLOSED;
    }

    /**
     * Return the closed status of the {@link IOrder order}.
     * 
     * @return {@link Boolean#TRUE true} if the {@link IOrder order} is {@link ShipmentStatus#CLOSED closed}, 
     * {@link Boolean#FALSE false}  if the {@link IOrder order} is not {@link ShipmentStatus#CLOSED closed}.
     */
    @Override
    public boolean isClosed() {
        return (this.status == ShipmentStatus.CLOSED);
    }

    /**
     * Returns the {@link IOrder order} cost as the sum of the {@link ShipmentStatus#RECEIVED RECEIVED} 
     * {@link IShipping shipping orders} costs.
     * 
     * @return Returns the cost.
     */
    @Override
    public double getCost() {
        double totalCost = 0;

        for (IShipping shipping : this.getShippings()) {
            if (shipping.getShipmentStatus() == ShipmentStatus.RECEIVED) {
                totalCost += shipping.getCost();
            }
        }
        return totalCost;
    }

    /**
     * Returns a string representation with a summary of all information relative to this order
     * 
     * @return a string representation with a summary.
     */
    @Override
    public String summary() {
        String s = "";
        s += "Id: " + this.id;
        s += "\n\nCustomer: \n" + this.customer.toString();
        s += "\n\nDestination: \n" + this.destination.toString();
        s += "\n\nNumber of items : " + this.numberOfItems;

        for (int i = 0; i < this.numberOfItems; i++) {
            s += "\nItem " + (i + 1);
            s += "\n" + this.items[i].toString();
            if (i < this.numberOfItems - 1) {
                s += "\n";
            }
        }

        return s;
    }

    /**
     * Returns the number of {@link IItem items} of the order .
     * 
     * @return Returns the number of {@link IItem items}.
     */
    @Override
    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    /**
     * Gets a boolean representation of an array where true means that the {@link IItem item}
     * is already packed in a {@link IContainer container}.
     * 
     * @return The boolean array that represents the presence of the items in the {@link IContainer containers}.
     */
    private Boolean[] getBooleanItemsToSend() {
        Boolean[] itens = new Boolean[this.numberOfItems];
        Arrays.fill(itens, false);
        for (int i = 0; i < this.numberOfItems; i++) {
            for (int k = 0; k < this.numberOfShippings && !itens[i]; k++) {
                if (this.shippings[k].getShipmentStatus() == ShipmentStatus.SHIPPED
                        || this.shippings[k].getShipmentStatus() == ShipmentStatus.RECEIVED) {
                    if (this.checkItem(this.items[i], this.shippings[k])) {
                        itens[i] = true;
                    }
                }
            }
        }
        return itens;
    }

    /**
     * Returns the number of {@link IItem items} of the {@link IOrder order} that are not been sent.
     * 
     * @return the number of {@link IItem items} of the order that are not been sent.
     */
    @Override
    public int getNumberOfRemaingItemsToSend() {
        Boolean[] itens = this.getBooleanItemsToSend();
        int remainingItems = 0;

        for (Boolean itembool : itens) {
            if (!itembool) {
                remainingItems++;
            }
        }
        return remainingItems;
    }

    /**
     * Getter for a collection of {@link IItem items} of the {@link IOrder order} that are not been sent .
     * 
     * @return {@link IItem items} were not sent.
     */
    @Override
    public IItem[] getRemainingItemsToSend() {
        IItem[] itemsToSend = new IItem[this.getNumberOfRemaingItemsToSend()];
        Boolean[] itens = this.getBooleanItemsToSend();
        int i = 0;
        for (int j = 0; j < itens.length; j++) {
            if (!itens[j]) {
                itemsToSend[i] = this.items[j];
                i++;
            }
        }

        return itemsToSend;
    }

    /**
     * Compares two {@link Order orders}.
     * 
     * @param obj object to be compared
     * @return true if obj is equal to the {@link Order orders}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
