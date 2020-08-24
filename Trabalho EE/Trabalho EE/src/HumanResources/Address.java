package HumanResources;
import hr.IAddress;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Address implements IAddress {
    
    /**
     * The address city.
     */
    private String city;

    /**
     * The address country
     */
    private String country;

    /**
     * The address number.
     */
    private int number;

    /**
     * The address state.
     */
    private String state;

    /**
     * The address street.
     */
    private String street;

    /**
     * Constructor of Address
     *
     * @param city The address city.
     * @param country The address country.
     * @param number The address number.
     * @param state The address state.
     * @param street The address street.
     */
    public Address(String city, String country, int number, String state, String street) {
        this.city = city;
        this.country = country;
        this.number = number;
        this.state = state;
        this.street = street;
    }
    
    /**
     * Getter for city.
     * @return The address city.
     */
    @Override
    public String getCity() {
        return city;
    }
    
    /**
     * Setter for the address city.
     * @param city The address city.
     */
    @Override
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for country.
     * @return The address country.
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * Setter for the address country.
     * @param country The address country.
     */
    @Override
    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
     * Getter for number.
     * @return The address number.
     */
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * Setter for the address number.
     * @param number The address number.
     */
    @Override
    public void setNumber(int number) {
        this.number = number;
    }
    
    /**
     * Getter for state.
     * @return The address state.
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * Setter for the address state.
     * @param state The address state.
     */
    @Override
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * Getter for street.
     * @return The address street.
     */
    @Override
    public String getStreet() {
        return street;
    }
    
    /**
     * Setter for the address street.
     * @param street The address street.
     */
    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * To String method representing the Address.
     * @return String with all the information about the address.
     */
    @Override
    public String toString() {
        return "City: " + this.city + "\nCountry: " + this.country 
                + "\nNumber: " + this.number + "\nState: " + this.state 
                + "\nStreet: " + this.street;
    }
}