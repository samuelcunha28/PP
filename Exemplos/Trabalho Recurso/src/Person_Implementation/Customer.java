package Person_Implementation;

import order.base.IAddress;
import order.base.ICustomer;

/**
 * This class represents a {@link ICustomer}.
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
public class Customer extends Person implements ICustomer {

    /**
     * Customer's Id.
     */
    private int customerId;
    
    private static int nextID = 0;

    /**
     * Customer's billingAddress.
     */
    private IAddress billingAddress;
    
    /**
     * Customer's vat Number
     */
    private String vat;

    /**
     * Creates an instance of <code>Customer</code>
     *
     * @param name Customer's name.
     * @param vat Customer's vat.
     * @param address Customer's address.
     * @param billingAddress Customer's billingAddress.
     */
    public Customer(String name,String vat, IAddress address, IAddress billingAddress) {
        super(name, address);
        this.customerId = nextID++;
        this.vat = vat;
        this.billingAddress = billingAddress;
    }
    

    /**
     * Gets the attribute {@link Customer#billingAddress billingAddress}.
     *
     * @return The {@link Customer#billingAddress billingAddress}
     */
    @Override
    public IAddress getBillingAddress() {
        return this.billingAddress;
    }

    /**
     * Gets the attribute {@link Customer#customerId customerId}.
     *
     * @return The {@link Customer#customerId customerId}
     */
    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    /**
     * Sets the attribute {@link Customer#billingAddress billingAddress}.
     *
     * @param ia Customer's {@link Customer#billingAddress billingAddress}
     */
    @Override
    public void setBillingAddress(IAddress ia) {
        this.billingAddress = ia;
    }

    /**
     * Sets the attribute {@link Customer#customerId customerId}.
     *
     * @param customerId Customer's {@link Customer#customerId customerId}.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the attribute {@link Customer#vat VatNumber}.
     * 
     * @return The {@link Customer#vat VatNumber}.
     */
    @Override
    public String getVat() {
        return this.vat;
    }

    /**
     * Sets the attribute {@link Customer#vat VatNumber}.
     * 
     * @param newVat Customer's {@link Customer#vat VatNumber}.
     */
    @Override
    public void setVat(String newVat) {
        this.vat = newVat;
    }
    
    /**
     * Returns a string representation of {@link Customer}.
     *
     * @return String with every information about {@link Customer}.
     */
    @Override
    public String toString() {
        return super.toString() + "\nCustomerId: " + this.customerId + "\n\nBillingAddress\n" + this.billingAddress.toString();
    }

    /**
     * Compares two {@link Customer customers}.
     * 
     * @param obj object to be compared
     * @return true if obj is equal to the {@link Customer customers}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        return true;
    }
    
}
