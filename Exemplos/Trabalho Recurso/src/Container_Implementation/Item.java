package Container_Implementation;

import java.util.Objects;
import order.exceptions.BoxException;
import order.packing.IItem;

/**
 * This class implements {@link IItem}.
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
public class Item extends Box implements IItem {

    /**
     * The Item's reference.
     */
    private String reference;

    /**
     * The Item's description.
     */
    private String description;

    /**
     * Creates an instance of <code>Item</code>
     *
     * @param depth The Item's depth.
     * @param height The Item's height.
     * @param length The Item's length.
     * @param reference The Item's reference.
     * @param description The Item's description.
     */
    public Item(int length, int depth, int height, String reference, String description) throws BoxException {
        super(length, depth, height);

        this.reference = reference;
        this.description = description;
    }

    /**
     * Getter for {@link Item#reference item reference} reference that acts as
     * unique identifier for the {@link Item}.
     *
     * @return The {@link Item#reference reference}.
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    /**
     * Gets the attribute {@link Item#description description}.
     *
     * @return The {@link Item#description description}.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the attribute {@link Item#description description}.
     *
     * @param string The Item's description.
     */
    @Override
    public void setDescription(String string) {
        this.description = string;
    }

    /**
     * Compares two {@link Item items}.
     * 
     * @param item object to be compared
     * @return true if obj is equal to the {@link Item items}.
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
     * Returns a string representation of {@link Item}.
     *
     * @return String with every information about {@link Item}.
     */
    @Override
    public String toString() {
        return "Reference: " + reference + "\nDescription: " + description + "\n" + super.toString();
    }

}
