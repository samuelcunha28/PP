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
        return this.name;
    }
    
    /**
     * Metodo para atribuir o nome
     * @param name nome a atribuir (String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Metodo para obter a morada
     * @return morada do tipo IAddress
     */
    @Override
    public IAddress getAddress() {
        return this.address;
    }

    /**
     * Método para atribuir a morada
     * @param address morada do tipo IAddress
     */
    @Override
    public void setAddress(IAddress address) {
        this.address = address;
    } 
    
    /**
     * Metodo toString para imprimir os atributos da classe
     * @return text a imprimir
     */
     @Override
    public String toString() {
        String text = "Name : " + name + "\n"
                + "Address : " + address + "\n";
        return text;
    }
}