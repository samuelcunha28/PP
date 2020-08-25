package HumanResources;
import hr.IAddress;
import hr.ICustomer;
import java.time.LocalDate;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Customer extends Person implements ICustomer {

    /**
     * The Customer vat.
     */
    private String vat;

    /**
     * Constructor of Customer
     * @param vat The customer vat.
     * @param id The customer id.
     * @param address The customer address.
     * @param name The customer name.
     * @param birthDate The customer birthDate.
     */
    public Customer(String vat, String id, IAddress address, String name, LocalDate birthDate) {
        super(id, address, name, birthDate);
        this.vat = vat;
    }
    
    /**
     * Getter for vat.
     * @return The customer vat.
     */
    @Override
    public String getVat() {
        return vat;
    }

    /**
     * Setter for vat.
     * @param vat The customer vat.
     */
    public void setVat(String vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return super.toString() + "\nVAT: " + this.vat;
    }

    /**
     * Compares two Customers.
     * @param obj object to be compared
     * @return true if obj is equal to the customer vat.
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
        if (other.vat != this.vat) {
            return false;
        }
        return true;
    }
}