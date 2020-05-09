package Hipermarket;

/**
 * Classe de teste de Supermarket
 */
public class SupermarketTest {

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        Hipermarket market = new Hipermarket("Continente", 123456, 0.65, 1.23, 1.1, 2.35);
        System.out.print(market);
        System.out.println("Mensal credit payment : " + market.computeMonthlyPayment(1000, 5) + " €");
    }
}
