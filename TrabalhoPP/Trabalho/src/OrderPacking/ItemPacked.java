package OrderPacking;

import order.packing.Color;
import order.packing.IItem;
import order.packing.IItemPacked;
import order.packing.IPosition;

/**
 *
 * @author samue
 */
public class ItemPacked extends Colored implements IItemPacked {

    // variaveis de instancia
    private String reference;
    private int depth;
    private int length;
    private int height;
    private int x;
    private int y;
    private int z;
    private IItem item;
    private IPosition position;

    public ItemPacked() {
    }

    public ItemPacked(String reference, int depth, int length, int height, int x, int y, int z, IItem item, IPosition position, Color color, Color colorEdge) {
        super(color, colorEdge);
        this.reference = item.getReference();
        this.depth = item.getDepth();
        this.length = item.getLenght();
        this.height = item.getHeight();
        this.x = position.getX();
        this.y = position.getY();
        this.z = position.getZ();
        this.item = item;
        this.position = position;
    }
    
    /**
     * Metodo para obter o item
     * @return item do tipo IItem
     */
    @Override
    public IItem getItem() {
        return this.item;
    }

    /**
     * Metodo para obter a posicao
     * @return posicao do tipo IPosition
     */
    @Override
    public IPosition getPosition() {
        return this.position;
    }

    /**
     * Metodo para atribuir a posicao
     * @param position posicao a atribuir do tipo IPosition
     */
    @Override
    public void setPosition(IPosition position) {
        this.position = position;
        
        this.x = position.getX();
        this.y = position.getY();
        this.z = position.getZ();
    }
    
    /**
     * Metodo toString para imprimir os atributos da classe
     * @return text a imprimir
     */
     @Override
    public String toString() {
        System.out.print(super.toString());
        String text = "Item : " + item + "\n"
                + "Position : " + position + "\n";
        return text;
    }
}
