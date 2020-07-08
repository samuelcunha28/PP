package OrderPacking;

import Exceptions.*;
import order.packing.*;

import java.util.Arrays;

/**
 *
 * @author samue
 */
public class Container implements IContainer {

    private int volume;
    private String reference;
    private int depth;
    private Color color;
    private int length;
    private Color colorEdge;
    private IItemPacked[] items = new IItemPacked[10];
    private int height;
    private int occupiedVolume;
    transient boolean isClosed = false;

    /**
     * Constructor de container para definir os parametros da classe
     *
     * @param volume
     * @param reference
     * @param depth
     * @param height
     * @param length
     */
    public Container(int volume, String reference, int depth, Color color, int length, Color colorEdge, int height) {
        this.volume = volume;
        this.reference = reference;
        this.depth = depth;
        this.height = height;
        this.length = length;
        this.color = color;
        this.colorEdge = colorEdge;
    }

    /**
     * Adiciona um item caso exista uma posicao disponivel Falta: Verificar a
     * posicao
     *
     * @param iItem
     * @param iPosition
     * @param color
     * @return
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean addItem(IItem iItem, IPosition iPosition, Color color) throws ContainerExceptionImpl {
        boolean test = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null && isClosed == false) {
                items[i] = new ItemPacked(color, iItem, iPosition);
                break;
            } else if (items[items.length - 1] != null || isClosed == true) {
                test = true;
            }
        }
        if (test) {
            isClosed();
            throw new ContainerExceptionImpl("Container sem posicoes disponiveis ou Fechado");
        }
        return test;
    }

    /**
     * Remove um item verificando a sua referencia, depois move a posicao null
     * para ultimo
     *
     * @param iItem
     * @return
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean removeItem(IItem iItem) throws ContainerExceptionImpl {
        int rmIndex = 0;
        boolean test = false;
        if (iItem instanceof IItem) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null && items[i].getItem().getReference().equals(iItem.getReference())) {
                    rmIndex = i;
                    test = true;
                }
            }
        }

        int j;
        if (test) {
            for (j = rmIndex; j < items.length - 1 && items[j] != null; j++) {
                items[j] = items[j + 1];
            }
            items[j] = null;

        } else {
            throw new ContainerExceptionImpl("Item nao encontrado");
        }
        return test;
    }

    /**
     * Valida Se todos os Items no array "iItemPackeds" estao dentro do contetor
     * Se nao excedem os limites do mesmo e se nao se sobrepoem
     *
     * @throws ContainerExceptionImpl
     * @throws PositionExceptionImpl
     */
    @Override
    public void validate() throws ContainerExceptionImpl, PositionExceptionImpl {

        boolean validated = false;
        this.items = getPackedItems();

        if (this.volume < getOccupiedVolume()) {

            throw new ContainerExceptionImpl("Volume superior ao maximo permitido");
        } else if (this.items.length < 1) {
            throw new ContainerExceptionImpl("Nao Existem Items no Contentor");
        } else {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    //Testa se os Items dentro dos Packed Items se encontram dentro do container
                    if (items[i].getItem().getDepth() > this.depth
                            || items[i].getItem().getHeight() > this.height
                            || items[i].getItem().getLenght() > this.length) {
                        throw new PositionExceptionImpl("Item: " + items[i].getItem().getReference() + "Encontra-se fora do container");
                    }
                }
            }

            if (this.items.length == 1) {
                System.out.println("Valido");
            } else {
                //Testar se os itens se sopreoeem
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
                                validated = true;
                            }
                        }
                    }
                }
            }
        }
        if (validated) {
            System.out.println("Parabens nao existe OverLap");
        }
    }

    /**
     * Corre a funcao validate() verificando se todos os itens se encontram
     * devidamente acomodados
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
     * Retorna um item pesquisado pela sua referencia
     *
     * @param s
     * @return IItem
     */
    @Override
    public IItem getItem(String s) {
        IItem tmp = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getItem().getReference().equals(s)) {
                tmp = items[i].getItem();
            }
        }
        return tmp;
    }

    /**
     * Retorna o sumatorio do volume de todos os items presentes no array de
     * Packed Items
     *
     * @return occupiedVolume
     */
    @Override
    public int getOccupiedVolume() {
        int tmp = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                tmp += items[i].getItem().getVolume();
            }
        }
        this.occupiedVolume = tmp;
        return this.occupiedVolume;
    }

    /**
     * Retorna um array novo baseado no array inical de Items mas apenas com as
     * posicoes iguais aonumro de items
     *
     * @return Array de IItemPacked
     */
    @Override
    public IItemPacked[] getPackedItems() {
        int tmp = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                tmp++;
            }
        }
        IItemPacked[] iItemPackeds1 = new IItemPacked[tmp];
        for (int i = 0; i < iItemPackeds1.length; i++) {
            iItemPackeds1[i] = items[i];
        }
        return iItemPackeds1;
    }

    /**
     * Retorna a referencia do Container
     *
     * @return Reference
     */
    @Override
    public String getReference() {

        return this.reference;
    }

    /**
     * Contador do numero de items adicionados
     *
     * @return int
     */
    @Override
    public int getNumberOfItems() {
        int tmp = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                tmp++;
            }
        }
        return tmp;
    }

    /**
     * Calcula o volume libre restante no container
     *
     * @return getOccupiedVolume
     */
    @Override
    public int getRemainingVolume() {
        return this.volume - getOccupiedVolume();
    }

    /**
     * Retorna um boleano que e alterado na funcao validate()
     *
     * @return boolean isClosed
     */
    @Override
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * profundidade do Container
     *
     * @return depth
     */
    @Override
    public int getDepth() {
        return this.depth;
    }

    /**
     * Altura do Container
     *
     * @return height
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Cumprimento do Container
     *
     * @return length
     */
    @Override
    public int getLenght() {
        return this.length;
    }

    /**
     * Volume Ttal do Container
     *
     * @return volume
     */
    @Override
    public int getVolume() {
        return this.volume;
    }

    /**
     * Metodo toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Container{"
                + "iItemPackeds=" + Arrays.toString(items)
                + ", volume=" + volume
                + ", reference='" + reference + '\''
                + ", depth=" + depth
                + ", height=" + height
                + ", lenght=" + length
                + ", isClosed=" + isClosed
                + '}';
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

    }
}
