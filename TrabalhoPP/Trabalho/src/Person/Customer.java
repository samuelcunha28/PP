package Person;

import order.base.IAddress;
import order.base.ICustomer;

/**
 *
 * @author samue
 */
public class Customer implements ICustomer {

    private IAddress address;
    private String name;
    private String vat;
    private int costumerId;
    private IAddress billingAddress;

    public Customer(int costumerId) {
        this.costumerId = costumerId;
    }

    /**
     *
     * @param address
     * @param name
     * @param vat
     * @param costumerId
     * @param billingAddress
     */
    public Customer(IAddress address, String name, String vat, int costumerId, IAddress billingAddress) {
        this.address = address;
        this.name = name;
        this.vat = vat;
        this.costumerId = costumerId;
        this.billingAddress = billingAddress;
    }

    public Customer(String name, IAddress address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Retorna o endereco de envio da encomenda
     *
     * @return
     */
    @Override
    public IAddress getBillingAddress() {
        return this.billingAddress;
    }

    /**
     * Retorna o ID do cliente
     *
     * @return
     */
    @Override
    public int getCustomerId() {
        return this.costumerId;
    }

    /**
     * Adicionar morada de cobranca
     *
     * @param iAddress
     */
    @Override
    public void setBillingAddress(IAddress iAddress) {

        this.billingAddress = iAddress;
    }

    /**
     * Retorna Endereco do cliente
     *
     * @return
     */
    @Override
    public IAddress getAddress() {
        return this.address;
    }

    /**
     * Retorna o nome do cliente
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Adicionar endereco
     *
     * @param iAddress
     */
    @Override
    public void setAddress(IAddress iAddress) {
        this.address = iAddress;

    }

    /**
     * Adiciona nome do cliente
     *
     * @param s
     */
    @Override
    public void setName(String s) {

        this.name = s;
    }

    /**
     *
     * @return
     */
    @Override
    public String getVat() {
        return this.vat;
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
     * Metodo toString para imprimir os atributos da classe
     *
     * @return text a imprimir
     */
    @Override
    public String toString() {
        System.out.print(super.toString());
        String text = "CustomerID : " + costumerId + "\n"
                + "VAT : " + vat + "\n"
                + "Billing Address : " + billingAddress + "\n";
        return text;
    }
}
