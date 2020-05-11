package Exercicio6;
import Exercicio6.Interfaces.GasService;

/**
 * Classe Gas Station que representa umas bombas de combustivel que é subclasse de company
 * e implementa a interface GasService
 * @author Samuel
 */
public class GasStation extends Company implements GasService {
    /**
     * Variáveis de instancia de GasStation 
     */
    private double gasPrice;
    private String sname;
    private int count = 0;
    
    /**
     * construtor default de GasStation
     */
    public GasStation() {
    }

    /**
     * Construtor de GasStation
     * @param gasPrice preco da gasolina
     * @param sname nome das bombas
     * @param name nome da companhia
     * @param vatNumber numero de contribuinte
     */
    public GasStation(double gasPrice, String sname, String name, int vatNumber) {
        super();
        super.setName(name);
        super.setVatNumber(vatNumber);
        this.gasPrice = gasPrice;
        this.sname = sname;
    }
    
    
    /**
     * Getter para GasPrice
     * @return gasPrice
     */
    @Override
    public double getGasPrice() {
        return gasPrice;
    }

    /**
     * Setter para GasPrice
     * @param p preco
     */
    @Override
    public void setGasPrice(double p) {
        if (p > 0) {
            gasPrice = p;
        }
    }

    /**
     * Getter para GasTotal
     * @param litres litros
     * @return total 
     */
    @Override
    public double getGasTotal(double litres) {
        double total;
        total = litres * gasPrice;
        return total;
    }

    /**
     * Verificar a Station que tem gasolina mais barata
     * @param gr
     * @return 
     */
    public static GasStation verify(GasStation gr[]) {

        double min = gr[0].gasPrice;
        int i;

        for (i = 1; i < gr.length; i++) {
            if (gr[i].gasPrice < min) {
                min = gr[i].gasPrice;
            }
        }

        for (i = 1; i < gr.length; i++) {
            if (gr[i].gasPrice == min) {
                return gr[i];
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
        text += "Station name: " + sname + "\n";
        text += "Gas price per litre: " + gasPrice + " €" + "\n";

        return text;
    }
}
