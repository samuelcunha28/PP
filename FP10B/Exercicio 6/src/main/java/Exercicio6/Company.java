package Exercicio6;

/**
 * Classe Company que representa uma companhia 
 * @author Samuel
 */
abstract class Company {
    /**
     * variaveis de instância de Company
     */
    private String name;
    private int vatNumber;

    /**
     * Construtor default de Company
     */
    public Company() {
    }

    /**
     * Construtor de Company
     * @param name nome da companhia
     * @param vatNumber numero de contribuinte da companhia
     */
    public Company(String name, int vatNumber) {
        this.name = name;
        this.vatNumber = vatNumber;
    }

    // GETTERS E SETTERS
    /**
     * Getter para Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter para name
     * @param name nome
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter para vatnumber
     * @return vatNumber numero de contribuinte
     */
    public int getVatNumber() {
        return vatNumber;
    }

    /**
     * Setter para vatnumber
     * @param vatNumber numero de contribuinte
     */
    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    /**
     * Metodo toString para imprimir
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
