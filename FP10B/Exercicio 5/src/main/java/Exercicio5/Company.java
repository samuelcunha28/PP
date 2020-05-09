package Exercicio5;

/**
 * Classe abstrata para Company
 * @author Samuel
 */
abstract class Company {
    // variaveis de instância de Company
    private String name;
    private int vatNumber;

    /**
     * Construtor default de Company
     */
    public Company() {
    }

    /**
     * Construtor de Company
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
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter para vatNumber
     * @return vatNumber
     */
    public int getVatNumber() {
        return vatNumber;
    }

    /**
     * Setter para vatNumber
     * @param vatNumber 
     */
    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
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
