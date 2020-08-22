package Container_Implementation;

import order.packing.Color;
import order.packing.IItem;
import order.packing.IItemPacked;
import order.packing.IPosition;

/**
 * This class implements {@link IItemPacked}.
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
public class ItemPacked implements IItemPacked {

    /**
     * The ItemPacked's color .
     */
    private Color color;

    /**
     * The ItemPacked's edge color.
     */
    private Color edgeColor;

    /**
     * The ItemPacked's item.
     */
    private IItem item;

    /**
     * The ItemPacked's position.
     */
    private IPosition position;

    /**
     * Creates an instance of <code>ItemPacked</code>
     *
     * @param color The ItemPacked's color.
     * @param edgeColor The ItemPacked's edge color.
     * @param item The ItemPacked's {@link IItem}.
     * @param position The ItemPacked's {@link IPosition}.
     */
    public ItemPacked(Color color, Color edgeColor, IItem item, IPosition position) {
        this.color = color;

        if (color == Color.white && edgeColor == Color.white) {
            this.edgeColor = Color.black;
        } else {
            this.edgeColor = edgeColor;
        }

        this.item = item;
        this.position = position;
    }

    /**
     * Gets the attribute {@link ItemPacked#item item}.
     *
     * @return The item of ItemPacked's.
     */
    @Override
    public IItem getItem() {
        return this.item;
    }

    /**
     * Gets the attribute {@link ItemPacked#position position}.
     *
     * @return The ItemPacked's position.
     */
    @Override
    public IPosition getPosition() {
        return this.position;
    }

    /**
     * Sets the attribute {@link ItemPacked#item item}.
     *
     * @param item Item that is to be set.
     */
    public void setItem(IItem item) {
        this.item = item;
    }

    /**
     * Gets the attribute {@link ItemPacked#position position}.
     *
     * @param ip Position that is to be set.
     */
    @Override
    public void setPosition(IPosition ip) {
        this.position = ip;
    }

    /**
     * Sets the attribute color.
     *
     * @param newColor Color that is to be set.
     */
    @Override
    public void setColor(Color newColor) {
        this.color = newColor;
    }

    /**
     * Gets the attribute color.
     *
     * @return The ItemPacked's color.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Getter of the attribute {@link ItemPacked#color color}.
     * 
     * @return The ItemPacked's edge color.
     */
    @Override
    public Color getColorEdge() {
        return this.edgeColor;
    }

    /**
     * Setter of the attribute {@link ItemPacked#edgeColor edge color}.
     * 
     * @param newColor new {@link Color edge color} to replace the previous one.
     */
    @Override
    public void setColorEdge(Color newColor) {
        this.edgeColor = newColor;
    }

    /**
     * Returns a string representation of {@link ItemPacked}.
     *
     * @return String with every information about {@link ItemPacked}.
     */
    @Override
    public String toString() {
        return item.toString() + "\nColor: " + color + "\nEdge color: " + edgeColor + "\n" + position.toString();
    }

}
