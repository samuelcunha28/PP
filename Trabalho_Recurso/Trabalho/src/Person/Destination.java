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
public class Destination implements ICustomer {

    private IAddress address;
    private String name;
    private String vat;
    private IAddress billingAddress;
    private int customerId;

    /**
     * Construtor de Destination
     *
     * @param address morada de destino
     * @param name nome
     */
    public Destination(IAddress address, String name) {
        this.address = address;
        this.name = name;
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
     * Metodo para obter a morada de destino
     *
     * @return address morada do tipo IAddress
     */
    @Override
    public IAddress getAddress() {
        return this.address;
    }

    /**
     * Metodo para atribuir a morada de destino
     *
     * @param iaddress morada do tipo IAddress
     */
    @Override
    public void setAddress(IAddress iaddress) {
        this.address = iaddress;
    }

    /**
     * Metodo para obter o nome da pessoa de destino
     *
     * @return nome da pessoa de destino (String)
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Metodo para atribuir o nome da pessoa de destino
     *
     * @param name nome da pessoa de destino (String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo para obter o contribuinte de destino
     *
     * @return contribuinte (String)
     */
    @Override
    public String getVat() {
        return this.vat;
    }

    /**
     * Metodo para atribuir o contribuinte de destino
     *
     * @param vat contribuinte (String)
     */
    @Override
    public void setVat(String vat) {
        this.vat = vat;
    }
}