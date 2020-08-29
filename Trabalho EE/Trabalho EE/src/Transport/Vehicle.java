package Transport;

import hr.LicenseType;
import java.util.Arrays;
import transport.IBox;
import transport.IVehicle;
import transport.TransportationTypes;
import transport.VehicleStatus;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Vehicle implements IVehicle {

    /**
     * The vehicle license plate.
     */
    private String licensePlate;

    /**
     * The vehicle max weight.
     */
    private double maxWeight;

    /**
     * The vehicle status.
     */
    private VehicleStatus status;

    /**
     * The box that defines the cargo space.
     */
    private IBox cargo;

    /**
     * The vehicle transportation types.
     */
    private TransportationTypes[] types;

    /**
     * The vehicle licenses types.
     */
    private LicenseType[] licenses;

    /**
     * Constructor of Vehicle.
     *
     * @param licensePlate The vehicle license plate. 
     * @param maxWeight The vehicle max weight.
     * @param status The vehicle status
     * @param cargo The box that defines the cargo space.
     * @param types The vehicle transportation types.
     * @param licenses The vehicle licenses types.
     */
    public Vehicle(String licensePlate, double maxWeight, VehicleStatus status, IBox cargo, TransportationTypes[] types, LicenseType[] licenses) {
        this.licensePlate = licensePlate;
        this.maxWeight = maxWeight;
        this.status = status;
        this.cargo = cargo;
        this.types = types;
        this.licenses = licenses;
    }

    /**
     * Getter for all license types needed to drive a vehicle
     *
     * @return The vehicle licenses type.
     */
    @Override
    public LicenseType[] getAllowedLicenses() {
        return this.licenses;
    }

    /**
     * Getter for the license plate.
     *
     * @return The vehicle license plate.
     */
    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    /**
     * Setter for the license plate.
     *
     * @param licensePlate The vehicle license plate.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Getter for the box that defines the cargo space.
     *
     * @return The box that defines the cargo space.
     */
    @Override
    public IBox getCargoBox() {
        return this.cargo;
    }

    /**
     * Setter for the box that defines the cargo space.
     * 
     * @param cargo The box that defines the cargo space.
     */
    public void setCargo(IBox cargo) {
        this.cargo = cargo;
    }

    /**
     * Getter for the max weight the vehicle can transport.
     *
     * @return The vehicle max weight.
     */
    @Override
    public double getMaxWeight() {
        return this.maxWeight;
    }

    /**
     * Getter for the vehicle status.
     *
     * @return The vehicle status.
     */
    @Override
    public VehicleStatus getStatus() {
        return this.status;
    }

    /**
     * Setter for the vehicle status.
     *
     * @param status The vehicle status.
     */
    @Override
    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    /**
     * Getter for the transportation type allowed by the vehicle.
     *
     * @return The vehicle transportation types.
     */
    @Override
    public TransportationTypes[] getTransportationTypes() {
        return this.types;
    }

    /**
     * To String method representing the Driver.
     *
     * @return String with all the information about the driver.
     */
    @Override
    public String toString() {
        return "License Plate: " + licensePlate + "\nMax Weight: " + maxWeight
                + "\nVehicle status: " + status + "\nCargo: " + cargo
                + "\nTransportation Types: " + Arrays.toString(types)
                + "\nLicense Types: " + Arrays.toString(licenses);
    }
}
