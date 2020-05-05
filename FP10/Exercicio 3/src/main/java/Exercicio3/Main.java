package Exercicio3;

public class Main {

    public static void main(String[] args) {
        Supermarket market1 = new Supermarket(1.5, "Continente", 12345);
        System.out.println(market1);
        market1.setPotatoesPrice(1.25);
        System.out.println("New potatoe price : " + market1.getPotatoesPrice());
        System.out.println("-------------------");
        System.out.println(market1.toString());
        System.out.println("Total potatoes price: " + market1.getMarketTotal(3));
    }

}
