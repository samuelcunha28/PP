package Exercicio6;
import java.util.Calendar;

/**
 * Classe que representa um Continent Hipermarket que é subclasse de Hipermarket
 * @author Samuel
 */
public class ContinentHipermarket extends Hipermarket {
    /**
     * Construtor default de ContinentHipermarket
     */
    public ContinentHipermarket() {
    }
    
    /**
     * Construtor de ContinentHipermarket
     * @param coffeePrice preco cafe
     * @param gasPrice preco gasolina
     * @param aRate percentagem juro
     * @param potatoPrice preco batatas
     * @param name nome 
     * @param vatNumber numero de contribuinte
     */
    public ContinentHipermarket(double coffeePrice, double gasPrice, double aRate, double potatoPrice, String name, int vatNumber) {
        super(coffeePrice, gasPrice, aRate, potatoPrice, name, vatNumber);
    }

    /**
     * Metodo que devolve o numero de pontos de acordo com o valor da compra
     * @param purchaseValue valor da compra
     * @return 
     */
    @Override
    int getPoints(double purchaseValue) {
        Calendar c = Calendar.getInstance();
        double less20 = ((1 * purchaseValue) / 5);
        double more21 = ((3 * purchaseValue) / 20);

        if (c.get(Calendar.DAY_OF_MONTH) < 21) {
            return (int) less20;
        } else if (c.get(Calendar.DAY_OF_MONTH) > 20) {
            return (int) more21;
        }
        return 0;
    }
}
