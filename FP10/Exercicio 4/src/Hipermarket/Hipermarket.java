package Hipermarket;

import Interfaces.HipermarketService;

public class Hipermarket extends Company implements HipermarketService {
    private double coffeePrice;
    private double gasPrice;
    private double aRate;
    private double potatoesPrice;

    // construtor default de Hipermarket
    public Hipermarket() {
    }

    // construtor de Hipermarket
    public Hipermarket(String name, int vatNumber, double coffeePrice, double gasPrice, double aRate, double potatoesPrice) {
        super(name, vatNumber);
        this.coffeePrice = coffeePrice;
        this.gasPrice = gasPrice;
        this.aRate = aRate;
        this.potatoesPrice = potatoesPrice;
    }

    @Override
    public double getCoffeePrice() {
        return coffeePrice;
    }

    @Override
    public void setCoffeePrice(double p) {
        coffeePrice = p;
    }

    @Override
    public double getCoffeeTotal(int coffees) {
        double total;
        total = coffees * coffeePrice;
        return total;
    }

    @Override
    public double getAnnualRate() {
        return aRate;
    }

    @Override
    public void setAnnualRate(double r) {
        aRate = r;
    }

    @Override
    public double computeMonthlyPayment(double ammount, int months) {
        double payment;
        payment = (ammount * aRate / 12);
        return payment;
    }

    @Override
    public double getGasPrice() {
        return gasPrice;
    }

    @Override
    public void setGasPrice(double p) {
        gasPrice = p;
    }

    @Override
    public double getGasTotal(double litres) {
        double total;
        total = litres * gasPrice;
        return total;
    }

    @Override
    public double getPotatoesPrice() {
        return potatoesPrice;
    }

    @Override
    public void setPotatoesPrice(double p) {
        this.potatoesPrice = p;
    }

    @Override
    public double getMarketTotal(double kilos) {
        double total;
        total = kilos * potatoesPrice;
        return total;
    }

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
