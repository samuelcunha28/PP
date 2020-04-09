public class MountainBike extends Bicycle {

    // the mountain bike subclass adds one field
    private boolean suspension;

    // the mountain bike default constructor
    public MountainBike() {
    }

    // the mountain bike subclass has one constructor
    public MountainBike(boolean suspension, int startCadence, int startSpeed, int startGear) {
        super(startCadence, startSpeed, startGear);
        this.suspension = suspension;
    }

    // the mountain bike subclass adds one method
    public void setSuspension(boolean newValue) {
        suspension = newValue;
    }

    public boolean getSuspension() {
        return suspension;
    }
}