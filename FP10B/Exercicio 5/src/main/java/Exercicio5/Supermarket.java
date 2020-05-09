package Exercicio5;
import Exercicio5.Interfaces.MarketService;

/**
 * Classe Supermarket subclasse de Company que implementa a interface MarketService
 * @author Samuel
 */
public class Supermarket extends Company implements MarketService {
    //  variaveis de instancia de Supermarket
    private double potatoesPrice;
    
    /**
     * construtor default de Supermarket
     */
    public Supermarket() {
    }
 
    /**
     * construtor de Supermarket
     * @param potatoesPrice
     * @param name
     * @param vatNumber 
     */
    public Supermarket(double potatoesPrice, String name, int vatNumber) {
        super(name, vatNumber);
        this.potatoesPrice = potatoesPrice;
    }
    
    // GETTERS E SETTERS
    
    /**
     * Getter para potatoes price
     * @return potatoesPrice
     */
    public double getPotatoesPrice() {
        return potatoesPrice;
    }

    /**
     * Setter para potatoes price
     * @param p 
     */
    public void setPotatoesPrice(double p) {
        this.potatoesPrice = p;
    }
    
    /**
     * Método que faz o calculo total de potatoes
     * @param kilos
     * @return total
     */
    public double getMarketTotal(double kilos) {
        double total;
        total = kilos * potatoesPrice;
        return total;
    }
    
    /**
     * Método toString para imprimir
     * @return text
     */
    @Override
    public String toString() {
        String text = "";

        text += super.toString();
        text += "Potatoes price per kilo: " + potatoesPrice + " €"; 
        return text;
    }
}
