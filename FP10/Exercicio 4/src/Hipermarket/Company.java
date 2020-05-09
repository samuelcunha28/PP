package Hipermarket;

/**
 * Classe abstrata Company
 */
abstract class Company {
    // variaveis de instancia de Company
    private String name;
    private int vatNumber;

    /**
     * Default company constructor
     */
    public Company() {
    }

    /**
     * construtor de company
     * @param name
     * @param vatNumber
     */
    public Company(String name, int vatNumber) {
        this.name = name;
        this.vatNumber = vatNumber;
    }

    // GETTERS E SETTERS

    /**
     * Getter para name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter para name
     * @param val
     */
    public void setName(String val) {
        this.name = val;
    }

    /**
     * Getter para vatNumber
     * @return varNumber
     */
    public int getVatNumber() {
        return vatNumber;
    }

    /**
     * Setter para vatNumber
     * @param val
     */
    public void setVatNumber(int val) {
        this.vatNumber = val;
    }

    /**
     * Método toString para imprimir
     * @return text
     */
    @Override
    public String toString() {
        String text = "";
        text += "Company name: " + name + "\n";
        text += "Company vatNumber: " + vatNumber + "\n";
        return text;
    }
}
