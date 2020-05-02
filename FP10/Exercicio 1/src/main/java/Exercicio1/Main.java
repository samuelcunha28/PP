package Exercicio1;

public class Main {

    public static void main(String[] args) {
        GasStation station1 = new GasStation(1.34, "Station 1", "Galp Energias", 12345);
        System.out.println(station1.toString());
        System.out.println("---------------------------");
        station1.setGasPrice(2.35);
        System.out.println("New gas price : " + station1.getGasPrice());
        System.out.println("---------------------------");
        System.out.println("Informacao nova------------");
        System.out.println(station1.toString());
        System.out.println("---------------------------");
        System.out.println("Total a pagar : " + station1.getGasTotal(20));
    }
    
}
