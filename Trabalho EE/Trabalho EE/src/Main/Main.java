package Main;

import HumanResources.Address;
import HumanResources.Customer;
import HumanResources.Destination;
import HumanResources.Driver;
import Transport.Box;
import Transport.Item;
import Transport.Management;
import Transport.Truck;
import Transport.Vehicle;
import exceptions.HRException;
import exceptions.ManagementException;
import hr.LicenseType;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import transport.DriverStatus;
import transport.ItemStatus;
import transport.TransportationTypes;
import transport.VehicleStatus;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws exceptions.HRException
     * @throws exceptions.ManagementException
     */
    public static void main(String[] args) throws HRException, ManagementException {
        Address address1 = new Address("Porto", "Porto", 1, "Porto", "Portugal");
        Destination destination1 = new Destination("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Destination destination2 = new Destination("2", address1, "sam", LocalDate.of(2000, Month.NOVEMBER, 26));
        Customer customer1 = new Customer("1234", "123", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Customer customer2 = new Customer("2", "2", address1, "sam", LocalDate.of(2000, Month.NOVEMBER, 26));
        Box box1 = new Box(1, 1, 1, 1);
        Box box2 = new Box(2, 2, 2, 2);
        Driver driver1 = new Driver("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12), LocalDate.of(2019, Month.NOVEMBER, 12), DriverStatus.FREE);
        Item item1 = new Item(1, 1, 1, 1, "1", "1", new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, customer1, destination1, 10, ItemStatus.ASSIGNED);
        Vehicle vehicle1 = new Vehicle("AA-00-AA", 100000.00, VehicleStatus.FREE, box1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Truck truck1 = new Truck("BB-00-BB", 12000, VehicleStatus.FREE, item1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        
        
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
        // management.removeItem(item1);
        System.out.println("");
        System.out.println("");
        // System.out.println(Arrays.toString(management.getItems()));
        System.out.println("");
        // System.out.println(Arrays.toString(management.getItems(customer2)));
        System.out.println("");
        System.out.println(Arrays.toString(management.getItems(destination1)));
    }
}
