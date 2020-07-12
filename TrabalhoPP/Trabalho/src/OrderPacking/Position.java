package OrderPacking;

import Exceptions.*;
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
public class Position implements IPosition {

    // variaveis de instancia
    private int x;
    private int y;
    private int z;

    public Position() {
    }

    /**
     * Construtor de Position
     *
     * @param x posicao x (inteiro)
     * @param y posicao y (inteiro)
     * @param z posicao z (inteiro)
     */
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Metodo para obter a coordenada x
     *
     * @return coordenada x (inteiro)
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Metodo para atribuir a coordenada x
     *
     * @param val coordenada a inserir (inteiro)
     * @throws PositionExceptionImpl e lancada uma excecao se a coordenada nao
     * for positiva
     */
    @Override
    public void setX(int val) throws PositionExceptionImpl {
        if (val < 0) {
            throw new PositionExceptionImpl("O valor da coordenada a inserir tem que ser superior ou igual a zero");
        } else {
            this.x = val;
        }
    }

    /**
     * Metodo para obter a coordenada y
     *
     * @return coordenada y (inteiro)
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Metodo para atribuir a coordenada y
     *
     * @param val valor da coordenada a inserir
     * @throws PositionExceptionImpl e lancada uma excecao se a coordenada nao
     * for positiva
     */
    @Override
    public void setY(int val) throws PositionExceptionImpl {
        if (val < 0) {
            throw new PositionExceptionImpl("O valor da coordenada a inserir tem que ser superior ou igual a zero");
        } else {
            this.y = val;
        }
    }

    /**
     * Metodo obter a coordenada z
     *
     * @return coordenada z (inteiro)
     */
    @Override
    public int getZ() {
        return this.z;
    }

    /**
     * Metodo para atribuir a coordenada z
     *
     * @param val valor da coordenada a atribuir
     * @throws PositionExceptionImpl e lancada uma excecao se a coordenada nao
     * for positiva
     */
    @Override
    public void setZ(int val) throws PositionExceptionImpl {
        if (val < 0) {
            throw new PositionExceptionImpl("O valor da coordenada a inserir tem que ser superior ou igual a zero");
        } else {
            this.z = val;
        }
    }

    /**
     * Metodo toString para imprimir os atributos da classe
     *
     * @return text a imprimir
     */
    @Override
    public String toString() {
        String text = "POSITION "
                + "Position X : " + x + "\n"
                + "Position Y : " + y + "\n"
                + "Position Z : " + z + "\n";
        return text;
    }
}
