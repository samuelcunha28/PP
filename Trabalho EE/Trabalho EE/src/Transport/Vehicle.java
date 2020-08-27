package Transport;
import hr.LicenseType;
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
     * The vehicle status
     */
    private VehicleStatus status;
    
    /**
     * The box that defines the cargo space.
     */
    private IBox cargo;
    
    @Override
    public LicenseType[] getAllowedLicenses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLicensePlate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IBox getCargoBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getMaxWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VehicleStatus getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStatus(VehicleStatus vs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TransportationTypes[] getTransportationTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
