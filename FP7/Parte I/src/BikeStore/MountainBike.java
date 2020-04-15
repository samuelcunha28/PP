package BikeStore;

import BikeStore.Bicycle;
import enums.BikeTools;
import enums.BrakeType;
import enums.MaterialType;
import enums.MountainBikeSuspension;

public class MountainBike extends Bicycle {

    private final int MAXTOOLS = 5;

    // a subclass mountain bike tem as seguintes variaveis de instancia
    private int numberOfLights;
    private MountainBikeSuspension suspension;
    private BikeTools bikeTools;
    private int count_tools = 0;

    // construtor default de mountain bike
    public MountainBike() {
    }

    // construtor de mountain bike
    public MountainBike(int id, int numberOfGears, String mainColor, double wheelSize, BrakeType brakes, MaterialType material, double price, int guarantee, int numberOfLights, MountainBikeSuspension suspension, BikeTools bikeTools) {
        super(id, numberOfGears, mainColor, wheelSize, brakes, material, price, guarantee);
        this.numberOfLights = numberOfLights;
        this.suspension = suspension;
        this.bikeTools = bikeTools;
    }

    // TODOS OS GETTERS AND SETTERS
    public int getNumberOfLights() {
        return numberOfLights;
    }

    public void setNumberOfLights(int numberOfLights) {
        this.numberOfLights = numberOfLights;
    }

    public MountainBikeSuspension getSuspension() {
        return suspension;
    }

    public void setSuspension(MountainBikeSuspension suspension) {
        this.suspension = suspension;
    }

    public BikeTools getBikeTools() {
        return bikeTools;
    }

    public void setBikeTools(BikeTools bikeTools) {
        this.bikeTools = bikeTools;
    }

    /**
     * print bike
     */
    public void printBike() {
        System.out.println("-----------------//////---------");
        System.out.print("ID : ");
        System.out.println(super.getId());
        System.out.print("Number of Gears: ");
        System.out.println(super.getNumberOfGears());
        System.out.print("Cor : ");
        System.out.println(super.getMainColor());
        System.out.print("Wheel Size : ");
        System.out.println(super.getWheelSize());
        System.out.print("Brakes : ");
        System.out.println(super.getBrakes());
        System.out.print("Material : ");
        System.out.println(super.getMaterial());
        System.out.print("Price : ");
        System.out.println(super.getPrice());
        System.out.print("Guarantee : ");
        System.out.println(super.getGuarantee());
        System.out.print("Number of lights : ");
        System.out.println(numberOfLights);
        System.out.print("Suspension : ");
        System.out.println(suspension);
    }

    /**
     * Printar all Bikes atraves do metodo toString
     *
     * @return Bikes
     */
    @Override
    public String toString() {
        String text = "ID : " + getId() + "\n"
                + "Number of gears : " + getNumberOfGears() + "\n"
                + "Cor : " + getMainColor() + "\n"
                + "Garantia : " + getGuarantee() + "\n"
                + "Brakes : " + getBrakes() + "\n"
                + "Material : " + getMaterial() + "\n"
                + "Price : " + getPrice() + "\n"
                + "Guarantee : " + getGuarantee() + "\n"
                + "Number of Lights : " + getNumberOfLights() + "\n"
                + "Suspension : " + getSuspension() + "\n";
        return text;
    }

    /**
     * Método especifico para imprimir só mountain bikes
     *
     * @return Bikes
     */
    public String printMountain() {
        return "ID: " + super.getId() + " Cor: " + super.getMainColor() + " Number of lights: " + this.getNumberOfLights();
    }
}
