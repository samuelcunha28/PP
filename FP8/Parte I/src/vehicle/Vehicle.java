package vehicle;

import enums.Condition;
import enums.Origin;

import java.util.Objects;

public class Vehicle {
    // variaveis de instancia de vehicle
    private int id;
    private int vin; // numero de chassis
    private String brand;
    private String model;
    private String manufacturingDate;
    private Origin origin;
    private int kms;
    private Condition condition;
    private int price;

    // construtor default de vehicle
    public Vehicle() {
    }

    // construtor de vehicle
    public Vehicle(int id, int vin, String brand, String model, String manufacturingDate, Origin origin, int kms, Condition condition, int price) {
        this.id = id;
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.origin = origin;
        this.kms = kms;
        this.condition = condition;
        this.price = price;
    }

    // TODOS GETTERS E SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // metodo toString para imprimir
    public String toString() {
        String text = "ID : " + id + "\n"
                + "Numero de chassis : " + vin + "\n"
                + "Marca : " + brand + "\n"
                + "Modelo : " + model + "\n"
                + "Data veiculo : " + manufacturingDate + "\n"
                + "Origem : " + origin + "\n"
                + "Quilometros : " + kms + "\n"
                + "Condiçao : " + condition + "\n"
                + "Preço : " + getPrice() + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        if (this.vin != vehicle.vin) {
            return false;
        }
        return true;
    }
}
