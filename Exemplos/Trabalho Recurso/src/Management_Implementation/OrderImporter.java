package Management_Implementation;

import Container_Implementation.Item;
import Person_Implementation.Address;
import Person_Implementation.Customer;
import Person_Implementation.Person;
import java.io.FileReader;
import java.io.IOException;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.management.IOrder;
import order.management.IOrderImporter;
import order.packing.IContainer;
import order.packing.IPosition;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class implements {@link IOrderImporter}.
 * 
 * Nome : José Pedro Fernandes 
 * Número: 8190239 
 * Turma: LEI T4
 *
 * Nome: Hugo Maia Alves
 * Número: 8160521
 * Turma: LEIT2
 * 
 */
public class OrderImporter implements IOrderImporter {

    /**
     * Parse the data (from a data source) to fill a given {@link IOrder order}.
     * 
     * @param iorder {@link IOrder order} to be filled.
     * @param string file path with data to deserialize
     * @throws IOException  java.io.IOException Signals that an I/O exception of some sort has occurred. 
     * This class is the general class of exceptions produced by failed or interrupted I/O operations.
     * @throws ParseException Signals that an error has been reached unexpectedly while parsing.
     * @throws ContainerException if any imported {@link IContainer container} is invalid.
     * @throws OrderException if the imported {@link IOrder order} is invalid.
     * @throws PositionException if some imported {@link IPosition position} is invalid.
     */
    @Override
    public void importData(IOrder iorder, String string) throws IOException, ParseException, ContainerException, OrderException, PositionException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(string);
        Object obj = jsonParser.parse(reader);

        JSONObject jsonObject = (JSONObject) obj;

        int id = Integer.parseInt((String) jsonObject.get("id"));

        JSONObject date = (JSONObject) jsonObject.get("date");
        int day = Integer.parseInt(date.get("day").toString());
        int month = Integer.parseInt(date.get("month").toString());
        int year = Integer.parseInt(date.get("year").toString());

        JSONObject customer = (JSONObject) jsonObject.get("customer");
        String name = (String) customer.get("name");
        String vat = (String) customer.get("vat");

        JSONObject jsonAddress = (JSONObject) customer.get("address");
        String country = (String) jsonAddress.get("country");
        int number = Integer.parseInt(jsonAddress.get("number").toString());
        String street = (String) jsonAddress.get("street");
        String city = (String) jsonAddress.get("city");
        String state = (String) jsonAddress.get("state");

        JSONObject jsonBillingAddress = (JSONObject) customer.get("billingAddress");
        String billingCountry = (String) jsonBillingAddress.get("country");
        int billingNumber = Integer.parseInt(jsonBillingAddress.get("number").toString());
        String billingStreet = (String) jsonBillingAddress.get("street");
        String billingCity = (String) jsonBillingAddress.get("city");
        String billingState = (String) jsonBillingAddress.get("state");

        JSONObject destination = (JSONObject) jsonObject.get("destination");
        String destname = (String) destination.get("name");

        JSONObject destaddress = (JSONObject) destination.get("address");
        String destCountry = (String) destaddress.get("country");
        int destNumber = Integer.parseInt(destaddress.get("number").toString());
        String destStreet = (String) destaddress.get("street");
        String destCity = (String) destaddress.get("city");
        String destState = (String) destaddress.get("state");

        Address address = new Address(city, country, number, state, street);
        Address billingAddress = new Address(billingCity, billingCountry, billingNumber, billingState, billingStreet);
        Address destinationAddress = new Address(destCity, destCountry, destNumber, destState, destStreet);

        String reference;
        int depth;
        int length;
        int height;
        String description;

        JSONArray items = (JSONArray) jsonObject.get("items");
        for (Object item : items) {
            reference = ((JSONObject) item).get("reference").toString();
            depth = Integer.parseInt(((JSONObject) item).get("depth").toString());
            length = Integer.parseInt(((JSONObject) item).get("length").toString());
            height = Integer.parseInt(((JSONObject) item).get("height").toString());
            description = ((JSONObject) item).get("description").toString();
            iorder.add(new Item(length, depth, height, reference, description));
        }

        iorder.setId(id);
        iorder.setDate(day, month, year);
        iorder.setCustomer(new Customer(name, vat, address, billingAddress));
        iorder.setDestination(new Person(destname, destinationAddress));
    }

}
