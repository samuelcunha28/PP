package vehicle;

import enums.Condition;
import enums.Origin;
import enums.TrailerType;
import enums.TruckType;
import trailer.Trailer;
import vehicle.Vehicle;

public class Truck extends Vehicle {
    // variaveis de instancia de truck
    private int length;
    private int load;
    private TruckType truckType;
    private TrailerType trailerType = null;

    // construtor default de truck
    public Truck() {
    }

    // construtor de truck
    public Truck(int id, int vin, String brand, String model, String manufacturingDate, Origin origin, int kms, Condition condition, int price, int length, int load, TruckType truckType, TrailerType trailerType) {
        super(id, vin, brand, model, manufacturingDate, origin, kms, condition, price);
        this.length = length;
        this.load = load;
        this.truckType = truckType;
        this.trailerType = trailerType;
    }

    // TODOS GETTERS E SETTERS

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public TruckType getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckType truckType) {
        this.truckType = truckType;
    }

    public TrailerType getTrailerType() {
        return trailerType;
    }

    public void setTrailerType(TrailerType trailerType) {
        this.trailerType = trailerType;
    }

    public int getPrice() {
        if (this.trailerType != null && this.getCondition() == Condition.NEW) {
            return (int) (super.getPrice() * 0.95);
        } else if (this.trailerType == null && this.getCondition() == Condition.NEW) {
            return super.getPrice();
        } else {
            return (int) (super.getPrice() * 0.85);
        }

    }

    // metodo toString para imprimir
    public String toString() {
        System.out.println("This is a Truck ");
        System.out.print(super.toString());
        String text = "Comprimento : " + length + "\n"
                + "Carga útil : " + load + "\n"
                + "Tipologia : " + truckType + "\n"
                + "Atrelado : " + trailerType + "\n"
                + "Desconto (se aplicavel) : " + (super.getPrice() - getPrice()) + "\n";
        return text;
    }

    public String printTruck() {
        return super.toString();
    }
}
