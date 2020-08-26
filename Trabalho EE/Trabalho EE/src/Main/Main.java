package Main;

import HumanResources.Address;
import HumanResources.Customer;
import HumanResources.Driver;
import exceptions.HRException;
import hr.LicenseType;
import java.time.LocalDate;
import java.time.Month;
import transport.DriverStatus;

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
        Customer customer1 = new Customer("1234", "123", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Driver driver1 = new Driver("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12), LocalDate.of(2019, Month.NOVEMBER, 12), DriverStatus.FREE);
        
        // System.out.println(customer1.getVat());
        // System.out.println(customer1.getName());
        driver1.addLicense(LicenseType.A1);
        driver1.addLicense(LicenseType.A2);
        System.out.println(driver1);
        System.out.println("");
        driver1.removeLicense(LicenseType.A1);
        System.out.println(driver1);
        System.out.println("");
        System.out.println(driver1.haveLicense(LicenseType.A2));
    }
}
