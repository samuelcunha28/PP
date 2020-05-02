package Exercicio1;

public class GasStation extends Company implements GasService {
    // variaveis de instância de GasStation
    private double gasPrice;
    private String sname;
    
    // construtor default de GasStation
    public GasStation() {
    }
    
    // construtor de GasStation
    public GasStation(double gasPrice, String sname, String name, int vatNumber) {
        super(name, vatNumber);
        this.gasPrice = gasPrice;
        this.sname = sname;
    }
    
    @Override
    public double getGasPrice() {
        return gasPrice;
    }

    @Override
    public void setGasPrice(double p) {
        if (p > 0) {
            gasPrice = p;
        }
    }
    
    @Override
    public double getGasTotal(double litres) {
        double total;
        total = litres * gasPrice;
        return total;
    }

    @Override
    public String toString() {
        String text = "";

        text += super.toString();
        text += "Station name: " + sname + "\n";
        text += "Gas price per litre: " + gasPrice + " €";

        return text;
    }
    
}
