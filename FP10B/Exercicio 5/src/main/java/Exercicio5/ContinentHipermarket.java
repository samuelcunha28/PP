package Exercicio5;
import java.util.Calendar;

/**
 *
 * @author Samuel
 */
public class ContinentHipermarket extends Hipermarket {
    // construtor default de ContinentHipermarket
    public ContinentHipermarket() {
    }
    
    // construtor de ContinentHipermarket
    public ContinentHipermarket(double coffeePrice, double gasPrice, double aRate, double potatoPrice, String name, int vatNumber) {
        super(coffeePrice, gasPrice, aRate, potatoPrice, name, vatNumber);
    }

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
