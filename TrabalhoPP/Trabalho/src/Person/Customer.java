/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import order.base.IAddress;
import order.base.ICustomer;

/**
 *
 * @author samue
 */
public class Customer extends Person implements ICustomer {
    
    // variaveis de instancia
    private static int id = 1;
    private int costumerId;
    private String vat;
    private IAddress billingAddress;

    public Customer() {
    }

    /**
     * Construtor de Customer 
     * @param costumerId id do cliente (String)
     * @param vat contribuinte (String)
     * @param billingAddress morada de faturacao (String)
     * @param name nome (String)
     * @param address morada (String)
     */
    public Customer(int costumerId, String vat, IAddress billingAddress, String name, Address address) {
        super(name, address);
        this.costumerId = costumerId;
        this.vat = vat;
        this.billingAddress = billingAddress;
        id++; // contador de customers
    }

    /**
     * 
     * @return 
     */
    @Override
    public int getCustomerId() {
        return id;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getVat() {
        return vat;
    }

    /**
     * 
     * @param vat 
     */
    @Override
    public void setVat(String vat) {
        this.vat = vat;
    }

    /**
     * 
     * @return 
     */
    @Override
    public IAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * 
     * @param billingAddress 
     */
    @Override
    public void setBillingAddress(IAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    
    
}
