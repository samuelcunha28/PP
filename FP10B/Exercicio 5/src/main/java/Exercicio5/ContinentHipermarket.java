package Exercicio5;
import java.util.Calendar;


/**
 * Classe ContinentHipermarket é uma subclasse de Hipermarket
 * @author Samuel
 */
public class ContinentHipermarket extends Hipermarket {
    /**
     * construtor default de ContinentHipermarket
     */
    public ContinentHipermarket() {
    }
    
    /**
     * Construtor de ContinentHipermarket
     * @param coffeePrice
     * @param gasPrice
     * @param aRate
     * @param potatoPrice
     * @param name
     * @param vatNumber 
     */
    public ContinentHipermarket(double coffeePrice, double gasPrice, double aRate, double potatoPrice, String name, int vatNumber) {
        super(coffeePrice, gasPrice, aRate, potatoPrice, name, vatNumber);
    }

    /**
     * Método para calcular o número de pontos de um ContinentHipermarket
     * @param purchaseValue
     * @return 0
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
