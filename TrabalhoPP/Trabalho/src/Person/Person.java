package Person;

import order.base.IAddress;
import order.base.IPerson;

/**
 *
 * @author samue
 */
public class Person implements IPerson{
    
    // variaveis de instancia de Person
    private String name;
    private IAddress address;

    public Person() {
    }
    
    /**
     * Construtor para Person
     * @param name nome da pessoa
     * @param address morada da pessoa
     */
    public Person(String name, Address address){
        this.name = name;
        this.address = address;
    }
    
    /**
     * Metodo para obter o nome
     * @return name (String)
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Metodo para atribuir
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return 
     */
    @Override
    public IAddress getAddress() {
        return address;
    }

    /**
     * 
     * @param address 
     */
    @Override
    public void setAddress(IAddress address) {
        this.address = address;
    } 
    
    /**
     * 
     * @return 
     */
     @Override
    public String toString() {
        String text = "Name : " + name + "\n"
                + "Address : " + address + "\n";
        return text;
    }
}