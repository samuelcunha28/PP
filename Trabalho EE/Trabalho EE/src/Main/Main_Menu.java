/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import gui.GUI;
import hr.LicenseType;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Scanner;
import transport.Color;
import transport.DriverStatus;
import transport.ItemStatus;
import transport.TransportationTypes;
import transport.VehicleStatus;

/**
 *
 * @author Samuel
 */
public class Main_Menu  {
  
    //Instance Variables
    boolean exit;

    public static void main(String[] args) throws HRException, ManagementException, IOException, DeliveryException, PositionException, Exception {
        Main_Menu menu = new Main_Menu();
        menu.runMenu();
         Address address1 = new Address("Porto", "Porto", 1, "Porto", "Portugal");
        Destination destination1 = new Destination("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Destination destination2 = new Destination("2", address1, "sam", LocalDate.of(2000, Month.NOVEMBER, 26));
        Customer customer1 = new Customer("1234", "123", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Customer customer2 = new Customer("2", "2", address1, "sam", LocalDate.of(2000, Month.NOVEMBER, 26));
        Box box1 = new Box(1, 1, 1, 1, Color.aqua);
        Box box2 = new Box(1, 1, 1, 1, Color.fuchsia);
        Position position1 = new Position(0, 0, 0);
        Position position2 = new Position(1, 0, 0);
        Driver driver1 = new Driver("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12), LocalDate.of(2019, Month.NOVEMBER, 12), DriverStatus.FREE);
        Item item1 = new Item(1, 1, 1, 1, "1", "1", new TransportationTypes[]{TransportationTypes.DANGEROUS}, customer1, destination1, 5, ItemStatus.ASSIGNED, Color.aqua);
        Item item2 = new Item(1, 1, 1, 1, "2", "2", new TransportationTypes[]{TransportationTypes.DANGEROUS}, customer1, destination1, 5, ItemStatus.ASSIGNED, Color.blue);
        Vehicle vehicle1 = new Vehicle("AA-00-AA", 6000, VehicleStatus.FREE, box1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Vehicle vehicle2 = new Vehicle("CC-00-CC", 2000.00, VehicleStatus.IN_TRANSIT, box1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Truck truck1 = new Truck("BB-00-BB", 12000, VehicleStatus.IN_TRANSIT, item1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Delivery delivery1 = new Delivery("1", null, null, destination2, ItemStatus.ASSIGNED); 
    

    }

    public void runMenu() throws PositionException {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|        Welcome to Mr.V's          |");
        System.out.println("|        Awesome Bank App           |");
        System.out.println("+-----------------------------------+");
    }

    private void printMenu() {
        displayHeader("Please make a selection");
        System.out.println("1) Create a new Account");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a withdrawal");
        System.out.println("4) List account balance");
        System.out.println("0) Exit");
    }

    private int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > 4);
        return choice;
    }

    private void performAction(int choice) throws PositionException {
        Address address1 = new Address("Porto", "Porto", 1, "Porto", "Portugal");
        Destination destination1 = new Destination("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Destination destination2 = new Destination("2", address1, "sam", LocalDate.of(2000, Month.NOVEMBER, 26));
        Customer customer1 = new Customer("1234", "123", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12));
        Customer customer2 = new Customer("2", "2", address1, "sam", LocalDate.of(2000, Month.NOVEMBER, 26));
        Box box1 = new Box(1, 1, 1, 1, Color.aqua);
        Box box2 = new Box(1, 1, 1, 1, Color.fuchsia);
        Position position1 = new Position(0, 0, 0);
        Position position2 = new Position(1, 0, 0);
        Driver driver1 = new Driver("1", address1, "samuel", LocalDate.of(1998, Month.NOVEMBER, 12), LocalDate.of(2019, Month.NOVEMBER, 12), DriverStatus.FREE);
        Item item1 = new Item(1, 1, 1, 1, "1", "1", new TransportationTypes[]{TransportationTypes.DANGEROUS}, customer1, destination1, 5, ItemStatus.ASSIGNED, Color.aqua);
        Item item2 = new Item(1, 1, 1, 1, "2", "2", new TransportationTypes[]{TransportationTypes.DANGEROUS}, customer1, destination1, 5, ItemStatus.ASSIGNED, Color.blue);
        Vehicle vehicle1 = new Vehicle("AA-00-AA", 6000, VehicleStatus.FREE, box1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Vehicle vehicle2 = new Vehicle("CC-00-CC", 2000.00, VehicleStatus.IN_TRANSIT, box1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Truck truck1 = new Truck("BB-00-BB", 12000, VehicleStatus.IN_TRANSIT, item1, new TransportationTypes[]{TransportationTypes.FRAGILE, TransportationTypes.DANGEROUS}, new LicenseType[]{LicenseType.A, LicenseType.B});
        Delivery delivery1 = new Delivery("1", null, null, destination2, ItemStatus.ASSIGNED); 
        
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
            case 1:  {
                
                System.out.println(item1);
            }
            break;

            case 2:
                //makeADeposit();
                break;
            case 3:
                //makeAWithdrawal();
                break;
            case 4:
                //listBalances();
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
    }

    private double getDeposit(String accountType) {
        Scanner keyboard = new Scanner(System.in);
        double initialDeposit = 0;
        Boolean valid = false;
        while (!valid) {
            System.out.print("Please enter an initial deposit: ");
            try {
                initialDeposit = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Deposit must be a number.");
            }
            if (accountType.equalsIgnoreCase("checking")) {
                if (initialDeposit < 100) {
                    System.out.println("Checking accounts require a minimum of $100 dollars to open.");
                } else {
                    valid = true;
                }
            } else if (accountType.equalsIgnoreCase("savings")) {
                if (initialDeposit < 50) {
                    System.out.println("Savings accounts require a minimum of $50 dollars to open.");
                } else {
                    valid = true;
                }
            }
        }
        return initialDeposit;
    }
     

    private double getDollarAmount(String question) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(question);
        double amount = 0;
        try {
            amount = Double.parseDouble(keyboard.nextLine());
        } catch (NumberFormatException e) {
            amount = 0;
        }
        return amount;
    }
    
    private void displayHeader(String message){
        System.out.println();
        int width = message.length() + 6;
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for(int i = 0; i < width; ++i){
            sb.append("-");
        }
        sb.append("+");
        System.out.println(sb.toString());
        System.out.println("|   " + message + "   |");
        System.out.println(sb.toString());
    }  
}