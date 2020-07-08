package Person;

import order.base.IAddress;
import order.base.ICustomer;

/**
 *
 * @author samue
 */
public class Destination implements ICustomer {

    private IAddress address;
    private String name;
    private String vat;

    /**
     * Construtor de Destination
     *
     * @param address
     * @param name
     */
    public Destination(IAddress address, String name) {
        this.address = address;
        this.name = name;
    }

    @Override
    public IAddress getBillingAddress() {
        return null;
    }

    @Override
    public int getCustomerId() {
        return 0;
    }

    @Override
    public void setBillingAddress(IAddress iAddress) {

    }

    /**
     *
     * @return Address
     */
    @Override
    public IAddress getAddress() {
        return this.address;
    }

    /**
     *
     * @return Destination Name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param iAddress
     */
    @Override
    public void setAddress(IAddress iAddress) {

        this.address = iAddress;
    }

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
}
