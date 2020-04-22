package vehicle;

import enums.Condition;
import enums.Origin;
import enums.TrailerType;
import enums.TruckType;
import vehicle.Vehicle;

public class VehicleDemo {

    public static void main(String[] args) {

        Car vehicle1 = new Car(1, 123, "AUDI", "SR", "30-03-2020", Origin.NATIONAL, 0, Condition.USED, 230000, 5, 5);
        // Imprimir diretamente o veiculo 1
        // System.out.println(vehicle1);

        Bike vehicle2 = new Bike(2, 1234, "YAMAHA", "MT", "20-07-2019", Origin.IMPORTED, 12000, Condition.USED, 15000, 125, 5.0);
        // Imprimir diretamente o veiculo 3
        // System.out.println(vehicle2);

        Truck vehicle3 = new Truck(3, 12345, "VOLVO", "V", "01-03-2007", Origin.IMPORTED, 220000, Condition.NEW, 56000, 8, 10000, TruckType.TRUCK, TrailerType.CLOSED);
        // Imprimir diretamente o veiculo 3
        // System.out.println(vehicle3);

        Truck vehicle4 = new Truck(4, 123456, "VOLVO", "V", "01-03-2007", Origin.IMPORTED, 220000, Condition.NEW, 56000, 8, 10000, TruckType.TRUCK, null);
        // Imprimir diretamente o veiculo 4
        // System.out.println(vehicle4);

        Truck vehicle5 = new Truck(5, 1234567, "VOLVO", "V", "01-03-2007", Origin.IMPORTED, 220000, Condition.USED, 56000, 8, 10000, TruckType.TRUCK, TrailerType.FRIDGE);
        // Imprimir diretamente o veiculo 5
        // System.out.println(vehicle5);

        // adicionar veiculos ao array
        VehicleManagement list = new VehicleManagement();
        list.addVehicle2(vehicle1);
        list.addVehicle2(vehicle2);
        list.addVehicle2(vehicle3);

        // remover objetos do array
        list.removeObject(0); // vai remover vehicle1 porque esta na posicao 0 do array

        // Listar os veiculos todas atraves de VehicleManagement através do método toString
        // System.out.println(list.toString());

        // Imprimir todas as veiculos através de metodo especifico em VehicleManagement
        System.out.println(list.imprimir());

        // Imprimir somente carros
        // System.out.println(list.imprimirCar());

        // Imprimir somente motas
        // System.out.println(list.imprimirBike());

        // Imprimir somente camioes
        // System.out.println(list.imprimirTruck());
    }
}
