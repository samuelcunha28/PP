package Hipermarket;

abstract class Company {
    // variaveis de instancia de Company
    private String name;
    private int vatNumber;

    /**
     * Default company constructor
     */
    public Company() {
    }

    // construtor de company
    public Company(String name, int vatNumber) {
        this.name = name;
        this.vatNumber = vatNumber;
    }

    // GETTERS E SETTERS
    public String getName() {
        return name;
    }

    public void setName(String val) {
        this.name = val;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(int val) {
        this.vatNumber = val;
    }

    @Override
    public String toString() {
        String text = "";
        text += "Company name: " + name + "\n";
        text += "Company vatNumber: " + vatNumber + "\n";
        return text;
    }
}
