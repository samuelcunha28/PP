package HumanResources;
import hr.IGeoCoordinates;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class GeoCoordinates implements IGeoCoordinates {

    /**
     * The GeoCoordinates latitude.
     */
    private double latitude;
    
    /**
     * The GeoCoordinates longitude.
     */
    private double longitude;

    /**
     * Constructor of GeoCoordinates
     * @param latitude The geo coordinates latitude.
     * @param longitude The geo coordinates longitude.
     */
    public GeoCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Getter for latitude.
     * @return The latitude coordinates.
     */
    @Override
    public double getLatitude() {
        return latitude;
    }

    /**
     * Setter for latitude.
     * @param latitude the latitude coordinates.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    /**
     * Getter for longitude.
     * @return The longitude coordinates.
     */
    @Override
    public double getLongitude() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Setter for longitude.
     * @param longitude The longitude coordinates.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
 
    /**
     * To String method representing the Person.
     * @return String with all the information about the person.
     */
    @Override
    public String toString() {
        return "LATITUDE: " + this.latitude + "\nLONGITUDE: " + this.longitude; 
    }

    /**
     * Compares two latitude and two longitude coordinates.
     * @param obj object to be compared
     * @return if obj is equal to the both latitude or longitude coordinates.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GeoCoordinates other = (GeoCoordinates) obj;
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(other.longitude)) {
            return false;
        }
        return true;
    }
}