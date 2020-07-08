package OrderPacking;

import order.packing.Color;
import order.packing.IItem;
import order.packing.IItemPacked;
import order.packing.IPosition;

/**
 *
 * @author samue
 */
public class ItemPacked implements IItemPacked {

    private String reference;
    private int depth;
    private Color color;
    private int x;
    private int length;
    private int y;
    private String description;
    private int z;
    private Color colorEdge;
    private int height;
    private transient IItem iItem;
    private transient IPosition position;

    public ItemPacked() {
    }

    public ItemPacked(Color color, IItem iItem, IPosition position) {
        this.reference = iItem.getReference();
        this.depth = iItem.getDepth();
        this.color = color;
        this.x = position.getX();
        this.length = iItem.getLenght();
        this.y = position.getY();
        this.description = iItem.getDescription();
        this.z = position.getZ();
        this.colorEdge = color;
        this.height = iItem.getHeight();

        this.iItem = iItem;
        this.position = position;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public IItem getItem() {
        return this.iItem;
    }

    @Override
    public IPosition getPosition() {
        return this.position;
    }

    @Override
    public void setColor(Color color) {

        this.color = color;
    }

    @Override
    public void setPosition(IPosition iPosition) {

        this.position = iPosition;
        this.x = position.getX();
        this.y = position.getY();
        this.z = position.getZ();
    }
    
    /**
     * Metodo para obter a cor das bordas
     * @return cor das bordas do tipo ColorEdge
     */
    @Override
    public Color getColorEdge() {
        return this.colorEdge;
    }

    /**
     * Metodo para atribuit a cor das bordas
     * @param colorEdge cor das bordas a atribuir
     */
    @Override
    public void setColorEdge(Color colorEdge) {
        this.color = colorEdge;
    }

    @Override
    public String toString() {
        return "PackedItem{"
                + "color=" + color
                + ", iItem=" + iItem
                + ", position=" + position
                + '}';
    }
}