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

    /**
     * ESTE METODO FAZ O SEGUINTE. TENHO UMA CAIXA NO PORTA MALAS DO CARRO.
     * TUDO O QUE TENHO QUE FAZER E TROCAR ESSA CAIXA POR OUTRA CAIXA.
     * CASO NAO HAJA NENHUMA CAIXA ADICIONAR A QUE ERA PARA TROCAR.
     * IMPORTANTE ADICIONAR O METODO SET CARGO NO VEHICLE PORQUE ISSO VAI 
     * AJUDAR A FAZER O METODO.
     * 
     * CASO SEJA FREE = SET DA BOX
     * SE NAO RETORNA FALSO OU EXCECAO
     */

    /**
     * The Vehicle Status.
     */
    private VehicleStatus status;
    
    /**
     * Constructor of Truck
     * @param licensePlate The vehicle license plate. 
     * @param maxWeight The vehicle max weight.
     * @param status The vehicle status
     * @param cargo The box that defines the cargo space.
     * @param types The vehicle transportation types.
     * @param licenses The vehicle licenses types.
     */
    public Truck(String licensePlate, double maxWeight, VehicleStatus status, IBox cargo, TransportationTypes[] types, LicenseType[] licenses) {
        super(licensePlate, maxWeight, status, cargo, types, licenses);
    }

    /**
     * Method that swaps the cargo box if the status is FREE.
     * @param ibox The box to swap the other one.
     * @return true if the cargo box was swapped, false otherwise.
     */
    @Override
    public boolean swapCargoBox(IBox ibox) {
        if (super.getStatus() == status.FREE) {
            setCargo(ibox);
            return true;
        } else {
            return false;
        }
    }
}
