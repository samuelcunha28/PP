package Transport;

import exceptions.BoxException;
import hr.ICustomer;
import hr.IDestination;
import java.util.Arrays;
import java.util.Objects;
import transport.IItem;
import transport.ItemStatus;
import transport.TransportationTypes;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Item extends Box implements IItem {

    /**
     * The Item reference.
     */
    private String reference;

    /**
     * The Item description.
     */
    private String description;

    /**
     * The Item transportation types
     */
    private TransportationTypes[] types;

    /**
     * The Item owner.
     */
    private ICustomer customer;

    /**
     * The item destination.
     */
    private IDestination destination;

    /**
     * The item weight.
     */
    private double weight;

    /**
     * The item status.
     */
    private ItemStatus status;

    /**
     * Constructor of Item.
     *
     * @param depth The item depth.
     * @param height The item height.
     * @param length The item length.
     * @param volume The item volume.
     * @param reference The item reference.
     * @param description The item description.
     * @param types The item Transportation Types.
     * @param customer The item owner.
     * @param destination The item destination.
     * @param weight The item weight.
     * @param status The item status.
     */
    public Item(int depth, int height, int length, int volume, String reference, String description, TransportationTypes[] types, ICustomer customer, IDestination destination, double weight, ItemStatus status) {
        super(depth, height, length, volume);
        this.reference = reference;
        this.description = description;
        this.types = types;
        this.customer = customer;
        this.destination = destination;
        this.weight = weight;
        this.status = status;
    }

    /**
     * Getter for the item reference.
     *
     * @return The item reference.
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    /**
     * Setter for the item reference.
     *
     * @param reference The item reference.
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Getter for the item description.
     *
     * @return The item description.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for the item description.
     *
     * @param string The item description.
     */
    @Override
    public void setDescription(String string) {
        this.description = string;
    }

    /**
     * Getter for all the Transportation Types of the item.
     *
     * @return The transportation types of this item.
     */
    @Override
    public TransportationTypes[] getTransportationTypes() {
        return this.types;
    }

    /**
     * Getter for the customer who owns the item.
     *
     * @return The customer who owns the item.
     */
    @Override
    public ICustomer getCustomer() {
        return this.customer;
    }

    /**
     * Setter for the customer who owns the item.
     *
     * @param customer The customer who owns the item.
     */
    public void setCustomer(ICustomer customer) {
        this.customer = customer;
    }

    /**
     * Getter for the destination in which the item must be delivered.
     *
     * @return The destination in which the item must be delivered.
     */
    @Override
    public IDestination getDestination() {
        return this.destination;
    }

    /**
     * Setter for the destination in which the item must be delivered.
     *
     * @param destination The destination in which the item must be delivered.
     */
    public void setDestination(IDestination destination) {
        this.destination = destination;
    }

    /**
     * Getter for the item weight.
     *
     * @return The item weight.
     */
    @Override
    public double getWeight() {
        return this.weight;
    }

    /**
     * Setter for the item weight.
     *
     * @param weight The item weight.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Getter for the item status.
     *
     * @return The item status.
     */
    @Override
    public ItemStatus getStatus() {
        return this.status;
    }

    /**
     * Setter for the item status.
     *
     * @param is The item status.
     */
    @Override
    public void setStatus(ItemStatus is) {
        this.status = is;
    }
    
    

    /**
     * Compares two Items.
     *
     * @param item item to be compared
     * @return true if item is equal to the item reference.
     */
    @Override
    public boolean equals(Object item) {
        if (this == item) {
            return true;
        }
        if (item == null) {
            return false;
        }
        if (getClass() != item.getClass()) {
            return false;
        }
        final Item other = (Item) item;
        if (!Objects.equals(this.reference, other.reference)) {
            return false;
        }
        return true;
    }

    /**
     * To String method representing the Item.
     *
     * @return String with all the information about the item.
     */
    @Override
    public String toString() {
        return super.toString() + "\nReference: " + reference
                + "\nDescription: " + description + "\nTransportation Types: " + Arrays.toString(types)
                + "\nCustomer: " + customer + "\nDestination: " + destination
                + "\nWeight: " + weight + "\nStatus: " + status;
    }
}
