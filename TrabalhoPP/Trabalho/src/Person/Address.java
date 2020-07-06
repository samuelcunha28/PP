package Person;

import order.base.IAddress;

/**
 *
 * @author samue
 */
public class Address implements IAddress {
    
    // variaveis de instancia
    private String city;
    private String country;
    private int number;
    private String state;
    private String street;

    public Address() {
    }

    /**
     * Construtor para Address
     * @param city cidade (String)
     * @param country pais (String)
     * @param number numero (String)
     * @param state provincia (String)
     * @param street rua (String)
     */
    public Address(String city, String country, int number, String state, String street) {
        this.city = city;
        this.country = country;
        this.number = number;
        this.state = state;
        this.street = street;
    }
    
    /**
     * Metodo para obter uma cidade
     * @return cidade (String)
     */
    @Override
    public String getCity() {
        return this.city;
    }

    /**
     * Metodo para atribuir uma cidade
     * @param city cidade a atribuir (String)
     */
    @Override
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * Metodo para obter o pais
     * @return pais (String)
     */
    @Override
    public String getCountry() {
        return this.country;
    }
    
    /**
     * Metodo para atribuir o pais
     * @param country pais a atribuir (String)
     */
    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Metodo para obter o numero
     * @return numero (inteiro)
     */
    @Override
    public int getNumber() {
        return this.number;
    }
    
    /**
     * Metodo para atribuir o numero
     * @param number numero a atribuir (inteiro)
     */
    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Metodo para obter o estado (provincia)
     * @return estado (provincia) (String)
     */
    @Override
    public String getState() {
        return this.state;
    }

    /**
     * Metodo para atribuir o estado (provincia)
     * @param state estado (provincia) a atribuir (String)
     */
    @Override
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * Metodo para obter a rua
     * @return rua (String)
     */
    @Override
    public String getStreet() {
        return street;
    }

    /**
     * Metodo para atribuir a rua
     * @param street rua a atribuir (String)
     */
    @Override
    public void setStreet(String street) {
        this.street = street;
    }
    
    /**
     * Metodo toString para imprimir os atributos da classe
     * @return text a imprimir
     */
     @Override
    public String toString() {
        String text = "City : " + city + "\n"
                + "Country : " + country + "\n"
                + "Number : " + number + "\n"
                + "State : " + state + "\n"
                + "Street : " + street + "\n";
        return text;
    }
}