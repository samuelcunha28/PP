package HumanResources;

import hr.IAddress;
import hr.IPerson;
import java.time.LocalDate;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class Person implements IPerson {

    /**
     * The Person id.
     */
    private String id;
    
    /**
     * The Person address.
     */
    private IAddress address;
    
    /**
     * The Person name.
     */
    private String name;
    
    /**
     * The Person birth date.
     */
    private LocalDate birthDate;

    /**
     * Constructor of Person
     * @param id The person id.
     * @param address The person address.
     * @param name The person name.
     * @param birthDate The person birth date.
     */
    public Person(String id, IAddress address, String name, LocalDate birthDate) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.birthDate = birthDate;
    }
    
    /**
     * Getter for id.
     * @return The person id.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Setter for id.
     * @param id The person id.
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Getter for address.
     * @return The person address.
     */
    @Override
    public IAddress getAddress() {
        return address;
    }

    /**
     * Setter for address.
     * @param address The person address.
     */
    public void setAddress(IAddress address) {
        this.address = address;
    }
    
    /**
     * Getter for name.
     * @return The person name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     * @param name The person name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for birth date.
     * @return The person birth date.
     */
    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Setter for birth date.
     * @param birthDate The person birth date.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    
    /**
     * To String method representing the Person.
     * @return String with all the information about the person.
     */
    @Override
    public String toString() {
        return "ID: " + this.id + "\nAddress: " + this.address 
                + "\nName: " + this.name + "\nBirth Date: " + this.birthDate; 
    }
    
    /**
     * Compares two Persons.
     * 
     * @param obj object to be compared
     * @return true if obj is equal to the person id.
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
        final Person other = (Person) obj;
        if (other.id != this.id) {
            return false;
        }
        return true;
    }
}