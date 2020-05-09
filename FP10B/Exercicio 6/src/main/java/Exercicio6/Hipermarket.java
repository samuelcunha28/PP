package Exercicio6;
import Exercicio6.Interfaces.HipermarketService;

/**
 *
 * @author Samuel
 */
abstract class Hipermarket extends Supermarket implements HipermarketService {
    // variaveis de instancia de Hipermarket
    private double coffeePrice;
    private double gasPrice;
    private double aRate;

    // construtor default de Hipermarket
    public Hipermarket() {
    }
    
    // construtor de Hipermarket
    public Hipermarket(double coffeePrice, double gasPrice, double aRate, double potatoesPrice, String name, int vatNumber) {
        super(potatoesPrice, name, vatNumber);
        this.coffeePrice = coffeePrice;
        this.gasPrice = gasPrice;
        this.aRate = aRate;
    }
    
    // não implementa este método
    abstract int getPoints(double purchaseValue);

    
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

    // com o calculo do enunciado
    @Override
    public double computeMonthlyPayment(double ammount, int months) {
        double monthlyRate;
        double payment;

        monthlyRate = (Math.pow(1 + aRate, 1 / 12) - 1);
        payment = ((monthlyRate * ammount) / (1 - Math.pow(1 + monthlyRate, -months)));

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

    public static void verifyPoints(double purchaseValue, JumbHipermarket j1, ContinentHipermarket c1){
        int a = j1.getPoints(purchaseValue);
        int b = c1.getPoints(purchaseValue);

        if (a > b){
            System.out.println("O " + j1.getName() + " atribui mais pontos: " + a);
        } else {
            System.out.println("O " + c1.getName() + " atribui mais pontos: " + b);
        }
    }


    public static Hipermarket compararCabaz(Hipermarket[] hipergroup,double q, double l, int c){
        double price =  hipergroup[0].getMarketTotal(q)
                        + hipergroup[0].getGasTotal(l)
                        + hipergroup[0].getCoffeeTotal(c);

        int i;
        for (i = 0; i < hipergroup.length; i++){
            if(hipergroup[i].getMarketTotal(q)+hipergroup[i].getGasTotal(l)+hipergroup[i].getCoffeeTotal(c) < price){
                price = hipergroup[i].getMarketTotal(q)+hipergroup[i].getGasTotal(l)+hipergroup[i].getCoffeeTotal(c);
            }
        }

        for (i = 0; i < hipergroup.length; i++){
            if(hipergroup[i].getMarketTotal(q)+hipergroup[i].getGasTotal(l)+hipergroup[i].getCoffeeTotal(c) == price){
                System.out.println(price);
                return hipergroup[i];
            }
        }
        return null;
    }
    
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
