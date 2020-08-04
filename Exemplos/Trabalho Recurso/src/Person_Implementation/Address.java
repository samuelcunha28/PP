package Person_Implementation;

import order.base.IAddress;

/**
 * This class represents an {@link IAddress}.
 *
 * Nome: José Pedro Fernandes 
 * Número: 8190239 
 * Turma: LEI T4
 *
 * Nome: Hugo Maia Alves
 * Número: 8160521
 * Turma: LEIT2
 * 
 */
public class Address implements IAddress {

    /**
     * The adress's city.
     */
    private String city;

    /**
     * The adress's country
     */
    private String country;

    /**
     * The adress's number.
     */
    private int number;

    /**
     * The adress's state.
     */
    private String state;

    /**
     * The adress's street.
     */
    private String street;

    /**
     * Creates an instance of <code>Address</code>
     *
     * @param city The adress's city.
     * @param country The adress's country.
     * @param number The adress's number.
     * @param state The adress's state.
     * @param street The adress's street.
     */
    public Address(String city, String country, int number, String state, String street) {
        this.city = city;
        this.country = country;
        this.number = number;
        this.state = state;
        this.street = street;
    }

    /**
     * Gets the attribute {@link Address#city city}.
     *
     * @return The {@link Address#city city}.
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * Sets the attribute {@link Address#city city}.
     *
     * @param city The {@link Address#city city}.
     */
    @Override
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the attribute {@link Address#country}.
     *
     * @return The {@link Address#country}.
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * Sets the attribute {@link Address#country}.
     *
     * @param country The {@link Address#country}.
     */
    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the attribute {@link Address#number number}.
     *
     * @return The {@link Address#number number}.
     */
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * Sets the attribute {@link Address#number number}.
     *
     * @param number The {@link Address#number number}.
     */
    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets the attribute {@link Address#state state}.
     *
     * @return The {@link Address#state state}.
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * Sets the attribute {@link Address#state state}.
     *
     * @param state The {@link Address#state state}.
     */
    @Override
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the attribute {@link Address#street street}.
     *
     * @return The {@link Address#street street}.
     */
    @Override
    public String getStreet() {
        return street;
    }

    /**
     * Sets the attribute {@link Address#street street}.
     *
     * @param street The {@link Address#street street}.
     */
    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns a string representation of {@link Address}.
     *
     * @return String with every information about {@link Address}.
     */
    @Override
    public String toString() {
        return "City: " + this.city + "\nCountry: " + this.country
                + "\nDoor Number: " + this.number + "\nState: " + this.state + "\nStreet: " + this.street;
    }

}
