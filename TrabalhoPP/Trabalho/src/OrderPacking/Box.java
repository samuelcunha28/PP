package OrderPacking;

import order.packing.IBox;

/**
 *
 * @author samue
 */
public abstract class Box implements IBox {
    
    // variaveis de instancia
    private final int depth;
    private final int height;
    private final int lenght;
    private final int volume;
    
    /**
     * Contrutor de Box
     * @param depth profundidade (inteiro)
     * @param height altura (inteiro)
     * @param lenght comprimento (inteiro)
     * @param volume volume (inteiro)
     */
    public Box (int depth, int height, int lenght, int volume){
        this.depth = depth;
        this.height = height;
        this.lenght = lenght;
        this.volume = depth*height*lenght;   
    }
    

    /**
     * Método para obter a profundidade
     * @return profundidade (inteiro)
     */
    @Override
    public int getDepth() {
        return this.depth;
    }

    /**
     * Método para obter a altura
     * @return altura (inteiro)
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Método para obter o comprimento
     * @return comprimento (inteiro)
     */
    @Override
    public int getLenght() {
       return this.lenght;
    }

    /**
     * Método para obter o volume
     * @return volume (inteiro)
     */
    @Override
    public int getVolume() {
       return this.volume;
    }    
}
