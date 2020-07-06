package OrderPacking;

import Exceptions.*;
import order.packing.*;

/**
 *
 * @author samue
 */
public class Container extends Box implements IContainer {

    // variaveis de instancia
    private int occupiedVolume;
    private String reference;
    private Color color;
    private Color colorEdge;
    private boolean isClosed = false;
    private IItemPacked[] items = new IItemPacked[10];

    public Container() {
    }

    /**
     *
     * @param reference
     * @param color
     * @param colorEdge
     * @param depth
     * @param height
     * @param lenght
     * @param volume
     */
    public Container(String reference, Color color, Color colorEdge, int depth, int height, int lenght, int volume) {
        super(depth, height, lenght, volume);
        this.reference = reference;
        this.color = color;
        this.colorEdge = colorEdge;
    }

    /**
     * Metodo para adicionar um item caso: - Exista uma posicao disponivel; - O
     * container nao esteja fechado; - Nao estejamos a adicionar um item a uma
     * posicao ja ocupada
     *
     * @param item item a adicionar
     * @param pos posicao a ser adicionada
     * @param color cor do item
     * @return
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean addItem(IItem item, IPosition pos, Color color) throws ContainerExceptionImpl {
        boolean test = false;

        if (item == null || pos == null || color == null) {
            throw new ContainerExceptionImpl("Nao e possivel adicionar items porque um ou mais parametros esta nulo");
        } else if (isClosed == true) {
            throw new ContainerExceptionImpl("Nao e possivel adicionar items porque o container encontra-se fechado");
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null && isClosed == false && items[i] != pos) {
                items[i] = new ItemPacked(color, item, pos);
                break;
            } else if (items[items.length - 1] != null || isClosed == true || items[i] == pos) {
                test = true;
            }
        }
        if (test) {
            isClosed();
            throw new ContainerExceptionImpl("O container ou não tem posicoes disponiveis ou esta fechado");
        }
        return test;
    }

    /**
     *
     * @param item
     * @return
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean removeItem(IItem item) throws ContainerExceptionImpl {
        int index = 0;
        int j = 0;
        boolean test = false;
        if (item instanceof IItem) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null && items[i].getItem().getReference().equals(item.getReference())) {
                    index = i;
                    test = true;
                }
            }
        }
        if (test) {
            for (j = index; j < items.length - 1 && items [i] != null; j++) {
                items[j] = items[j + 1];
            }
            items[j] = null;
        } else {
            throw new ContainerExceptionImpl("O item a remover nao foi encontrado");
        }
        return test;
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
