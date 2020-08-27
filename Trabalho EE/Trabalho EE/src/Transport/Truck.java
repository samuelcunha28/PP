package Transport;

import hr.LicenseType;
import transport.IBox;
import transport.ITruck;
import transport.TransportationTypes;
import transport.VehicleStatus;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Truck extends Vehicle implements ITruck {

    private VehicleStatus status;
    
    private IBox cargo;

    public Truck(String licensePlate, double maxWeight, VehicleStatus status, IBox cargo, TransportationTypes[] types, LicenseType[] licenses) {
        super(licensePlate, maxWeight, status, cargo, types, licenses);
    }

    @Override
    public boolean swapCargoBox(IBox ibox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
