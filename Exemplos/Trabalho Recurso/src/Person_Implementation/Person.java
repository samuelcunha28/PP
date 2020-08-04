package Person_Implementation;

import order.base.IAddress;
import order.base.IPerson;

/**
 * This class represents a {@link IPerson}.
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
public class Person implements IPerson {

    /**
     * Person's name
     */
    private String name;

    /**
     * Person's address
     */
    private IAddress address;

    /**
     * Creates an instance of <code>Person</code>
     *
     * @param name Person's name.
     * @param address Person's address.
     */
    public Person(String name, IAddress address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Gets the attribute {@link Person#name name}.
     *
     * @return The {@link Person#name name}.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the attribute {@link Person#name name}.
     *
     * @param name Person's {@link Person#name name}.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the attribute {@link Person#address address}.
     *
     * @return The {@link Person#address address}.
     */
    @Override
    public IAddress getAddress() {
        return address;
    }

    /**
     * Sets the attribute {@link Person#address address}.
     *
     * @param address Person's {@link Person#address address}.
     */
    @Override
    public void setAddress(IAddress address) {
        this.address = address;
    }

    /**
     * Returns a string representation of {@link Person}.
     *
     * @return String with every information about {@link Person}.
     */
    @Override
    public String toString() {
        return "Name: " + this.name + "\n\nAddress\n" + this.address.toString();
    }
}
