package Exercicio5;

import java.util.Calendar;

/**
 *
 * @author Samuel
 */
public class JumbHipermarket extends Hipermarket {

    // construtor default de JumbHipermarket
    public JumbHipermarket() {
    }

    // construtor de JumbHipermarket
    public JumbHipermarket(double coffeePrice, double gasPrice,
            double aRate, double potatoPrice, String name, int vatNumber) {
        super(coffeePrice, gasPrice, aRate, potatoPrice, name, vatNumber);
    }

    @Override
    int getPoints(double purchaseValue) {
        Calendar c = Calendar.getInstance();

        double Wpoints = ((3 * purchaseValue) / 10);
        double WNpoints = ((1 * purchaseValue) / 10);

        switch (c.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
            case Calendar.TUESDAY:
            case Calendar.WEDNESDAY:
            case Calendar.THURSDAY:
            case Calendar.FRIDAY:
                return (int) Wpoints;
            default:
                return (int) WNpoints;
        }
    }
}
