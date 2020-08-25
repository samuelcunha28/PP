package Main;

import HumanResources.Address;
import HumanResources.Customer;
import java.time.LocalDate;
import java.time.Month;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Address address1 = new Address("Porto", "Porto", 1, "Porto", "Portugal");
        Customer customer1 = new Customer("1234", "123", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        
        System.out.println(customer1.getVat());
        System.out.println(customer1.getName());
    }
}
