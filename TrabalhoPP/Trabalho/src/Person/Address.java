/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * 
     * @return 
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getStreet() {
        return street;
    }

    /**
     * 
     * @param city 
     */
    @Override
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @param country 
     */
    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @param number 
     */
    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 
     * @param state 
     */
    @Override
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @param street 
     */
    @Override
    public void setStreet(String street) {
        this.street = street;
    }
    
    /**
     * 
     * @return 
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