package OrderManagement;

import java.time.LocalDate;
import order.base.ICustomer;
import order.base.IPerson;
import Exceptions.*;
import order.management.IOrder;
import order.management.IShipping;
import order.packing.IItem;
import OrderManagement.Shipping;
import OrderPacking.Container;
import order.packing.Color;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T3>
 */
public class Order implements IOrder {

    // variaveis de instancia
    private IPerson destination;
    private ICustomer customer;
    private int id;
    private int year;
    private int month;
    private int day;
    private IItem[] items = new IItem[10];
    private IShipping[] shippings = new IShipping[10];

    /**
     *
     * @param destination
     * @param customer
     * @param id
     * @param year
     * @param month
     * @param day
     */
    public Order(IPerson destination, ICustomer customer, int id, int year, int month, int day) {
        this.destination = destination;
        this.customer = customer;
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public IPerson getDestination() {
        return this.destination;
    }

    @Override
    public void setDestination(IPerson destination) {
        this.destination = destination;
    }

    /**
     * Metodo que retorna o cliente
     *
     * @return customer
     */
    @Override
    public ICustomer getCustomer() {
        return this.customer;
    }

    /**
     *
     * @param customer
     */
    @Override
    public void setCustomer(ICustomer customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     */
    @Override
    public IItem[] getItems() {
        int tmp = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                tmp++;
            }
        }
        IItem[] newItem = new IItem[tmp];
        for (int i = 0; i < newItem.length; i++) {
            newItem[i] = items[i];
        }
        return newItem;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     *
     * @param year
     * @param month
     * @param day
     */
    @Override
    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     *
     * @return
     */
    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }

    /**
     *
     * @param item
     * @return
     * @throws OrderExceptionImpl
     */
    @Override
    public boolean add(IItem item) throws OrderExceptionImpl {
        boolean test = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                item = items[i];
                break;
            } else if (items[items.length - 1] != null) {
                test = true;
            }
        }
        if (test) {
            throw new OrderExceptionImpl("Array sem posicoes disponiveis");
        }
        return test;
    }

    /**
     *
     * @return
     */
    @Override
    public IShipping[] getShippings() {
        int tmp = 0;

        for (int i = 0; i < shippings.length; i++) {
            if (shippings[i] != null) {
                tmp++;
            }
        }
        IShipping[] newItem = new IShipping[tmp];
        for (int i = 0; i < newItem.length; i++) {
            newItem[i] = shippings[i];
        }
        return newItem;
    }

    /*
    @Override
    public boolean addContainer(IContainer con) throws OrderExceptionImpl, ContainerExceptionImpl {
        boolean aux = false;
        if (status != ShipmentStatus.IN_TREATMENT) {
            throw new OrderExceptionImpl("Estado invalido! Nao se encontra em tratamento");
        } else {
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] == null) {
                    containers[i] = con;
                    break;
                } else if (containers[containers.length - 1] != null) {
                    aux = true;
                }
            }
            if (aux == true) {
                throw new ContainerExceptionImpl("Container sem posicoes disponiveis");
            }
        }
        return aux;
    }
     */
    @Override
    public boolean addShipping(IShipping shipping) throws OrderExceptionImpl {
        boolean aux = false;
        for (int i = 0; i < shippings.length; i++) {
            if (shippings[i] == null) {
                shippings[i] = shipping;
                break;
            } else if (shippings[shippings.length - 1] != null) {
                aux = true;
            }
        }
        if (aux == true) {
            throw new OrderExceptionImpl("Sem posicoes disponiveis");
        }
        return aux;
    }

    /*
    @Override
    public boolean removeItem(IItem item) throws ContainerExceptionImpl {
        int index = 0;
        int j = 0;
        boolean aux = false;
        if (item instanceof IItem) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null && items[i].getItem().getReference().equals(item.getReference())) {
                    index = i;
                    aux = true;
                }
            }
        }
        if (aux == true) {
            for (j = index; j < items.length - 1 && items[j] != null; j++) {
                items[j] = items[j + 1];
            }
            items[j] = null;

        } else {
            throw new ContainerExceptionImpl("Item nao encontrado");
        }
        return aux;
    }
     */
    @Override
    public boolean removeShipping(IShipping arg0) throws OrderExceptionImpl {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int clean() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate() throws OrderExceptionImpl, ContainerExceptionImpl, PositionExceptionImpl {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws OrderExceptionImpl, ContainerExceptionImpl, PositionExceptionImpl {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String summary() {
        String text = "ORDER" 
                + "Destination : " + destination + "\n"
                + "Customer : " + customer + "\n"
                + "ID : " + id + "\n"
                + "Year : " + year + "\n"
                + "Month : " + month + "\n"
                + "Day : " + day + "\n";
        return text;
    }

    @Override
    public int getNumberOfItems() {
        int tmp = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                tmp++;
            }
        }
        return tmp;
    }

    /**
     *
     * @return
     */
    @Override
    public int getNumberOfRemaingItemsToSend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public IItem[] getRemainingItemsToSend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
