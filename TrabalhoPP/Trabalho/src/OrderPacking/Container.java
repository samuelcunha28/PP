package OrderPacking;

import Exceptions.*;
import order.packing.*;

import java.util.Arrays;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
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
    boolean isClosed = false;

    /**
     * Construtor de Container
     *
     * @param volume volume do container (inteiro)
     * @param reference referencia do container (String)
     * @param depth profundidade do container (inteiro)
     * @param color cor do container (tipo Color)
     * @param length comprimento do container (inteiro)
     * @param colorEdge cor das bordas do container (colorEdge do tipo Color)
     * @param height altura do container (inteiro)
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
     * Metodo para adicionar um item caso: - Exista uma posicao disponivel; - O
     * container nao esteja fechado; - Nao estejamos a adicionar um item a uma
     * posicao ja ocupada
     *
     * @param item item a adicionar
     * @param pos posicao a ser adicionada
     * @param color cor do item
     * @return variavel auxiliar
     * @throws ContainerExceptionImpl caso nao hajam posicoes disponiveis ou o
     * container esteja fechado, e lancada uma excecao
     */
    @Override
    public boolean addItem(IItem item, IPosition pos, Color color) throws ContainerExceptionImpl {
        boolean aux = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null && isClosed == false) {
                items[i] = new ItemPacked(color, item, pos);
                break;
            } else if (items[items.length - 1] != null || isClosed == true) {
                aux = true;
            }
        }
        if (aux == true) {
            isClosed();
            throw new ContainerExceptionImpl("Container sem posicoes disponiveis ou Fechado");
        }
        return aux;
    }

    /**
     * Metodo que remove um item, verificando atraves da sua referencia. Depois
     * de removido, a posicao fica a null e é movido para o ultimo lugar
     *
     * @param item item a remover
     * @return variavel auxiliar
     * @throws ContainerExceptionImpl caso nao seja encontrado o item e lancada
     * uma excecao
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
        if (aux == true) {
            for (j = index; j < items.length - 1 && items[j] != null; j++) {
                items[j] = items[j + 1];
            }
            items[j] = null;

        } else {
            throw new ContainerExceptionImpl("Item nao encontrado");
        }
        return aux;
    }

    /**
     * Metodo que valida se todos os items que estao no array dos itens
     * embalados estao dentro do container. Verifica tambem se nao excede os
     * limites do array e se encontram sobrepostos
     *
     * @throws ContainerExceptionImpl caso o volume superar o maximo permitido e
     * lancada uma excecao
     * @throws PositionExceptionImpl caso nao hajam itens no contentor e lancada
     * uma excecao
     */
    @Override
    public void validate() throws ContainerExceptionImpl, PositionExceptionImpl {
        boolean validated = false;
        this.items = getPackedItems();

        if (this.volume < getOccupiedVolume()) {
            throw new ContainerExceptionImpl("O volume supera o maximo que e permitido");
        } else if (this.items.length < 1) {
            throw new ContainerExceptionImpl("Nao foram encontrados itens no contentor");
        } else {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    // Esta condicao testa se os itens estao contidos nas embalagens
                    // Ou seja dentro dos "Item Packed". Se os itens embalados se encontram dentro do container
                    if (items[i].getItem().getDepth() > this.depth
                            || items[i].getItem().getHeight() > this.height
                            || items[i].getItem().getLenght() > this.length) {
                        throw new PositionExceptionImpl("O item: " + items[i].getItem().getReference() + "nao se encontra no container");
                    }
                }
            }
            // As seguintes condicoes testam se os itens se sobrepoem no container
            if (this.items.length == 1) {
                System.out.println("Itens validos");
            } else {
                for (int i = 0; i < items.length - 1; i++) {
                    for (int j = 1; j < items.length; j++) {

                        if (i != j) {
                            // Teste as coordenadas X
                            int iMaxX = (items[i].getPosition().getX() + items[i].getItem().getLenght());
                            int iMinX = items[i].getPosition().getX();
                            int jMaxX = (items[j].getPosition().getX() + items[j].getItem().getLenght());
                            int jMinX = items[j].getPosition().getX();
                            // Teste as coordenadas Y
                            int iMaxY = items[i].getPosition().getY() + items[i].getItem().getDepth();
                            int iMinY = items[i].getPosition().getY();
                            int jMaxY = items[j].getPosition().getY() + items[j].getItem().getDepth();
                            int jMinY = items[j].getPosition().getY();
                            // Teste as coordenadas Z
                            int iMaxZ = items[i].getPosition().getZ() + items[i].getItem().getHeight();
                            int iMinZ = items[i].getPosition().getZ();
                            int jMaxZ = items[j].getPosition().getZ() + items[j].getItem().getHeight();
                            int jMinZ = items[j].getPosition().getZ();

                            // Se os itens se sobrepoem
                            if (iMaxX > jMinX && jMaxX > iMinX
                                    && iMaxY > jMinY && jMaxY > iMinY
                                    && iMaxZ > jMinZ && jMaxZ > iMinZ) {
                                items[i].getItem().getReference();
                                items[j].getItem().getReference();

                                throw new PositionExceptionImpl("Os items :" + i + " e " + j + " sobrepoem-se");
                            } else {
                                validated = true;
                            }
                        }
                    }
                }
            }
        }
        if (validated == true) {
            System.out.println("Nao existem itens sobrepostos e os mesmos sao validos");
        }
    }

    /**
     * Metodo que corre a funcao validate() para verificar se todos os itens se
     * encontram devidamente acomodados, ou seja, se nao existem sobreposicoes e
     * se os mesmos estao embalados e fecha o container
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
     * Metodo que obtem um item pesquisado pela sua referencia
     *
     * @param reference referencia a pesquisar (String)
     * @return IItem item pesquisado
     */
    @Override
    public IItem getItem(String reference) {
        IItem item = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getItem().getReference().equals(reference)) {
                item = items[i].getItem();
            }
        }
        return item;
    }

    /**
     * Metodo que obtem o volume ocupado pelos itens presentes no array de itens
     * embalados
     *
     * @return occupiedVolume volume total ocupado (inteiro)
     */
    @Override
    public int getOccupiedVolume() {
        int vol = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                vol += items[i].getItem().getVolume();
            }
        }
        this.occupiedVolume = vol;
        return this.occupiedVolume;
    }

    /**
     * Metodo que retorna um array novo que e baseado no array inicial items mas
     * apenas com as posicoes dos itens embalados com o numero de itens
     *
     * @return Array de IItemPacked
     */
    @Override
    public IItemPacked[] getPackedItems() {
        int count = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                count++;
            }
        }
        IItemPacked[] iItemPackeds1 = new IItemPacked[count];
        for (int i = 0; i < iItemPackeds1.length; i++) {
            iItemPackeds1[i] = items[i];
        }
        return iItemPackeds1;
    }

    /**
     * Metodo que obtem a referencia do container
     *
     * @return referencia (String)
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    /**
     * Metodo que conta o numero de itens adicionados
     *
     * @return numero de itens (inteiro)
     */
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
     * Metodo que obtem volume restante do container
     *
     * @return volume restante (inteiro)
     */
    @Override
    public int getRemainingVolume() {
        return this.volume - getOccupiedVolume();
    }

    /**
     * Metodo que retorna "true" ou "false" para o caso do container esteja
     * fechado ou nao
     *
     * @return boolean
     */
    @Override
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * Método para obter a profundidade
     *
     * @return profundidade (inteiro)
     */
    @Override
    public int getDepth() {
        return this.depth;
    }

    /**
     * Método para obter a altura
     *
     * @return altura (inteiro)
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Método para obter o comprimento
     *
     * @return comprimento (inteiro)
     */
    @Override
    public int getLenght() {
        return this.length;
    }

    /**
     * Método para obter o volume
     *
     * @return volume (inteiro)
     */
    @Override
    public int getVolume() {
        return this.volume;
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
        String text = "CONTAINER "
                + "Packed Items : " + Arrays.toString(items) + "\n"
                + "Volume : " + volume + "\n"
                + "Reference : " + reference + "\n"
                + "Depth : " + depth + "\n"
                + "Heigth : " + height + "\n"
                + "Length : " + length + "\n"
                + "Is closed ? " + isClosed + "\n";
        return text;
    }
}
