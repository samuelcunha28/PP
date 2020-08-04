package OrderPacking;

import order.packing.IItem;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class Item implements IItem {

    private String reference;
    private int depth;
    private String description;
    private int height;
    private int length;    
    
    /**
     * Construtor de Item
     *
     * @param reference referencia do item (String)
     * @param description descricao do item (String)
     * @param depth profundidade (inteiro)
     * @param height altura (inteiro)
     * @param length comprimento (inteiro)
     */
    public Item(String reference, String description, int depth, int height, int length) {
        this.reference = reference;
        this.description = description;
        this.depth = depth;
        this.height = height;
        this.length = length;
    }

    /**
     * Metodo para obter a referencia do item
     *
     * @return referencia do item (String)
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    /**
     * Metodo para obter a descricao do item
     *
     * @return descricao do item (String)
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Metodo para atribuir a descricao do item
     *
     * @param description descricao do item (String)
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
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
     * Metodo para obter o volume do item
     *
     * @return calculo do volume do item (inteiro)
     */
    @Override
    public int getVolume() {
        int vol = this.depth * this.height * this.length;
        return vol;
    }

    /**
     * Metodo toString para imprimir os atributos da classe
     *
     * @return text a imprimir
     */
    @Override
    public String toString() {
        String text = "ITEM "
                + "Reference : " + reference + "\n"
                + "Description : " + description + "\n"
                + "Depth : " + depth + "\n"
                + "Heigth : " + height + "\n"
                + "Length : " + length + "\n";
        return text;
    }
}
