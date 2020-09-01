package Transport;

import transport.IItem;
import transport.IItemPacked;
import transport.IPosition;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class ItemPacked implements IItemPacked {

    /**
     * The packed item.
     */
    private IItem item;

    /**
     * The Item packed position.
     */
    private IPosition position;

    /**
     * Constructor of Item Packed.
     *
     * @param item The packed item.
     * @param position The packed item position.
     */
    public ItemPacked(IItem item, IPosition position) {
        this.item = item;
        this.position = position;
    }

    /**
     * Getter for the packed IItem
     *
     * @return The packed IItem
     */
    @Override
    public IItem getItem() {
        return this.item;
    }

    /**
     * Getter for the IPosition in which the item must be packed
     *
     * @return The Item packed position.
     */
    @Override
    public IPosition getPosition() {
        return this.position;
    }

    /**
     * Setter for the IPosition in which the item must be packed
     *
     * @param position The Item packed position.
     */
    @Override
    public void setPosition(IPosition position) {
        this.position = position;
    }
    
    
    
    /**
     * To String method representing the Item Packed.
     *
     * @return String with all the information about the item packed.
     */
    @Override
    public String toString() {
        return "Item : " + item + "\nPosition: " + position;
    }
}
