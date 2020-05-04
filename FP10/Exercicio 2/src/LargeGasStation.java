public class LargeGasStation extends GasStation implements CoffeeService {
    // variaveis de instancia de LargeGasStation
    private double coffeePrice;

    // metodo construtor default de LargeGasStation
    public LargeGasStation() {
    }

    // metodo construtor de LargeGasStation
    public LargeGasStation(double gasPrice, String sname, String name, int vatNumber, double coffeePrice) {
        super(gasPrice, sname, name, vatNumber);
        this.coffeePrice = coffeePrice;
    }

    // metodos de acesso

    @Override
    public double getCoffeePrice() {
        return coffeePrice;
    }

    @Override
    public void setCoffeePrice(double p) {
        this.coffeePrice = p;
    }

    @Override
    public double getCoffeeTotal(int coffees) {
        double total;
        total = coffees * coffeePrice;
        return total;
    }

    @Override
    public String toString(){
        String text = "";
        text += super.toString();
        text += "\n" + "Coffee price : " + coffeePrice + " €" + "\n";
        return text;
    }
}
