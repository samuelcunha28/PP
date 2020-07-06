package OrderPacking;

import Exceptions.*;
import order.packing.IPosition;
/**
 *
 * @author samue
 */
public class Position implements IPosition {
    
    // variaveis de instancia
    private int x;
    private int y;
    private int z;

    public Position() {
    }

    /**
     * Metodo construtor de Position
     * @param x posicao x
     * @param y posicao y
     * @param z posicao z
     */
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Metodo para obter o valor de x
     * @return x
     */
    @Override
    public int getX() {
        return this.x;
    }
    
    /**
     * Metodo para atribuir o valor de x
     * So e atribuido se a variavel for maior ou igual a 0
     * @param x 
     * @throws PositionExceptionImpl caso o valor seja negativo
     */
    @Override
    public void setX(int x) throws PositionExceptionImpl {
        if (x < 0) {
            throw new PositionExceptionImpl("O valor de X deve ser igual ou superior a 0");
        } else {
            this.x = x;
        }
    }

    /**
     * Metodo para obter o valor de y
     * @return y
     */
    @Override
    public int getY() {
        return this.y;
    }
    
    /**
     * Metodo para atribuir o valor de y
     * So e atribuido se a variavel for maior ou igual a 0
     * @param y
     * @throws PositionExceptionImpl caso o valor seja negativo
     */
    @Override
    public void setY(int y) throws PositionExceptionImpl {
        if (y < 0) {
            throw new PositionExceptionImpl("O valor de Y deve ser igual ou superior a 0");
        } else {
            this.y = y;
        }
    }

    /**
     * Metodo para obter o valor de z
     * @return z
     */
    @Override
    public int getZ() {
        return this.z;
    }

    /**
     * Metodo para atribuir o valor de z
     * So e atribuido se a variavel for maior ou igual a 0
     * @param z
     * @throws PositionExceptionImpl caso o valor seja negativo
     */
    @Override
    public void setZ(int z) throws PositionExceptionImpl {
        if (z < 0) {
            throw new PositionExceptionImpl("O valor de Z deve ser igual ou superior a 0");
        } else {
            this.z = z;
        }
    }
  
    /**
     * Metodo toString para imprimir os atributos da classe
     * @return text a imprimir
     */
     @Override
    public String toString() {
        String text = "Posicao X : " + x + "\n"
                + "Posicao Y : " + y + "\n"
                + "Posicao Z : " + z + "\n";
        return text;
    }
}
