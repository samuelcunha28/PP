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

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
 */
public class Main_Menu {

    boolean exit;

    public static void main(String[] args) throws HRException, ManagementException, IOException, DeliveryException, PositionException, Exception {
        Main_Menu menu = new Main_Menu();
        menu.runMenu();
    }

    public void runMenu() throws PositionException, ManagementException, DeliveryException, Exception {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice();
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("-------------------------------------");
        System.out.println("| Welcome TransportationSolutions!  |");
        System.out.println("-------------------------------------");
    }

    private void printMenu() {
        System.out.println("Please make your choice!");
        System.out.println("1) See item 1");
        System.out.println("2) See item 2");
        System.out.println("3) Different Transportation types of item 1");
        System.out.println("4) Deliver 1 from start to finish ");
        System.out.println("5) Export delivery 1");
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
            if (choice < 0 || choice > 5) {
                System.out.println("Choice outside of range. Please choose again.");
            }
        } while (choice < 0 || choice > 5);
        return choice;
    }

    private void performAction(int choice) throws PositionException, ManagementException, DeliveryException, Exception {
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

        Management management = new Management();

        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
            case 1:
                System.out.println("");
                System.out.println(item1);
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                System.out.println(item2);
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                System.out.println(Arrays.toString(item1.getTransportationTypes()));
                System.out.println("");
                break;
            case 4:
                System.out.println("");
                management.addItem(item1);
                management.addVehicle(vehicle1);
                management.addVehicle(vehicle2);
                management.addDriver(driver1);
                delivery1.setVehicle(vehicle1, driver1);
                delivery1.load(item1, position1);
                delivery1.load(item2, position2);
                management.addDelivery(delivery1);
                management.startDelivery("1");
                management.deliveredItem("1", "1");
                management.stopDelivery("1");
                Exporter export = new Exporter(delivery1, "Delivery1.json");
                export.export("Delivery1.json");
                System.out.println("Item added!\n");
                break;
            case 5:
                System.out.println("");
                GUI.render("Delivery1.json");
                System.out.println("Delivery 1 successfully render!\n");
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
    }
}
