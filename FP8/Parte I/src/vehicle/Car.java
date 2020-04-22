package vehicle;

import enums.Condition;
import enums.Origin;
import vehicle.Vehicle;

public class Car extends Vehicle {
    // variáveis de instancia de car
    private int occupantsNumber;
    private int doorsNumber = 3;

    // construtor default de car
    public Car() {
    }

    // construtor de car
    public Car(int id, int vin, String brand, String model, String manufacturingDate, Origin origin, int kms, Condition condition, int price, int occupantsNumber, int doorsNumber) {
        super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price);
        this.occupantsNumber = occupantsNumber;
        this.doorsNumber = doorsNumber;
    }

    // TODOS GETTERS E SETTERS
    public int getOccupantsNumber() {
        return occupantsNumber;
    }

    public void setOccupantsNumber(int occupantsNumber) {
        this.occupantsNumber = occupantsNumber;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    public int getPrice() {
        if (this.getCondition() == Condition.USED) {
            return (int) (super.getPrice() - super.getPrice() * 0.3);
        } else {
            return super.getPrice();
        }
    }

    public String toString() {
        System.out.println("This is a Car ");
        System.out.print(super.toString());
        String text = "Numero ocupantes : " + occupantsNumber + "\n"
                + "Numero de portas : " + doorsNumber + "\n"
                + "Desconto : " + (super.getPrice() - getPrice()) + "\n";
        return text;
    }

    public String printCar() {
        return super.toString();
    }
}
