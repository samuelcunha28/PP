package Exercicio6;

import java.util.Calendar;

/**
 * Classe Jumb Hipermarket que e subclasse de hipermarket
 * @author Samuel
 */
public class JumbHipermarket extends Hipermarket {

    /**
     * Construtor default de JumbHipermarket
     */
    public JumbHipermarket() {
    }

    /**
     * Construtor de JumbHipermarket
     * @param coffeePrice preço de cafe
     * @param gasPrice preço do gas
     * @param aRate taxa de juro
     * @param potatoPrice preço das batatas
     * @param name nome da companhia
     * @param vatNumber numero de contribuinte
     */
    public JumbHipermarket(double coffeePrice, double gasPrice,
            double aRate, double potatoPrice, String name, int vatNumber) {
        super(coffeePrice, gasPrice, aRate, potatoPrice, name, vatNumber);
    }

    /**
     * Metodo que calcula os pontos dados pelo valor da compra
     * dependendo do dia da semana
     * @param purchaseValue valor da compra
     * @return pontos
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
