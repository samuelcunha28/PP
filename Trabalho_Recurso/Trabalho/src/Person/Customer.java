package Person;

import order.base.IAddress;
import order.base.ICustomer;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class Customer implements ICustomer {

    private IAddress address;
    private String name;
    private String vat;
    private int customerId;
    private IAddress billingAddress;

    /**
     * Construtor de Customer
     *
     * @param customerId id do cliente (inteiro)
     */
    public Customer(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Construtor de Customer
     *
     * @param name nome (String)
     * @param address morada (String)
     */
    public Customer(String name, IAddress address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Construtor de Customer
     *
     * @param address morada do cliente (Tipo IAddress)
     * @param name nome do cliente (String)
     * @param vat contribuinte do cliente (String)
     * @param customerId id do cliente (inteiro)
     * @param billingAddress morada de faturacao do cliente (Tipo IAddress)
     */
    public Customer(IAddress address, String name, String vat, int customerId, IAddress billingAddress) {
        this.address = address;
        this.name = name;
        this.vat = vat;
        this.customerId = customerId;
        this.billingAddress = billingAddress;
    }

    /**
     * Metodo para obter a morada de faturacao da encomenda
     *
     * @return billingAddress (Tipo IAddress)
     */
    @Override
    public IAddress getBillingAddress() {
        return this.billingAddress;
    }

    /**
     * Metodo para atribuir a morada de faturacao da encomenda
     *
     * @param iaddress morada do tipo IAddress
     */
    @Override
    public void setBillingAddress(IAddress iaddress) {

        this.billingAddress = iaddress;
    }

    /**
     * Metodo para obter o id do cliente
     *
     * @return customerId (inteiro)
     */
    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    /**
     * Metodo para atribuir o id do cliente
     *
     * @param customerId id do cliente a atribuir (inteiro)
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Metodo para obter a morada do cliente
     *
     * @return morada do tipo IAddress
     */
    @Override
    public IAddress getAddress() {
        return this.address;
    }

    /**
     * Metodo para atribuir a morada do cliente
     *
     * @param Iaddress do tipo IAddress
     */
    @Override
    public void setAddress(IAddress Iaddress) {
        this.address = Iaddress;

    }

    /**
     * Metodo para obter o nome do cliente
     *
     * @return nome do cliente (String)
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Metodo para atribuir o nome do cliente
     *
     * @param name nome do cliente (String)
     */
    @Override
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Metodo para obter o contribuinte do cliente
     *
     * @return contribuite do cliente (String)
     */
    @Override
    public String getVat() {
        return this.vat;
    }

    /**
     * Metodo para atribuir o contribuinte do cliente
     *
     * @param vat contribuinte do cliente (String)
     */
    @Override
    public void setVat(String vat) {
        this.vat = vat;
    }

    /**
     * Metodo toString para impressao
     *
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