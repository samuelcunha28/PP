public class Bicycle {

    // the bicycle class has three fields
    private int cadence;
    private int gear;
    private int speed;

    // the bicycle class default constructor
    public Bicycle() {
    }

    // the bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // the bicycle class has four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }
    // getter for Gear
    public int getGear() {
        return gear;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }
}