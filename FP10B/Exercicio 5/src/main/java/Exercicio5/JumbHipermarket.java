package Exercicio5;

import java.util.Calendar;

/**
 * Classe JumbHipermarket subclasse de Hipermarket
 * @author Samuel
 */
public class JumbHipermarket extends Hipermarket {

    /**
     * construtor default de JumbHipermarket
     */
    public JumbHipermarket() {
    }

    /**
     * construtor de JumbHipermarket
     * @param coffeePrice
     * @param gasPrice
     * @param aRate
     * @param potatoPrice
     * @param name
     * @param vatNumber 
     */
    public JumbHipermarket(double coffeePrice, double gasPrice,
            double aRate, double potatoPrice, String name, int vatNumber) {
        super(coffeePrice, gasPrice, aRate, potatoPrice, name, vatNumber);
    }

    /**
     * Método para calculo de points para JumbHipermarket pedido no enunciado
     * @param purchaseValue
     * @return 
     */
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
