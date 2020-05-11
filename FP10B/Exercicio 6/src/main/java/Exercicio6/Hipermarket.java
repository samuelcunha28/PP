package Exercicio6;
import Exercicio6.Interfaces.HipermarketService;

/**
 * Classe abstrata Hipermarket que e subclasse de Supermarket e implementa
 * a interface HipermarketService
 * @author Samuel
 */
abstract class Hipermarket extends Supermarket implements HipermarketService {
    /**
     * Variaveis de instancia de Hipermarket
     */
    private double coffeePrice;
    private double gasPrice;
    private double aRate;

    /**
     * Construtor default de Hipermarket
     */
    public Hipermarket() {
    }
    
    /**
     * Construtor de Hipermarket
     * @param coffeePrice preço do cafe
     * @param gasPrice preço da gasolina
     * @param aRate taxa de juros
     * @param potatoesPrice preço das batatas
     * @param name nome da companhia
     * @param vatNumber numero de contribuinte
     */
    public Hipermarket(double coffeePrice, double gasPrice, double aRate, double potatoesPrice, String name, int vatNumber) {
        super(potatoesPrice, name, vatNumber);
        this.coffeePrice = coffeePrice;
        this.gasPrice = gasPrice;
        this.aRate = aRate;
    }
    
    /**
     * Não implementa este método
     * @param purchaseValue valor da compra
     * @return 
     */
    abstract int getPoints(double purchaseValue);

    /**
     * Getter de coffe price
     * @return coffeePrice
     */
    @Override
    public double getCoffeePrice() {
        return coffeePrice;
    }

    /**
     * Setter de coffe price
     * @param p preço do café
     */
    @Override
    public void setCoffeePrice(double p) {
        coffeePrice = p;
    }

    /**
     * Getter de coffee total
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
     * @param r rate
     */
    @Override
    public void setAnnualRate(double r) {
        aRate = r;
    }   

    /**
     * Calculo pedido enunciado para o pagamento mensal e os juros
     * @param ammount montante
     * @param months meses
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
     * @param p preço da gasolina
     */
    @Override
    public void setGasPrice(double p) {
        gasPrice = p;
    }

    /**
     * Getter para gas total
     * @param litres litros de gasolina
     * @return total
     */
    @Override
    public double getGasTotal(double litres) {
        double total;
        total = litres * gasPrice;
        return total;
    }

    /**
     * Metodo para verificar pontos (ver qual mercado dá mais pontos)
     * @param purchaseValue valor da compra
     * @param j1 jumb hipermarket
     * @param c1 continent hipermarket
     */
    public static void verifyPoints(double purchaseValue, JumbHipermarket j1, ContinentHipermarket c1){
        int a = j1.getPoints(purchaseValue);
        int b = c1.getPoints(purchaseValue);

        if (a > b){
            System.out.println("O " + j1.getName() + " atribui mais pontos: " + a);
        } else {
            System.out.println("O " + c1.getName() + " atribui mais pontos: " + b);
        }
    }

    /**
     * Metodo que compara qual é o cabaz mais barato
     * @param hipergroup grupo de mercado
     * @param q
     * @param l
     * @param c
     * @return mercado mais barato
     */
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
    
    /**
     * Metodo toString para imprimir
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
