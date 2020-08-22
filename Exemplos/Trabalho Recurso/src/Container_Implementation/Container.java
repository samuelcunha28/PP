package Container_Implementation;

import Exceptions.ContainerException2;
import Exceptions.PositionException2;
import java.util.Objects;
import order.exceptions.BoxException;
import order.exceptions.ContainerException;
import order.exceptions.PositionException;
import order.packing.Color;
import order.packing.IContainer;
import order.packing.IItem;
import order.packing.IItemPacked;
import order.packing.IPosition;

/**
 * This class implements {@link IContainer}.
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
public class Container extends Box implements IContainer {

    /**
     * The container's Items.
     */
    private IItemPacked[] packedItems;

    /**
     * The container's reference.
     */
    private final String reference;

    /**
     * The container's total of {@link IItemPacked items}.
     */
    private int totalItems;

    /**
     * The container's occupied Volume.
     */
    private int occupiedVolume;

    /**
     * The container's closed condition.
     */
    private boolean closed;

    /**
     * The container's color
     */
    private Color color;

    /**
     * The container's color Edge
     */
    private Color edgeColor;

    /**
     * Creates an instance of <code>Container</code>.
     *
     * @param reference The container's reference.
     * @param length The container's length.
     * @param depth The container's depth.
     * @param height The container's height.
     * @param color the container's color.
     * @param edgeColor the container's edge color.
     * 
     * @throws order.exceptions.BoxException if any parameter is less or equal to 0.
     */
    public Container(String reference, int length, int depth, int height, Color color, Color edgeColor) throws BoxException {
        super(length, depth, height);
        this.packedItems = new ItemPacked[5];
        this.reference = reference;
        this.totalItems = 0;
        this.occupiedVolume = 0;
        this.closed = false;
        this.color = color;
        this.edgeColor = edgeColor;
    }

    /**
     * Adds a new {@link IItemPacked item} to the {@link IContainer container} considering the
     * given {@link IItem item}, {@link IPosition position} and {@link Color color}.
     *
     * @param item {@link IItem item} to be packed.
     * @param pos {@link IPosition position} in which the {@link IItem item} will be placed.
     * @param color {@link Color color} used for the {@link IItem item}.
     * 
     * @return true if the {@link IItem item} is is added otherwise returns false.
     * 
     * @throws ContainerException if any parameter is null or the {@link IContainer container} is closed.
     */
    @Override
    public boolean addItem(IItem item, IPosition pos, Color color) throws ContainerException {

        if (item == null) {
            throw new ContainerException2("Null Item");
        }

        if (pos == null) {
            throw new ContainerException2("Null Position");
        }

        if (color == null) {
            throw new ContainerException2("Null Color");
        }

        if (this.closed) {
            throw new ContainerException2("Container closed");
        }

        if (this.totalItems != 0) {
            for (IItemPacked itempacked : this.getPackedItems()) {
                if (itempacked.getItem().equals(item)) {
                    return false;
                }
            }
        }

        if (this.packedItems.length == this.totalItems) {
            IItemPacked[] clone = this.packedItems;
            this.packedItems = new ItemPacked[this.packedItems.length * 2];
            for (int i = 0; i < clone.length; i++) {
                this.packedItems[i] = clone[i];
            }
        }

        this.packedItems[this.totalItems] = new ItemPacked(color, color, item, pos);

        this.occupiedVolume += item.getVolume();

        this.totalItems++;

        return true;
    }

    /**
     * Close the {@link IContainer contanier}. Before closing the {@link IContainer container}, a
     * validation procedure is performed.
     *
     * @throws Exceptions.ContainerException2 if the volume greater than the current volume.
     * @throws Exceptions.PositionException2 if some {@link IItemPacked item} is
     * outside (or is overflowing) the {@link IContainer container} or if some
     * {@link IItemPacked item} is overlapping with other {@link IItemPacked item}.
     */
    @Override
    public void close() throws ContainerException, PositionException {
        this.validate();
        this.closed = true;
    }

    /**
     * Returns the {@link IItem item} with a given {@link Item#reference reference}.
     *
     * @param string {@link Item#reference reference}.
     * @return the specific {@link IItem item} if found, if it's not found returns null.
     */
    @Override
    public IItem getItem(String string) {
        if (this.empty()) {
            return null;
        }
        for (int i = 0; i < packedItems.length; ++i) {
            if (string.equals(packedItems[i].getItem().getReference())) {
                return this.packedItems[i].getItem();
            }
        }
        return null;
    }

    /**
     * Returns the number of {@link IItem items} in the {@link IContainer container}.
     *
     * @return number of {@link IItem items} in the {@link IContainer container}.
     */
    @Override
    public int getNumberOfItems() {
        return this.totalItems;
    }

    /**
     * Return the remaining volume in the {@link IContainer container}.
     *
     * @return The remaning volume in int {@link IContainer container}.
     */
    @Override
    public int getRemainingVolume() {
        return (this.getVolume() - this.occupiedVolume);
    }

    /**
     * Return a boolean value that represents if the {@link IContainer container} is closed or not.
     *
     * @return true if the {@link IContainer container} is closed, false if the
     * {@link IContainer container} is not closed.
     */
    @Override
    public boolean isClosed() {
        return this.closed;
    }

    /**
     * Checks is the {@link IContainer container} is empty or not.
     *
     * @return true if the {@link IContainer container} is empty or false if
     * {@link IContainer container} is not empty.
     */
    private boolean empty() {
        return (this.totalItems == 0);
    }

    /**
     * Removes an {@link IItem item} from the {@link IContainer container}.
     *
     * @param iitem {@link IItem item} to be removed.
     * @return true if occurred successfully and false if not.
     * @throws Exceptions.ContainerException2 if the parameter is null or the
     * {@link IContainer container} is closed.
     */
    @Override
    public boolean removeItem(IItem iitem) throws ContainerException {
        if (iitem == null) {
            throw new ContainerException2("Null item");
        }

        if (this.closed) {
            throw new ContainerException2("Container closed");
        }

        if (this.empty()) {
            return false;
        }

        for (int i = 0; i < this.totalItems; ++i) {

            if (((Item) iitem).equals(this.packedItems[i].getItem())) {
                this.occupiedVolume -= this.packedItems[i].getItem().getVolume();

                for (; i < this.totalItems - 1; i++) {
                    this.packedItems[i] = this.packedItems[i + 1];
                }

                this.packedItems[this.totalItems - 1] = null;
                this.totalItems--;

                return true;
            }
        }

        return false;
    }

    /**
     * This method returns a boolean value to express if there is some box out
     * of the container.
     *
     * @param items array of {@link IItemPacked items} with no null positions.
     * @return true if some {{@link IItemPacked item} is out of the container otherwise returns false.
     */
    private boolean outOfContainer(IItemPacked[] items) {
        for (IItemPacked item : items) {
            if ((item.getItem().getLenght() + item.getPosition().getX() > this.getLenght())
                    || (item.getItem().getDepth() + item.getPosition().getZ() > this.getDepth())
                    || (item.getItem().getHeight() + item.getPosition().getY() > this.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method Checks if two {@link IItemPacked items} overlap, returning true if they do or
     * false if they don't.
     *
     * @param item1 First {@link IItemPacked item} to check overlap.
     * @param item2 Second {@link @link IItemPacked item} to check overlap.
     * @return true if {@link @link IItemPacked items} overlap or false if they don't.
     */
    private boolean checkoverlap(IItemPacked item1, IItemPacked item2) {

        if (item1 == null || item2 == null) {
            return false;
        }

        if ((item2.getPosition().getX() < item1.getPosition().getX() + item1.getItem().getLenght())
                && (item2.getPosition().getX() + item2.getItem().getLenght() > item1.getPosition().getX())
                && (item2.getPosition().getY() < item1.getPosition().getY() + item1.getItem().getHeight())
                && (item2.getPosition().getY() + item2.getItem().getHeight() > item1.getPosition().getY())
                && (item2.getPosition().getZ() < item1.getPosition().getZ() + item1.getItem().getDepth())
                && (item2.getPosition().getZ() + item2.getItem().getDepth() > item1.getPosition().getZ())) {
            return true;
        }
        return false;
    }

    /**
     * Validates the {@link IContainer container} structure. Considering: if the
     * {@link Box#volume volume} if lesser or equal to the current volume;if all
     * {@link IItem items} are inside the {@link IContainer container};if non of the
     * {@link IItem items} inside the {@link IContainer container} are overlapping.
     *
     * @throws Exceptions.ContainerException2 if the {@link Box#volume volume} greater than the
     * current volume.
     * @throws Exceptions.PositionException2 if some {@link IItemPacked item} is
     * outside (or is overflowing) the {@link IContainer container} or if some
     * {@link IItemPacked item} is overlapping with other {@link IItemPacked item}.
     */
    @Override
    public void validate() throws ContainerException, PositionException {
        if (this.getVolume() - this.occupiedVolume < 0) {
            throw new ContainerException2("Container's volume exceeded");
        }

        IItemPacked[] items = this.getPackedItems();
        if (this.outOfContainer(items)) {
            throw new PositionException2("Box out of the container");
        }

        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (checkoverlap(items[i], items[j])) {
                    throw new PositionException2("Overlaping boxs");
                }
            }
        }

    }

    /**
     * Return the occupied volume in the {@link IContainer container}.
     *
     * @return occupied volume in the {@link IContainer container}.
     */
    @Override
    public int getOccupiedVolume() {
        return this.occupiedVolume;
    }

    /**
     * Returns an array (without null positions) for the
     * {@link IItemPacked items packed} in the {@link IContainer container}.
     *
     * @return the {@link IItemPacked items packed} in the {@link IContainer container}.
     */
    @Override
    public IItemPacked[] getPackedItems() {
        int i;

        IItemPacked[] array = new ItemPacked[this.totalItems];

        if (!this.empty()) {
            for (i = 0; i < this.totalItems; i++) {
                array[i] = this.packedItems[i];
            }
        } else {
            return null;
        }

        return array;
    }

    /**
     * Getter for {@link IContainer container} reference that acts as unique identifier for
     * the {@link IContainer container}.
     *
     * @return {@link IContainer container} container reference.
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    /**
     * Returns a string representation of {@link IContainer container}.
     *
     * @return String with every information about {@link IContainer container}.
     */
    @Override
    public String toString() {
        String s = "";
        int i = 0;
        s += "Reference: " + this.reference;
        s += "\nColor: " + this.color;
        s += "\nEdge color: " + this.edgeColor;
        s += "\nClosed: " + this.closed;
        s += "\nLenght: " + this.getLenght();
        s += "\nDepth: " + this.getDepth();
        s += "\nHeight: " + this.getHeight();
        s += "\nTotal Volume: " + this.getVolume();
        s += "\nOccupiedVolume: " + this.occupiedVolume;
        s += "\n" + this.totalItems + " Items:";

        for (IItemPacked item : this.packedItems) {
            ++i;
            if (item != null) {
                s += "\n\nItem " + i + "\n" + item.toString();
            }
        }
        return s;
    }

    /**
     * Getter of the attribute {@link Container#color color}.
     *
     * @return The {@link Container#color color}.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Getter of the attribute {@link Container#edgeColor edge color}.
     *
     * @return The {@link Container#edgeColor edge color}.
     */
    @Override
    public Color getColorEdge() {
        return this.edgeColor;
    }

    /**
     * Setter of the attribute {@link Container#color color}
     * 
     * @param newColor new {@link Color color} to replace the previous one.
     */
    @Override
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    /**
     * Setter of the attribute {@link Container#edgeColor edge color}
     * 
     * @param newColor new {@link Color edge color} to replace the previous one.
     */
    @Override
    public void setColorEdge(Color newColor) {
        this.edgeColor = newColor;
    }

    /**
     * Compares two {@link Container containers}.
     * 
     * @param obj object to be compared
     * @return true if obj is equal to the {@link Container container}.
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
        final Container other = (Container) obj;
        if (!Objects.equals(this.reference, other.reference)) {
            return false;
        }
        return true;
    }

}
