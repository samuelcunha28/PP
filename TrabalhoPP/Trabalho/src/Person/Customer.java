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
    private int customerId;
    private String vat;
    private IAddress billingAddress;

    public Customer(int customerId){
        this.customerId = customerId;
    }

    /**
     * Construtor de Customer 
     * @param customerId id do cliente (String)
     * @param vat contribuinte (String)
     * @param billingAddress morada de faturacao (String)
     * @param name nome (String)
     * @param address morada (String)
     */
    public Customer(int customerId, String vat, IAddress billingAddress, String name, Address address) {
        super(name, address);
        this.customerId = customerId;
        this.vat = vat;
        this.billingAddress = billingAddress;
        id++; // contador de customers
    }

    /**
     * Metodo para obter o id
     * @return id (inteiro)
     */
    @Override
    public int getCustomerId() {
        return this.id;
    }
    
    /**
     * Metodo para atribuir o id
     * @param customerId id a atribuir (inteiro)
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Metodo para obter o contribuinte
     * @return contibuinte (String)
     */
    @Override
    public String getVat() {
        return this.vat;
    }

    /**
     * Metodo para atribuir o contribuinte
     * @param vat contribuinte a atribuir (String)
     */
    @Override
    public void setVat(String vat) {
        this.vat = vat;
    }

    /**
     * Metodo para obter a morada de faturacao
     * @return morada de faturacao do tipo IAddress
     */
    @Override
    public IAddress getBillingAddress() {
        return this.billingAddress;
    }

    /**
     * Metodo para atribuir a morada de faturacao
     * @param billingAddress morada de faturacao do tipo IAddress
     */
    @Override
    public void setBillingAddress(IAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    /**
     * Metodo toString para imprimir os atributos da classe
     * @return text a imprimir
     */
     @Override
    public String toString() {
        System.out.print(super.toString());
        String text = "CustomerID : " + customerId + "\n"
                + "VAT : " + vat + "\n"
                + "Billing Address : " + billingAddress + "\n";
        return text;
    }
}