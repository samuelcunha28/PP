package Main;

import HumanResources.Address;
import HumanResources.Customer;
import HumanResources.Destination;
import HumanResources.Driver;
import Transport.Item;
import exceptions.HRException;
import hr.LicenseType;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import transport.DriverStatus;
import transport.ItemStatus;
import transport.TransportationTypes;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Main {

    /**
     * @param args the command line arguments
     * @throws exceptions.HRException
     */
    public static void main(String[] args) throws HRException {
        Address address1 = new Address("Porto", "Porto", 1, "Porto", "Portugal");
        Destination destination1 = new Destination("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Customer customer1 = new Customer("1234", "123", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Driver driver1 = new Driver("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12), LocalDate.of(2019, Month.NOVEMBER, 12), DriverStatus.FREE);
        Item item1 = new Item(1, 1, 1, 1, "1", "1", new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS},customer1, destination1, 10, ItemStatus.ASSIGNED);
        
        
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
        
    }
}
