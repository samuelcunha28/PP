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

public class Main {

    public static void main(String[] args) throws PositionException, ContainerException, IOException, ParseException, OrderException, org.json.simple.parser.ParseException {
        //----------------Package Person------------------//
        //-----------------Classe Address-----------------//
        System.out.println("INFORMACOES DE MORADA");
        Address address1 = new Address();
        address1.setCountry("Portugal");
        address1.setNumber(123);
        address1.setStreet("Rua do Curral");
        address1.setCity("Felgueiras");
        address1.setState("Porto");
        System.out.println("Address1 Pais: " + address1.getCountry() + ", Numero: " + address1.getNumber() + ", Rua: " + address1.getState() + ", Cidade: " + address1.getCity()
                + ", Provincia: " + address1.getState());
        System.out.println("");

        //-----------------Classe Customer----------------//
        System.out.println("INFORMACOES DO CLIENTE");
        Customer customer1 = new Customer(1);
        customer1.setName("Samuel");
        customer1.setAddress(address1);
        customer1.setBillingAddress(address1);
        System.out.println("Customer1 Nome: " + customer1.getName() + ", ID " + customer1.getCustomerId());
        System.out.println("Customer1 Morada: " + customer1.getAddress().toString());
        System.out.println("Customer1 Morada de faturacao: " + customer1.getBillingAddress().toString());
        System.out.println("");

        //-----------------Classe Destination-------------//
        System.out.println("INFORMACOES DE DESTINO");
        Destination destination1 = new Destination(address1, "ESTG");
        System.out.println("Destination1 Nome: " + destination1.getName());
        System.out.println("Destination1 Morada" + destination1.getAddress().toString());
        System.out.println("");

        //-----------------------Package OrderPacking--------------------//
        //-----------------Classe Item-----------------//
        System.out.println("INFORMACOES DO(S) ITEM(S)");
        Item item1 = new Item("REF1", "Item 1", 4, 4, 4);
        Item item2 = new Item("REF2", "Item 2", 4, 4, 4);
        Item item3 = new Item("REF3", "Item 3", 4, 4, 4);
        System.out.println("Item 1 referencia: " + item1.getReference() + ", Descricao: " + item1.getDescription() + ", Profundidade: " + item1.getDepth()
                + ", Altura: " + item1.getHeight() + ", Comprimento " + item1.getLenght() + ", Volume: " + item1.getVolume());
        System.out.println("");

        //-----------------Classe Position-----------------//
        System.out.println("INFORMACOES DE POSICAO");
        Position position1 = new Position(3, 0, 0);
        //position1.setX(3);
        //position1.setY(0);
        //position1.setZ(0);

        Position position2 = new Position(4, 4, 0);
        //position1.setX(4);
        //position1.setY(4);
        //position1.setZ(0);

        Position position3 = new Position(8, 0, 0);
        //position1.setX(8);
        //position1.setY(0);
        //position1.setZ(0);

        System.out.println("Posicao1 , X: " + position1.getX() + ", Y: " + position1.getY() + ", Z: " + position1.getZ());
        System.out.println("Posicao2 , X: " + position2.getX() + ", Y: " + position2.getY() + ", Z: " + position2.getZ());
        System.out.println("Posicao3 , X: " + position3.getX() + ", Y: " + position3.getY() + ", Z: " + position3.getZ());
        System.out.println("");

        //-----------------Classe ItemPacked---------------//
        System.out.println("INFORMACOES ITEM PACKED");
        ItemPacked packedItem = new ItemPacked(Color.fuchsia, item1, position1);
        System.out.println("PackedItem, Cor: " + packedItem.getColor());
        System.out.println("PackedItem, Item: " + packedItem.getItem());
        System.out.println("PackedItem, Posicao: " + packedItem.getPosition().toString());
        System.out.println("");
       
        
        //-----------------Classe Container----------------//
        System.out.println("INFORMACOES DO CONTAINER");
        Container container1 = new Container(500, "REF1", 50, Color.black, 50, Color.white, 50);
        container1.addItem(item1, position1, Color.green);
        container1.addItem(item2, position2, Color.black);
        container1.addItem(item3, position3, Color.black);
        container1.addItem(item3, position3, Color.black);
        //Container 2 criado para adicionar a Shipping Order
        Container container2 = new Container(500, "REF2", 50, Color.lime, 50, Color.maroon, 50);
        container2.addItem(item1, position1, Color.purple);
        container2.addItem(item2, position2, Color.black);
        container2.addItem(item3, position3, Color.black);
        container2.close();

        container1.removeItem(item3);
        Item itemPesquisado = (Item) container1.getItem("REF2");
        System.out.println("Item Encontrado: " + itemPesquisado.getReference());
        IItemPacked[] itemsDentro = container1.getPackedItems();
        System.out.println("Tamanho do Array Novo: " + itemsDentro.length);
        System.out.println("Volume ocupado: " + container1.getOccupiedVolume());
        System.out.println("Referencia do container: " + container1.getReference());
        System.out.println("Numero de itens no container: " + container1.getNumberOfItems());
        System.out.println("Volume restante do container: " + container1.getRemainingVolume());
        container1.validate();
        container1.close();
        System.out.println("O container esta fechado? " + container1.isClosed());
        System.out.println("");
        
        
        //-----------------------Package OrderManagement--------------//
        //-----------------Classe Shipping----------------//
        System.out.println("INFORMACOES DE ENVIO");
        Shipping shippingOrder1 = new Shipping(001, customer1);
        shippingOrder1.setShipmentStatus(ShipmentStatus.IN_TREATMENT);
        shippingOrder1.addContainer(container1);
        shippingOrder1.addContainer(container2);
        shippingOrder1.removeContainer(container1);
        shippingOrder1.getContainers();
        boolean existCont = shippingOrder1.existsContainer(container2);
        System.out.println("Container 2 existe? " + existCont);
        shippingOrder1.setDestination(destination1);
        System.out.println("Cidade de destino: " + shippingOrder1.getDestination().getAddress().getCity());
        System.out.println("Cliente: " + shippingOrder1.getCustomer().getName());
        ShipmentStatus status = shippingOrder1.getShipmentStatus();
        System.out.println("Estado do pedido: " + status);
        System.out.println("ID de envio: " + shippingOrder1.getId());
        IContainer[] containers;
        containers = shippingOrder1.getContainers();
        System.out.println("Comprimento do container: " + containers.length);
        shippingOrder1.validate();
        System.out.println("Sumario do pedido: ");
        System.out.println(shippingOrder1.summary());

        //-----------------Classe ShippingOrder----------------//
        //-----------------Classe Exporter---------------------//
        Exporter exporter = new Exporter();
        // exporter.export();

        //-----------------Classe Exporter---------------------//
        //-----------------------Package ShippingOrder--------------//
        PackingGUI.render("example.json");
    }
}