package OrderPacking;

import order.packing.IBox;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public abstract class Box implements IBox {

    // variaveis de instancia
    private final int depth;
    private final int height;
    private final int length;
    private final int volume;

    /**
     * Contrutor de Box
     *
     * @param depth profundidade (inteiro)
     * @param height altura (inteiro)
     * @param length comprimento (inteiro)
     * @param volume volume (inteiro)
     */
    public Box(int depth, int height, int length, int volume) {
        this.depth = depth;
        this.height = height;
        this.length = length;
        this.volume = depth * height * length;
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
}
