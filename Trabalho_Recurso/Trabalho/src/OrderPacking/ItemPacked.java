package OrderPacking;

import order.packing.Color;
import order.packing.IItem;
import order.packing.IItemPacked;
import order.packing.IPosition;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class ItemPacked implements IItemPacked {

    // variaveis de instancia
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
    private IItem iItem;
    private IPosition position;

    public ItemPacked() {
    }

    /**
     * Construtor de ItemPacked
     * @param color cor do item embalado
     * @param iItem item a ser embalado
     * @param position posicao a ser colocado
     */
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

    
    /**
     * Metodo para obter a cor 
     * 
     * @return cor do tipo Color
     */
    @Override
    public Color getColor() {
        return this.color;
    }
    
    /**
     * Metodo para atribuir a cor
     * 
     * @param color cor do tipo Color
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Metodo que obtem o item 
     * 
     * @return item do tipo IItem
     */
    @Override
    public IItem getItem() {
        return this.iItem;
    }

    /**
     * Metodo para obter a posicao
     * 
     * @return posicao do tipo IPosition
     */
    @Override
    public IPosition getPosition() {
        return this.position;
    }

    /**
     * Metodo para atribuir a posicao
     * 
     * @param pos posicao do tipo IPosition
     */
    @Override
    public void setPosition(IPosition pos) {
        this.position = pos;
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
     * Metodo para atribuir a cor das bordas
     * @param colorEdge cor das bordas a atribuir
     */
    @Override
    public void setColorEdge(Color colorEdge) {
        this.color = colorEdge;
    }
    
    /**
     * Metodo toString para imprimir os atributos da classe
     *
     * @return text a imprimir
     */
    @Override
    public String toString() {
        String text = "ITEM PACKED"
                + "Color : " + color + "\n"
                + "Item of IItem type : " + iItem + "\n"
                + "Position : " + position + "\n";
        return text;
    }
}