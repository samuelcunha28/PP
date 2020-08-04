package Management_Implementation;

import Container_Implementation.Container;
import Exceptions.ContainerException2;
import Exceptions.OrderException2;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.packing.IContainer;
import order.packing.IItemPacked;
import order.management.IShipping;
import order.management.ShipmentStatus;

/**
 * This class represents {@link Shipping}.
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
public class Shipping implements IShipping {

    /**
     * The Shipping id.
     */
    private final int id;

    /**
     * The Shipping next id.
     */
    private static int nextId = 0;

    /**
     * The shipping containers.
     */
    private IContainer[] containers;

    /**
     * The shipping number of containers.
     */
    private int containerNumber;

    /**
     * The shipping status.
     */
    private ShipmentStatus status;

    /**
     * Creates an instance of <code>ShippingOrder</code>
     * 
     */
    public Shipping() {
        this.id = nextId++;
        this.containers = new Container[5];
        this.containerNumber = 0;
        this.status = ShipmentStatus.AWAITS_TREATMENT;

    }

    /**
     * Adds a new {@link Container} to the {@link order.management.IShipping shipping}.
     *
     * @param container {@link Container} to be added.
     * 
     * @return true if the {@link Container} is inserted in the shipping order.
     * false if the {@link Container} already exists in the shipping order.
     * 
     * @throws order.exceptions.OrderException - if the shipping order status is
     * not equal to IN_TREATMENT.
     * 
     * @throws order.exceptions.ContainerException - if any parameter is null or
     * the container is not closed.
     */
    @Override
    public boolean addContainer(IContainer container) throws OrderException, ContainerException {
        if (this.status != ShipmentStatus.IN_TREATMENT) {
            throw new OrderException2("Shipping not in treatment");
        }
        if (container == null) {
            throw new ContainerException2("Container with null reference");
        }
        if (!container.isClosed()) {
            throw new ContainerException2("Container not closed");
        }

        if (this.existsContainer(container)) {
            return false;
        }

        if (this.containers.length == this.containerNumber) {
            IContainer[] clone = this.containers;
            this.containers = new IContainer[this.containers.length * 2];
            for (int i = 0; i < clone.length; i++) {
                this.containers[i] = clone[i];
            }
        }

        this.containers[this.containerNumber] = container;
        this.containerNumber++;

        return true;
    }

    /**
     * Removes a {@link Container} from the {@link Shipping}.
     *
     * @param container {@link Container} to be removed.
     * 
     * @return true if the container is removed in the shipping order. false if
     * the container doesn't exists in the shipping order.
     * 
     * @throws OrderException - if the status is not IN_TREATMENT.
     * 
     * @throws ContainerException - if the parameter is null.
     */
    @Override
    public boolean removeContainer(IContainer container) throws OrderException, ContainerException {
        if (this.status != ShipmentStatus.IN_TREATMENT) {
            throw new OrderException2("Status not in treatment");
        }
        if (container == null) {
            throw new ContainerException2("Null parameter");
        }

        if (this.containerNumber == 0) {
            return false;
        }

        for (int i = 0; i < this.containerNumber; ++i) {
            if (this.containers[i].equals(container)) {
                for (; i < this.containerNumber - 1; i++) {
                    this.containers[i] = this.containers[i + 1];
                }
                this.containers[i] = null;
                this.containerNumber--;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the {@link Container} exists in the {@link Shipping}.
     *
     * @param container - {@link Container} to check existence.
     * 
     * @return true if the container exists in the shipping order or false if
     * the container does not exists in the shipping order.
     */
    @Override
    public boolean existsContainer(IContainer container) {
        int i;
        if (containerNumber == 0) {
            return false;
        }

        for (i = 0; i < this.containerNumber; ++i) {
            if (container.equals(this.containers[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for a given {@link Container} based on its
     * {@link Container#reference}.
     *
     * @param string {@link Container#reference} to find {@link Container}.
     * 
     * @return the {@link Container} with the {@link Container#reference} given
     * as parameter or null if the {@link Container} does not exist.
     */
    @Override
    public IContainer findContainer(String string) {
        int i;
        if (this.containerNumber == 0) {
            return null;
        }
        for (i = 0; i < this.containerNumber; ++i) {
            if (this.containers[i].getReference().equals(string)) {
                return this.containers[i];
            }
        }
        return null;
    }

    /**
     * Getter for {@link ShipmentStatus order status}.
     * 
     * @return {@link ShipmentStatus order status}.
     */
    @Override
    public ShipmentStatus getShipmentStatus() {
        return this.status;
    }

    /**
     * Setter for {@link Shipping#status}.A specific order for
     * {@link Shipping#status} should be preserved:
     *
     * if the @param os is IN_TREATMENT then the {@link Shipping#status} should
     * be: AWAITS_TREATMENT if the @param os is CLOSED then the
     * {@link Shipping#status} should be: IN_TREATMENT and the number of
     * containers in the shipping order should be greater than 0.Additionally,
     * to close the shipping order, the shipping order should be validated if
     * the @param os is SHIPPED then the order {@link Shipping#status} should
     * be: closed
     *
     *
     * @param status new {@link Shipping#status order status} to replace the
     * previous one.
     * @throws order.exceptions.OrderException - if the current
     * {@link Shipping#status} is not compatible with the {@link ShipmentStatus}.
     * @throws order.exceptions.ContainerException - if the volume greater than
     * the current volume (when {@link Shipping} is
     * {@link IShipping#validate() validated}).
     * @throws order.exceptions.PositionException - if some item is outside (or
     * are overflowing) the {@link Container} or if some
     * {@link IItemPacked item} is overlapping with other
     * {@link IItemPacked item} (when shipping order is validated).
     */
    @Override
    public void setShipmentStatus(ShipmentStatus status) throws OrderException, ContainerException, PositionException {
        if (status == ShipmentStatus.IN_TREATMENT) {
            if (this.status != ShipmentStatus.AWAITS_TREATMENT) {
                throw new OrderException2("Shipment not awaiting for treatment");
            }
            this.status = ShipmentStatus.IN_TREATMENT;
            return;
        }

        if (status == ShipmentStatus.CLOSED) {
            if (this.status != ShipmentStatus.IN_TREATMENT) {
                throw new OrderException2("Shipment not in treatment");
            }
            if (this.containerNumber == 0) {
                throw new OrderException2("Shipment with no containers");

            }
            this.validate();
            this.status = ShipmentStatus.CLOSED;
            return;

        }

        if (status == ShipmentStatus.SHIPPED) {
            if (this.status != ShipmentStatus.CLOSED) {
                throw new OrderException2("Shipment not closed");
            }
            this.status = ShipmentStatus.SHIPPED;
            return;

        }

        if (status == ShipmentStatus.RECEIVED) {
            if (this.status != ShipmentStatus.SHIPPED) {
                throw new OrderException2("Shipment not shipped");
            }
            this.status = ShipmentStatus.RECEIVED;
            return;
        }

        if (status == ShipmentStatus.CANCELLED) {
            if (this.status == ShipmentStatus.RECEIVED) {
                throw new OrderException2("Shipment already received");
            }
            this.status = ShipmentStatus.CANCELLED;
            return;
        }

        this.status = status;

    }

    /**
     * Returns an array (without null positions) for the {@link Container} in
     * the {@link Shipping}.
     *
     * @return an array (without null positions) for the {@link Container} in
     * the {@link Shipping}.
     */
    @Override
    public IContainer[] getContainers() {
        IContainer[] array = new Container[this.containerNumber];

        if (this.empty()) {
            return null;
        }

        for (int i = 0; i < this.containerNumber; i++) {
            array[i] = this.containers[i];
        }

        return array;
    }

    /**
     * Checks is the {@link Shipping} is empty or not.
     *
     * @return true if the {@link Shipping} is empty or false if
     * {@link Shipping} is not empty.
     */
    private boolean empty() {
        if (this.containerNumber == 0) {
            return true;
        }

        return false;
    }

    /**
     * Checks if any {@link Container} is invalid.
     *
     * @throws order.exceptions.ContainerException - if the volume greater than
     * the current volume.
     * @throws order.exceptions.PositionException - if some
     * {@link IItemPacked item} is outside (or is overflowing) the container or
     * if some {@link IItemPacked item} is overlapping with other item.
     */
    @Override
    public void validate() throws ContainerException, PositionException {
        for (int i = 0; i < this.containerNumber; i++) {
            this.containers[i].validate();
        }
    }

    /**
     * Returns the shipping cost of the containers as the volume {@link IContainer containers} 
     * multiplied by the price per cubic volume unit defined by {@link Management}.
     * 
     * @return Returns the cost of the containers.
     */
    @Override
    public double getCost() {
        double totalVolume = 0;

        for (IContainer container : this.getContainers()) {
            totalVolume += container.getVolume();
        }

        return (totalVolume * Management.getCubicPrice());
    }
    
    /**
     * Returns a string representation with a summary of the existing
     * {@link Container} and their {@link IItemPacked items}.
     *
     * @return a string representation with a summary of the existing
     * {@link Container} and their {@link IItemPacked items}.
     */
    @Override
    public String summary() {
        String s = "Number of containers: " + this.containerNumber + "\n" + "Total price: " + this.getCost() + "\n\n";
        for (int i = 0; i < this.containerNumber; i++) {
            s += "Container " + (i + 1) + "\n";
            s += this.containers[i].toString();
            if (i != this.containerNumber - 1) {
                s += "\n----------------------------\n";
            }
        }

        return s;
    }
    
    /**
     * Compares two {@link Shipping shippings}.
     * 
     * @param obj object to be compared
     * @return true if @param obj is equal to the {@link Shipping shippings}.
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
        final Shipping other = (Shipping) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
