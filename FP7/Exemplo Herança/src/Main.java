public class Main {

    public static void main(String[] args) {
        // teste com bicycle
        Bicycle bicycle1 = new Bicycle();
        bicycle1.setGear(4);

        System.out.println(bicycle1.getGear());

        // teste com MountainBike
        MountainBike bicycle2 = new MountainBike();
        bicycle2.setSuspension(true);

        System.out.println(bicycle2.getSuspension());
    }
}
