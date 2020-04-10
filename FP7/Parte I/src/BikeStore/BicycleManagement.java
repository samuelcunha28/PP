package BikeStore;

public class BicycleManagement {
    private final int MAXBIKES = 20;
    private Bicycle[] bikelist = new Bicycle[MAXBIKES];
    private int count = 0;

    /**
     *
     * @param bike
     */
    public void addbike(Bicycle bike) {
        if (count < MAXBIKES) {
            bikelist[count] = bike;
            count += 1;
        } else {
            System.out.println("MAX Bikes");
        }
    }

    @Override
    public String toString() {
        String text = "";
        for (int i = 0; i < count; i++) {
            text += "Bike " + (i + 1) + " : " + "\n" + bikelist[i].toString() + "\n";
        }
        return text;
    }
}
