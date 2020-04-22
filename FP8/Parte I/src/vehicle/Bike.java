package vehicle;

import enums.Condition;
import enums.Origin;
import vehicle.Vehicle;

public class Bike extends Vehicle {
    // variáveis de instancia de bike
    private int cubicCapacity;
    private double wheelSize;

    // construtor default de car
    public Bike() {
    }

    // construtor de car
    public Bike(int id, int vin, String brand, String model, String manufacturingDate, Origin origin, int kms, Condition condition, int price, int cubicCapacity, double wheelSize) {
        super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price);
        this.cubicCapacity = cubicCapacity;
        this.wheelSize = wheelSize;
    }

    // TODOS OS GETTERS E SETTERS
    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(float wheelSize) {
        this.wheelSize = wheelSize;
    }

    // metodo toString para imprimir
    public String toString() {
        System.out.println("This is a Bike ");
        System.out.print(super.toString());
        String text = "Cilindrada : " + cubicCapacity + "\n"
                + "Diametro de rodas : " + wheelSize + "\n";
        return text;
    }

    public String printBike() {
        return super.toString();
    }
}
