package Exercicio5;
import Exercicio5.Interfaces.HipermarketService;

/**
 * Classe abstrata Hipermarket é uma subclasse de Supermarket e implementa a interface HipermarketService
 * @author Samuel
 */
abstract class Hipermarket extends Supermarket implements HipermarketService {
    /**
     * variaveis de instancia de Hipermarket
     */
    private double coffeePrice;
    private double gasPrice;
    private double aRate;

    /**
     * construtor default de Hipermarket
     */
    public Hipermarket() {
    }
    
    /**
     * construtor de Hipermarket
     * @param coffeePrice
     * @param gasPrice
     * @param aRate
     * @param potatoesPrice
     * @param name
     * @param vatNumber 
     */
    public Hipermarket(double coffeePrice, double gasPrice, double aRate, double potatoesPrice, String name, int vatNumber) {
        super(potatoesPrice, name, vatNumber);
        this.coffeePrice = coffeePrice;
        this.gasPrice = gasPrice;
        this.aRate = aRate;
    }
    
    /**
     * método abstrato
     * @param purchaseValue
     * @return 
     */
    abstract int getPoints(double purchaseValue);

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
     * Método para calcular preço total de coffees
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
     * Setter para AnnualRate
     * @param r 
     */
    @Override
    public void setAnnualRate(double r) {
        aRate = r;
    }   

    /**
     * Faz o calculo pedido no enunciado para pagamentos e rates 
     * @param ammount
     * @param months
     * @return payment
     */
    @Override
    public double computeMonthlyPayment(double ammount, int months) {
        double monthlyRate;
        double payment;

        monthlyRate = (Math.pow(1 + aRate, 1 / 12) - 1);
        payment = ((monthlyRate * ammount) / (1 - Math.pow(1 + monthlyRate, -months)));

        return payment;
    }

    /**
     * Getter para gas price
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
     * Método para calcular o total de gas
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
     * Método toString para imprimir
     * @return text
     */
    @Override
    public String toString() {
        String text = "";

        text += super.toString();
        text += "Coffee Price : " + coffeePrice + " €" + "\n";
        text += "Gas Price : " + gasPrice + " €" + "\n";
        text += "Anual Rate : " + aRate + "%" + "\n";

        return text;
    }
}
