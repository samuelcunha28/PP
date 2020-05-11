package Exercicio6;
import Exercicio6.Interfaces.MarketService;

/**
 * Classe Supermarket que e subclasse de company e implementa a interface
 * MarketService
 * @author Samuel
 */
public class Supermarket extends Company implements MarketService {
    /**
     * variaveis de instancia de Supermarket
     */
    private double potatoesPrice;
    
    /**
     * Construtor default de Supermarket
     */
    public Supermarket() {
    }
 
    /**
     * Construtor de Supermarket
     * @param potatoesPrice preço das batatas
     * @param name nome do mercado
     * @param vatNumber numero de contribuinte
     */
    public Supermarket(double potatoesPrice, String name, int vatNumber) {
        super(name, vatNumber);
        this.potatoesPrice = potatoesPrice;
    }
    
    // GETTERS E SETTERS
    /**
     * Getter de potatoes price
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
     * Getter para market total
     * @param kilos quilos de batatas
     * @return total
     */
    public double getMarketTotal(double kilos) {
        double total;
        total = kilos * potatoesPrice;
        return total;
    }
    
    /**
     * Metodo toString para imprimir
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
