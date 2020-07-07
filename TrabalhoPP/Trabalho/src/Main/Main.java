package Main;

import OrderManagement.*;
import OrderPacking.*;
import Person.*;
import Exceptions.*;
import order.base.ICustomer;
import order.management.ShipmentStatus;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.packing.*;
import packing_gui.PackingGUI;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

/**
 *
 * @author samue
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PositionExceptionImpl, ContainerExceptionImpl, IOException, ParseException, OrderExceptionImpl, org.json.simple.parser.ParseException {
        //------------------------Package Base-----------------------//
        //-----------------Classe Address-----------------//
        System.out.println("Address INFO");
        Address address1 = new Address();
        address1.setCountry("Portugal");
        address1.setNumber(555);
        address1.setStreet("Rua de Real");
        address1.setCity("Felgueira");
        address1.setState("Porto");
        System.out.println("Address1 country: " + address1.getCountry() + ", Number: " + address1.getNumber() + ", Street: " + address1.getState() + ", City: " + address1.getCity()
                + ", State: " + address1.getState());
        System.out.println("");
        //-----------------Classe Address-----------------//
        //-----------------Classe Customer----------------//
        System.out.println("Customer INFO");
        Customer customer1 = new Customer(222);
        customer1.setName("Antonio");
        customer1.setAddress(address1);
        customer1.setBillingAddress(address1);
        System.out.println("Customer1 Info, Name: " + customer1.getName() + ", CustomerId: " + customer1.getCustomerId());
        System.out.println("Customer1 Info, Address: " + customer1.getAddress().toString());
        System.out.println("Customer1 Info, BillingAddress: " + customer1.getBillingAddress().toString());
        System.out.println("");
        //-----------------Classe Customer----------------//
        //-----------------Classe Destination-------------//
        System.out.println("Destination INFO");
        Customer destination1 = new Customer(1);
        System.out.println("Destination INFO, Name: " + destination1.getName());
        System.out.println("Destination INFO, Address" + destination1.getAddress().toString());
        System.out.println("");
        //-----------------Classe Destination-------------//
        //-----------------------Package Base-----------------------//

        //-----------------------Package Packing--------------------//
        //-----------------Classe Item-----------------//
        System.out.println("Item INFO");
        Item item1 = new Item("1", "Item nr 1", 4, 4, 4, 4);
        Item item2 = new Item("ItemRef2", "Item nr 2", 4, 4, 4, 4);
        System.out.println("Item 1 reference: " + item1.getReference() + ", Description: " + item1.getDescription() + ", Depth: " + item1.getDepth()
                + ", Heigth: " + item1.getHeight() + ", Length " + item1.getLenght() + ", Volume: " + item1.getVolume());
        System.out.println("");
        //-----------------Classe Item-----------------//
        //-----------------Classe Position-----------------//
        System.out.println("Position INFO");
        Position position1 = new Position(3, 0, 0);
        //position1.setX(3);
        //position1.setY(0);
        //position1.setZ(0);

        Position position2 = new Position(4, 4, 0);
        //position1.setX(4);
        //position1.setY(4);
        //position1.setZ(4);

        Position position3 = new Position(8, 0, 0);
        //position1.setX(10);
        //position1.setY(10);
        //position1.setZ(10);

        System.out.println("Position INFO, X: " + position1.getX() + ", Y: " + position1.getY() + ", Z: " + position1.getZ());
        System.out.println("Position INFO, X: " + position2.getX() + ", Y: " + position2.getY() + ", Z: " + position2.getZ());
        System.out.println("Position INFO, X: " + position3.getX() + ", Y: " + position3.getY() + ", Z: " + position3.getZ());
        System.out.println("");
        //-----------------Classe Position-----------------//
        //-----------------Classe PackedItem---------------//
        System.out.println("PackedItem INFO");
        ItemPacked packedItem = new ItemPacked(Color.fuchsia, item1, position1);
        System.out.println("PackedItem INFO, Color: " + packedItem.getColor());
        System.out.println("PackedItem INFO, Item: " + packedItem.getItem());
        System.out.println("PackedItem INFO, Position: " + packedItem.getPosition().toString());
        System.out.println("");
        //-----------------Classe PackedItem---------------//
        //-----------------Classe Container----------------//
        System.out.println("Container INFO");
        Container container1 = new Container("ContainerREF1", Color.lime, Color.navy, 50, 50, 50, 50);
        container1.addItem(item1, position1, Color.black);
        container1.addItem(item2, position2, Color.black);
        //Container 2 criado para adicionar a Shipping Order
        Container container2 = new Container("ContainerREF2", Color.gray, Color.fuchsia, 50, 50, 50, 50);
        container2.addItem(item1, position1, Color.black);
        container2.addItem(item2, position2, Color.black);
        container2.close();

        container1.removeItem(item1);
        Item itemPesquisado = (Item) container1.getItem("ItemRef2");
        System.out.println("Item Encontrado: " + itemPesquisado.getReference());
        IItemPacked[] itemsDentro = container1.getPackedItems();
        System.out.println("Tamanho do Array Novo: " + itemsDentro.length);
        System.out.println("getOccupiedVolume: " + container1.getOccupiedVolume());
        System.out.println("Container Reference: " + container1.getReference());
        System.out.println("Container Number of Items: " + container1.getNumberOfItems());
        System.out.println("Container Remaining Volume: " + container1.getRemainingVolume());
        //container1.validate();
        container1.close();
        System.out.println("ISClosed: " + container1.isClosed());
        System.out.println("");
        //-----------------Classe Container----------------//
        //-----------------------Package Packing--------------------//
        //-----------------------Package ShippingOrder--------------//
        //-----------------Classe ShippingOrder----------------//
        System.out.println("ShippingOrder INFO");
        Shipping shippingOrder1 = new Shipping(001, customer1);
        //shippingOrder1.setShipmentStatus(ShipmentStatus.IN_TREATMENT);
        shippingOrder1.addContainer(container1);
        shippingOrder1.addContainer(container2);
        shippingOrder1.removeContainer(container1);
        shippingOrder1.getContainers();
        boolean existCont = shippingOrder1.existsContainer(container2);
        IContainer findCont = shippingOrder1.findContainer("ContainerREF2");
        System.out.println("Find Container REF: ItemRef2 na posicao: " + findCont);
        System.out.println("Exists container 2: " + existCont);
        //System.out.println("Customer: " + shippingOrder1.getCustomer().getName());
        //OrderStatus status = shippingOrder1.getStatus();
        //System.out.println("Order Status: " + status);
        //System.out.println("ShippingOrder ID: " + shippingOrder1.getId());
        IContainer[] containers;
        containers = shippingOrder1.getContainers();
        System.out.println("Conteiners length: " + containers.length);
        //shippingOrder1.validate();
        System.out.println(shippingOrder1.summary());

        //-----------------Classe ShippingOrder----------------//
        //-----------------Classe Exporter---------------------//
        Exporter exporter = new Exporter();
        exporter.export();

        //-----------------Classe Exporter---------------------//
        //-----------------------Package ShippingOrder--------------//
        PackingGUI.render("example.json");
    }

}
