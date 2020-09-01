package Main;

import HumanResources.Address;
import HumanResources.Customer;
import HumanResources.Destination;
import HumanResources.Driver;
import Transport.Box;
import Transport.Delivery;
import Transport.Exporter;
import Transport.Item;
import Transport.Management;
import Transport.Position;
import Transport.Truck;
import Transport.Vehicle;
import exceptions.DeliveryException;
import exceptions.HRException;
import exceptions.ManagementException;
import exceptions.PositionException;
import hr.LicenseType;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import transport.DriverStatus;
import transport.ItemStatus;
import transport.TransportationTypes;
import transport.VehicleStatus;
import transport.IExporter;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws exceptions.HRException
     * @throws exceptions.ManagementException
     * @throws java.io.IOException
     * @throws exceptions.DeliveryException
     * @throws exceptions.PositionException
     */
    public static void main(String[] args) throws HRException, ManagementException, IOException, DeliveryException, PositionException {
        Address address1 = new Address("Porto", "Porto", 1, "Porto", "Portugal");
        Destination destination1 = new Destination("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Destination destination2 = new Destination("2", address1, "sam", LocalDate.of(2000, Month.NOVEMBER, 26));
        Customer customer1 = new Customer("1234", "123", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Customer customer2 = new Customer("2", "2", address1, "sam", LocalDate.of(2000, Month.NOVEMBER, 26));
        Box box1 = new Box(1, 1, 1, 1);
        Box box2 = new Box(2, 2, 2, 2);
        Position position1 = new Position(1, 1, 1);
        Position position2 = new Position(2, 2, 2);
        Driver driver1 = new Driver("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12), LocalDate.of(2019, Month.NOVEMBER, 12), DriverStatus.FREE);
        Item item1 = new Item(1, 1, 1, 1, "1", "1", new TransportationTypes[]{TransportationTypes.DANGEROUS}, customer1, destination1, 5, ItemStatus.NON_DELIVERED);
        Item item2 = new Item(2, 2, 2, 2, "2", "2", new TransportationTypes[]{TransportationTypes.DANGEROUS}, customer1, destination2, 5, ItemStatus.NON_DELIVERED);
        Vehicle vehicle1 = new Vehicle("AA-00-AA", 6000, VehicleStatus.FREE, box1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Vehicle vehicle2 = new Vehicle("CC-00-CC", 2000.00, VehicleStatus.IN_TRANSIT, box1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Truck truck1 = new Truck("BB-00-BB", 12000, VehicleStatus.IN_TRANSIT, item1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Delivery delivery1 = new Delivery("1", null, null, destination2, ItemStatus.ASSIGNED);
        
        
        // System.out.println(customer1.getVat());
        // System.out.println(customer1.getName());
        driver1.addLicense(LicenseType.A1);
        driver1.addLicense(LicenseType.A2);
        System.out.println(driver1);
        System.out.println("");
        driver1.removeLicense(LicenseType.A1);
        System.out.println(driver1);
        System.out.println("");
        // System.out.println(driver1.haveLicense(LicenseType.A2));
        System.out.println("");

        // System.out.println(item1);
        System.out.println("TIPOS");
        System.out.println(Arrays.toString(item1.getTransportationTypes()));

        System.out.println("VEICULO 1");
        System.out.println(vehicle1);
        
        // truck1.swapCargoBox(box1);
        // System.out.println(truck1.swapCargoBox(box2));
        
        System.out.println("");
        System.out.println("TRUCK 1");
        System.out.println(truck1);
        
        
        Management management = new Management();
        management.addItem(item1);
        management.addItem(item2);
        // management.removeItem(item1);
        System.out.println("");
        System.out.println("");
        // System.out.println(Arrays.toString(management.getItems()));
        System.out.println("");
        // System.out.println(Arrays.toString(management.getItems(customer2)));
        System.out.println("");
        // System.out.println(Arrays.toString(management.getItems(destination1)));
        System.out.println("");
        //System.out.println(Arrays.toString(management.getItems(TransportationTypes.DANGEROUS)));
        System.out.println("");
        //System.out.println(Arrays.toString(management.getItems(ItemStatus.ASSIGNED)));
        System.out.println("");
        management.addVehicle(vehicle1);
        management.addVehicle(vehicle2);
        // management.removeVehicle(vehicle1);
        System.out.println("");
        management.addDriver(driver1);
        // management.removeDriver(driver1);
        System.out.println("");
        // System.out.println(Arrays.toString(management.getFleet()));
        System.out.println("");
        // System.out.println(Arrays.toString(management.getFleet(VehicleStatus.FREE)));
        System.out.println("");
        // System.out.println(Arrays.toString(management.getFleet(TransportationTypes.FRAGILE)));
        System.out.println("");
        // System.out.println(Arrays.toString(management.getFleet(VehicleStatus.FREE, TransportationTypes.FRAGILE)));
        System.out.println("");
        delivery1.setVehicle(vehicle1, driver1);
        // System.out.println(delivery1);
        System.out.println("");
        // System.out.println(delivery1.getVehicle());
        System.out.println("");
        delivery1.load(item1, position1);
        delivery1.load(item2, position2);
        // delivery1.unload(item2, ItemStatus.DELIVERED);
        // delivery1.unload(destination1, ItemStatus.DELIVERED);
        System.out.println("");
        // System.out.println(Arrays.toString(delivery1.getRemainingItems()));
        System.out.println("");
       //System.out.println(Arrays.toString(delivery1.getRemainingDestinations()));
        System.out.println("");
        //delivery1.start();
        //delivery1.end();
        
        //System.out.println("Peso items: " + delivery1.getCurrentWeight());
    }
}
