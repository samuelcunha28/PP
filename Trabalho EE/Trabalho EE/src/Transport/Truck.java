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
