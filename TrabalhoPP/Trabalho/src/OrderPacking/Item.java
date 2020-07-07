package OrderPacking;

import order.packing.IItem;

/**
 *
 * @author samue
 */
public class Item extends Box implements IItem {

    // variaveis de instancia
    private String reference;
    private String description;

    public Item(int depth, int height, int lenght, int volume) {
        super(depth, height, lenght, volume);
    }

    /**
     * Construtor de Item
     *
     * @param reference referencia do item (String)
     * @param description descricao do item (String)
     * @param depth profundidade do item (inteiro)
     * @param height altura do item (inteiro)
     * @param lenght comprimento do item (inteiro)
     * @param volume volume do item (inteiro)
     */
    public Item(String reference, String description, int depth, int height, int lenght, int volume) {
        super(depth, height, lenght, volume);
        this.reference = reference;
        this.description = description;
    }

    /**
     * Metodo para obter a referencia
     *
     * @return referencia (String)
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    /**
     * Metodo para obter a descricao
     *
     * @return descricao (String)
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Metodo para atribuir a descricao
     *
     * @param description descricao a atribuir (String)
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Metodo toString para imprimir os atributos da classe
     *
     * @return text a imprimir
     */
    @Override
    public String toString() {
        System.out.print(super.toString());
        String text = "Reference : " + reference + "\n"
                + "Description : " + description + "\n";
        return text;
    }
}
