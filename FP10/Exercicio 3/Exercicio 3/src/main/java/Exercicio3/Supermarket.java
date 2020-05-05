package Exercicio3;

public class Supermarket extends Company {
    //  variaveis de instancia de Supermarket
    private double potatoesPrice;
    
    // construtor default de Supermarket
    public Supermarket() {
    }
 
    // construtor de Supermarket
    public Supermarket(double potatoesPrice, String name, int vatNumber) {
        super(name, vatNumber);
        this.potatoesPrice = potatoesPrice;
    }
    
    // GETTERS E SETTERS
    public double getPotatoesPrice() {
        return potatoesPrice;
    }

    public void setPotatoesPrice(double p) {
        this.potatoesPrice = p;
    }
    
    public double getMarketTotal(double kilos) {
        double total;
        total = kilos * potatoesPrice;
        return total;
    }
    
    @Override
    public String toString() {
        String text = "";

        text += super.toString();
        text += "Potatoes price per kilo: " + potatoesPrice + " €"; 
        return text;
    }
    
}
