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

    // variaveis de instancia
    private String reference;
    private String description;
    private int x;
    private int y;
    private int z;
    private Color color;
    private Color colorEdge;
    private IItem item;
    private IPosition position;

    public ItemPacked() {
    }
    
    public ItemPacked(IItem item, IPosition position, Color color) {
        this.color = color;
        this.item = item;
        this.position = position;
        this.x = position.getX();
        this.y = position.getY();
        this.z = position.getZ();
        this.description = item.getDescription();
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

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(Color arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColorEdge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColorEdge(Color arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
