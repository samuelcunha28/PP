package Hipermarket;

import Interfaces.HipermarketService;

/**
 * Classe hipermarket subclasse de Company implementa a interface HipermarketService
 */
public class Hipermarket extends Company implements HipermarketService {
    private double coffeePrice;
    private double gasPrice;
    private double aRate;
    private double potatoesPrice;

    /**
     * construtor default de Hipermarket
     */
    public Hipermarket() {
    }

    /**
     * construtor de Hipermarket
     * @param name
     * @param vatNumber
     * @param coffeePrice
     * @param gasPrice
     * @param aRate
     * @param potatoesPrice
     */
    public Hipermarket(String name, int vatNumber, double coffeePrice, double gasPrice, double aRate, double potatoesPrice) {
        super(name, vatNumber);
        this.coffeePrice = coffeePrice;
        this.gasPrice = gasPrice;
        this.aRate = aRate;
        this.potatoesPrice = potatoesPrice;
    }

    /**
     * Getter para coffee price
     * @return coffeePrice
     */
    @Override
    public double getCoffeePrice() {
        return coffeePrice;
    }

    /**
     * Setter para coffee price
     * @param p
     */
    @Override
    public void setCoffeePrice(double p) {
        coffeePrice = p;
    }

    /**
     * Método para cálculo total de coffees
     * @param coffees
     * @return total
     */
    @Override
    public double getCoffeeTotal(int coffees) {
        double total;
        total = coffees * coffeePrice;
        return total;
    }

    /**
     * Getter para annual rate
     * @return aRate
     */
    @Override
    public double getAnnualRate() {
        return aRate;
    }

    /**
     * Setter para annual rate
     * @param r
     */
    @Override
    public void setAnnualRate(double r) {
        aRate = r;
    }

    /**
     * Método para pagamento mental com juro
     * @param ammount
     * @param months
     * @return payment
     */
    @Override
    public double computeMonthlyPayment(double ammount, int months) {
        double payment;
        payment = (ammount * aRate / 12);
        return payment;
    }

    /**
     * Getters para gas price
     * @return gasPrice
     */
    @Override
    public double getGasPrice() {
        return gasPrice;
    }

    /**
     * Setter para gas price
     * @param p
     */
    @Override
    public void setGasPrice(double p) {
        gasPrice = p;
    }

    /**
     * Método para cálculo total de gas
     * @param litres
     * @return total
     */
    @Override
    public double getGasTotal(double litres) {
        double total;
        total = litres * gasPrice;
        return total;
    }

    /**
     * Getter para potatoes price
     * @return potatoesPrice
     */
    @Override
    public double getPotatoesPrice() {
        return potatoesPrice;
    }

    /**
     * Setter para potatoes price
     * @param p
     */
    @Override
    public void setPotatoesPrice(double p) {
        this.potatoesPrice = p;
    }

    /**
     * Método para cálculo total de potatoes
     * @param kilos
     * @return total
     */
    @Override
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
        text += "Coffee Price : " + coffeePrice + " €" + "\n";
        text += "Potatoes Price : " + potatoesPrice + " €" + "\n";
        text += "Gas Price : " + gasPrice + " €" + "\n";
        text += "Anual Rate : " + aRate + "%" + "\n";

        return text;
    }
}
