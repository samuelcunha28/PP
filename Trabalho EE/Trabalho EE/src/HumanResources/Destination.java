package HumanResources;

import hr.IAddress;
import hr.IDestination;
import hr.IGeoCoordinates;
import java.time.LocalDate;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Destination extends Person implements IDestination {

    /**
     * The geo coordinates.
     */
    private GeoCoordinates coordinates;
    
    /**
     * Constructor of Destination
     * @param id The person destination id.
     * @param address The destination address.
     * @param name The person destination name.
     * @param birthDate The person destination birth date.
     */
    public Destination(String id, IAddress address, String name, LocalDate birthDate) {
        super(id, address, name, birthDate);
    }

    /**
     * Getter for geo coordinates.
     * @return The destination coordinates.
     */
    @Override
    public IGeoCoordinates getGeoCoordinates() {
       return coordinates;
    }

    /**
     * Setter for geo coordinates
     * @param coordinates the destination coordinates
     */
    public void setCoordinates(GeoCoordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    /**
     * To String method representing the Destination.
     * @return String with all the information about the destination.
     */
    @Override
    public String toString() {
        return super.toString() + "\nCoordinates: " + this.coordinates; 
    }
}