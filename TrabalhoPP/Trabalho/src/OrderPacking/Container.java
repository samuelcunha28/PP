package OrderPacking;

import Exceptions.*;
import order.packing.*;

/**
 *
 * @author samue
 */
public class Container extends Box implements IContainer {

    // variaveis de instancia
    private int volume;
    private int occupiedVolume;
    private String reference;
    private int depth;
    private int height;
    private int length;
    private Color color;
    private Color colorEdge;
    private boolean isClosed = false;
    private IItemPacked[] items = new IItemPacked[10];

    public Container() {
    }

    /**
     * Contrutor de Container
     *
     * @param volume
     * @param reference
     * @param depth
     * @param height
     * @param length
     * @param color
     * @param colorEdge
     */
    public Container(int volume, String reference, int depth, int height, int length, Color color, Color colorEdge) {
        this.volume = volume;
        this.reference = reference;
        this.depth = depth;
        this.height = height;
        this.length = length;
        this.color = color;
        this.colorEdge = colorEdge;
    }

    @Override
    public boolean addItem(IItem item, IPosition pos, Color color) throws ContainerExceptionImpl {
        boolean test = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null && isClosed == false) {
                items[i] = new PackedItem(item, pos, color);
                break;
            } else if (items[items.length - 1] != null || isClosed = true) {
                test = true;
            }
        }
        if (test) {
            isClosed();
            throw new ContainerExceptionImpl("O container ou não tem posicoes disponiveis ou esta fechado");
        }
        return text
    }

    @Override
    public boolean removeItem(IItem arg0) throws ContainerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate() throws ContainerException, PositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws ContainerException, PositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItem getItem(String arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getOccupiedVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItemPacked[] getPackedItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getReference() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRemainingVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDepth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLenght() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColorEdge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(Color arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColorEdge(Color arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
