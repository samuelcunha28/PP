/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import HumanResources.Address;
import HumanResources.Customer;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author samue
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
