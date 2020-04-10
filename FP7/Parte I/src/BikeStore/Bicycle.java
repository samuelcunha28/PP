package BikeStore;

import enums.BrakeType;
import enums.MaterialType;

public class Bicycle {
    // variáveis de instancia de bicycle
    private int id;
    private int numberOfGears;
    private String mainColor;
    private double wheelSize;
    private BrakeType brakes;
    private MaterialType material;
    private double price;
    private int guarantee;

    // construtor default de bicycle
    public Bicycle() {
    }

    // construtor de bicycle

    public Bicycle(int id, int numberOfGears, String mainColor, double wheelSize, BrakeType brakes, MaterialType material, double price, int guarantee) {
        this.id = id;
        this.numberOfGears = numberOfGears;
        this.mainColor = mainColor;
        this.wheelSize = wheelSize;
        this.brakes = brakes;
        this.material = material;
        this.price = price;
        this.guarantee = guarantee;
    }

    // TODOS GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public BrakeType getBrakes() {
        return brakes;
    }

    public void setBrakes(BrakeType brakes) {
        this.brakes = brakes;
    }

    public MaterialType getMaterial() {
        return material;
    }

    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    /**
     * Metodo para modificar um material colocando um novo e substituir o antigo
     *
     * @param material old type
     * @param newmaterial new type
     */
    public void editmaterial(MaterialType material, MaterialType newmaterial) {
        this.material = newmaterial;
    }

    /**
     * Printar materiais
     */
    public void printmat() {
        System.out.println(this.material);
    }

    /**
     * Printar all Bikes
     *
     * @return Bikes
     */
    @Override
    public String toString() {
        String text = "ID : " + id + "\n"
                + "Number of gears : " + numberOfGears + "\n"
                + "Cor : " + mainColor + "\n"
                + "Garantia : " + guarantee + "\n";
        return text;
    }
}
