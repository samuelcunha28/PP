public class Main {

    public static void main(String[] args) {
        /*
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
         */

        LargeGasStation station2 = new LargeGasStation(1.28, "Station 2", "Repsol", 234567, 0.65);
        //System.out.println(station2);
        station2.setCoffeePrice(0.70);
        // System.out.println("New coffee price: " + station2.getCoffeePrice() + "€");
        System.out.println("Informação nova");
        System.out.println(station2.toString());
        System.out.println("Total a pagar de cafés: " + station2.getCoffeeTotal(4) + "€");
    }
}
