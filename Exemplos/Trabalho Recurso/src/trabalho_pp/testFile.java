package trabalho_pp;

import Container_Implementation.Container;
import Container_Implementation.Position;
import Management_Implementation.Exporter;
import Management_Implementation.Management;
import Management_Implementation.Order;
import Management_Implementation.OrderImporter;
import Management_Implementation.Shipping;
import Person_Implementation.Address;
import Person_Implementation.Customer;
import Person_Implementation.Person;
import java.io.IOException;
import order.base.IAddress;
import order.base.ICustomer;
import order.base.IPerson;
import order.exceptions.BoxException;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.management.IOrder;
import order.management.IShipping;
import order.management.ShipmentStatus;
import order.packing.Color;
import order.packing.IPosition;
import org.json.simple.parser.ParseException;
import packing_gui.PackingGUI;

/**
 *
 * Nome : José Pedro Fernandes 
 * Número: 8190239 
 * Turma: 4
 *
 * Nome: Hugo Maia Alves
 * Número: 8160521
 * Turma: LEIT2
 * 
 */
public class testFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        int i;
        double d;
        float f;
        boolean b;

        IAddress ad1 = new Address("city A1", "Country A1", 1, "state A1", "street A1");
        IAddress ad2 = new Address("city A2", "Country A2", 2, "state A2", "street A2");
        ICustomer customer1 = new Customer("John Doe", "111111", ad1, ad1);
        ICustomer customer2 = new Customer("Jane Doe", "111111", ad2, ad2);
        IPerson person1 = new Person("Jane Doe", ad2);

        try {
            IPosition pos1 = new Position(0, 0, 0);
            IPosition pos2 = new Position(2, 0, 0);
            IPosition pos3 = new Position(4, 0, 0);
            IPosition pos4 = new Position(6, 0, 0);
            IPosition pos5 = new Position(8, 0, 0);
            IPosition pos6 = new Position(0, 2, 0);
            IPosition pos7 = new Position(2, 2, 0);
            IPosition[] posicoes = new IPosition[6];
            posicoes[0] = pos1;
            posicoes[1] = pos2;
            posicoes[2] = pos3;
            posicoes[3] = pos4;
            posicoes[4] = pos5;
            posicoes[5] = pos6;
            

            Container container1 = new Container("Container1", 10, 4, 2, Color.white, Color.black);
            Container container2 = new Container("Container2", 10, 4, 2, Color.white, Color.black);
            Container container3 = new Container("Container3", 10, 4, 2, Color.white, Color.black);
            Container container4 = new Container("Container4", 10, 4, 2, Color.white, Color.black);
            Container container5 = new Container("Container5", 10, 4, 2, Color.white, Color.black);

            IOrder order = new Order(1,2);
            IOrder order2 = new Order(2,2);
            OrderImporter importer = new OrderImporter();
            importer.importData(order, "files/Order1.json");
            importer.importData(order2, "files/Order2.json");
            IShipping ship1 = new Shipping();
            IShipping ship2 = new Shipping();
            IShipping ship3 = new Shipping();
            IShipping ship4 = new Shipping();

            ship1.setShipmentStatus(ShipmentStatus.IN_TREATMENT);
            ship2.setShipmentStatus(ShipmentStatus.IN_TREATMENT);
            ship3.setShipmentStatus(ShipmentStatus.IN_TREATMENT);
            ship4.setShipmentStatus(ShipmentStatus.IN_TREATMENT);

            int k = 0;
            for(int j  = 0;j < 3;j++){
                container1.addItem(order.getItems()[j], posicoes[k], Color.gray);
                k++;
            }
            k = 0;
            for(int j = 3;j < 5;j++){
                container2.addItem(order.getItems()[j], posicoes[k], Color.gray);
                k++;
            }
            k = 0;
            for(int j  = 0;j < 5;j++){
                container3.addItem(order2.getItems()[j], posicoes[k], Color.gray);
                k++;
            }
            k = 0;
            for(int j = 5;j < 9;j++){
                container4.addItem(order2.getItems()[j], posicoes[k], Color.gray);
                k++;
            }
            container5.addItem(order2.getItems()[9], pos7, Color.silver);
            
            container1.close();
            container2.close();
            container3.close();
            container4.close();
            container5.close();
            
            ship1.addContainer(container1);
            ship2.addContainer(container2);
            ship3.addContainer(container3);
            ship4.addContainer(container4);
            ship4.addContainer(container5);
            
            ship1.setShipmentStatus(ShipmentStatus.CLOSED);
            ship2.setShipmentStatus(ShipmentStatus.CLOSED);
            ship3.setShipmentStatus(ShipmentStatus.CLOSED);
            ship4.setShipmentStatus(ShipmentStatus.CLOSED);
            
//            ship1.setShipmentStatus(ShipmentStatus.SHIPPED);
            ship2.setShipmentStatus(ShipmentStatus.SHIPPED);
            ship3.setShipmentStatus(ShipmentStatus.SHIPPED);
            ship4.setShipmentStatus(ShipmentStatus.SHIPPED);    
            
//            ship1.setShipmentStatus(ShipmentStatus.RECEIVED);
            ship2.setShipmentStatus(ShipmentStatus.RECEIVED);
            ship3.setShipmentStatus(ShipmentStatus.RECEIVED);
            ship4.setShipmentStatus(ShipmentStatus.RECEIVED);            

            order.addShipping(ship1);
            order.addShipping(ship2);
            order2.addShipping(ship3);
            order2.addShipping(ship4);
            
            order.close();
            order2.close();
                        
            Management management = new Management();
            management.add(order);
            management.add(order2);
            
            IOrder[] orders = new IOrder[2];
            orders[0] = order;
            orders[1] = order2;
            
//            System.out.println(order2.summary());
//            PackingGUI.render("files/Order2exp.json");
//            Exporter exp = new Exporter(order, "files/Order1exp.json");
//            exp.setGraphOrders(orders);
//            exp.setGraphBarPath("files/graph1.json");
//            exp.setGraphPiePath("files/graph2.json");
//            exp.setOrderInfoPath("files/orderInfo.json");
//            exp.export();
            

        } catch (IOException | BoxException | ContainerException | OrderException | PositionException | ParseException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
