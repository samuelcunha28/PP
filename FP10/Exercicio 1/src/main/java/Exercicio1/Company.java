package Exercicio1;

public class Company {
    // variaveis de instância de Company
    private String name;
    private int vatNumber;
    
    // construtor default de Company
    public Company() {
    }
    
    // construtor de Company
    public Company(String name, int vatNumber) {
        this.name = name;
        this.vatNumber = vatNumber;
    }
    
    
    // GETTERS E SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    } 
    
    @Override
    public String toString() {
        String text = "";
        text += "Company name: " + name + "\n";
        text += "Company vatNumber: " + vatNumber + "\n";
        return text;
    }
}