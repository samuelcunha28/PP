package OrderPacking;

import Exceptions.*;
import order.packing.*;

import java.util.Arrays;

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

    public Container(int depth, int height, int lenght, int volume) {
        super(depth, height, lenght, volume);
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
        boolean aux = false;

        if (item == null || pos == null || color == null) {
            throw new ContainerExceptionImpl("Nao e possivel adicionar items porque um ou mais parametros esta nulo");
        } else if (isClosed == true) {
            throw new ContainerExceptionImpl("Nao e possivel adicionar items porque o container encontra-se fechado");
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null && isClosed == false && items[i] != pos) {
                items[i] = new ItemPacked(item, pos, color);
                break;
            } else if (items[items.length - 1] != null || isClosed == true || items[i] == pos) {
                aux = true;
            }
        }
        if (aux) {
            isClosed();
            throw new ContainerExceptionImpl("O container ou não tem posicoes disponiveis ou esta fechado");
        }
        return aux;
    }

    /**
     * Metodo que remove um item, verificando atraves da sua referencia Depois
     * de removido, a posicao fica a null e é movido para o ultimo lugar
     *
     * @param item item a remover
     * @return
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean removeItem(IItem item) throws ContainerExceptionImpl {
        int index = 0;
        int j = 0;
        boolean aux = false;
        if (item instanceof IItem) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null && items[i].getItem().getReference().equals(item.getReference())) {
                    index = i;
                    aux = true;
                }
            }
        }
        if (aux) {
            for (j = index; j < items.length - 1 && items[j] != null; j++) {
                items[j] = items[j + 1];
            }
            items[j] = null;
        } else {
            throw new ContainerExceptionImpl("O item a remover nao foi encontrado");
        }
        return aux;
    }

    /**
     *
     * @throws ContainerExceptionImpl
     * @throws PositionExceptionImpl
     */
    @Override
    public void validate() throws ContainerExceptionImpl, PositionExceptionImpl {
        boolean aux = false;
        this.items = getPackedItems();

        if (super.getVolume() < getOccupiedVolume()) {
            throw new ContainerExceptionImpl("O volume ultrapassa o maximo permitido");
        } else if (this.items.length < 1) {
            throw new ContainerExceptionImpl("Nao existem items disponiveis no contentor");
        } else {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    // Testar se os items que estao contido nos pacotes se encontam no contentor
                    if (items[i].getItem().getDepth() > super.getDepth()
                            || items[i].getItem().getHeight() > super.getHeight()
                            || items[i].getItem().getLenght() > super.getLenght()) {
                        throw new PositionExceptionImpl("O item " + items[i].getItem().getReference() + " nao se encontra no container");
                    }
                }
            }
            if (this.items.length == 1) {
                System.out.println("Item validos");
            } else {
                // Testar se os items sobrepõem
                for (int i = 0; i < items.length - 1; i++) {
                    for (int j = 1; j < items.length; j++) {
                        if (i != j) {
                            //X axis test
                            int iMaxX = (items[i].getPosition().getX() + items[i].getItem().getLenght());
                            int iMinX = items[i].getPosition().getX();
                            int jMaxX = (items[j].getPosition().getX() + items[j].getItem().getLenght());
                            int jMinX = items[j].getPosition().getX();
                            //YY variables
                            int iMaxY = items[i].getPosition().getY() + items[i].getItem().getDepth();
                            int iMinY = items[i].getPosition().getY();
                            int jMaxY = items[j].getPosition().getY() + items[j].getItem().getDepth();
                            int jMinY = items[j].getPosition().getY();
                            //ZZ variables
                            int iMaxZ = items[i].getPosition().getZ() + items[i].getItem().getHeight();
                            int iMinZ = items[i].getPosition().getZ();
                            int jMaxZ = items[j].getPosition().getZ() + items[j].getItem().getHeight();
                            int jMinZ = items[j].getPosition().getZ();

                            if (iMaxX > jMinX && jMaxX > iMinX
                                    && iMaxY > jMinY && jMaxY > iMinY
                                    && iMaxZ > jMinZ && jMaxZ > iMinZ) {

                                throw new PositionExceptionImpl("Item: " + items[i].getItem().getReference() + " E Item " + items[j].getItem().getReference() + "Items :" + i + " e " + j + " sobreoem se ");
                            } else {
                                aux = true;
                            }
                        }
                    }
                }
            }
        }
        if (aux) {
            System.out.println("Parabens nao existe OverLap");
        }
    }

    /**
     *
     * @throws ContainerExceptionImpl
     * @throws PositionExceptionImpl
     */
    @Override
    public void close() throws ContainerExceptionImpl, PositionExceptionImpl {
        validate();
        isClosed = true;
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public IItem getItem(String item) {
        IItem aux = null;
        for (int i = 0; i < item.length(); i++) {
            if (items[i] != null && items[i].getItem().getReference().equals(item)) {
                aux = items[i].getItem();
            }
        }
        return aux;
    }

    /**
     *
     * @return
     */
    @Override
    public int getOccupiedVolume() {
        int aux = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                aux += items[i].getItem().getVolume();
            }
        }
        this.occupiedVolume = aux;
        return this.occupiedVolume;
    }

    /**
     *
     * @return
     */
    @Override
    public IItemPacked[] getPackedItems() {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                count++;
            }
        }
        IItemPacked[] itemPacked = new IItemPacked[count];
        for (int i = 0; i < itemPacked.length; i++) {
            itemPacked[i] = items[i];
        }
        return itemPacked;
    }

    /**
     *
     * @return
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    @Override
    public int getNumberOfItems() {
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @return
     */
    @Override
    public int getRemainingVolume() {
        return super.getVolume() - getOccupiedVolume();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isClosed() {
        return isClosed;
    }

    /**
     *
     * @return
     */
    @Override
    public int getDepth() {
        return super.getDepth();
    }

    /**
     *
     * @return
     */
    @Override
    public int getHeight() {
        return super.getHeight();
    }

    /**
     *
     * @return
     */
    @Override
    public int getLenght() {
        return super.getLenght();
    }

    /**
     *
     * @return
     */
    @Override
    public int getVolume() {
        return super.getVolume();
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
     * @param color cor a atribuir
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Metodo para obter a cor das bordas
     *
     * @return cor das bordas do tipo ColorEdge
     */
    @Override
    public Color getColorEdge() {
        return this.colorEdge;
    }

    /**
     * Metodo para atribuit a cor das bordas
     *
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
        System.out.println("Container: ");
        String text = "Packed Items : " + Arrays.toString(items) + "\n"
                + "Reference : " + reference + "\n"
                + "Container Closed? " + isClosed + "\n";
        System.out.println(super.toString());
        return text;
    }
}
