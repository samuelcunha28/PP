package OrderManagement;

import java.time.LocalDate;
import order.base.ICustomer;
import order.base.IPerson;
import Exceptions.*;
import order.management.IOrder;
import order.management.IShipping;
import order.packing.IItem;
import OrderManagement.Shipping;
import order.exceptions.ContainerException;
import order.exceptions.PositionException;
import order.management.ShipmentStatus;
import order.packing.IContainer;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
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
    private IShipping[] shipping = new IShipping[10];
    private ShipmentStatus status = ShipmentStatus.AWAITS_TREATMENT;
    private boolean isClosed = false;
    private int cost;
    private Date date;

    /**
     *
     * @param destination
     * @param customer
     * @param id
     * @param year
     * @param month
     * @param day
     */
    public Order(IPerson destination, ICustomer customer, int id, int year, int month, int day, int cost) {
        this.destination = destination;
        this.customer = customer;
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.cost = cost;
    }

    public Order(IPerson destination, ICustomer customer, int id, Date date) {
        this.destination = destination;
        this.customer = customer;
        this.id = id;
        this.date = date;
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

        for (int i = 0; i < shipping.length; i++) {
            if (shipping[i] != null) {
                tmp++;
            }
        }
        IShipping[] newItem = new IShipping[tmp];
        for (int i = 0; i < newItem.length; i++) {
            newItem[i] = shipping[i];
        }
        return newItem;
    }

    /**
     *
     * @param ship
     * @return
     * @throws OrderExceptionImpl
     */
    @Override
    public boolean addShipping(IShipping ship) throws OrderExceptionImpl {
        boolean aux = false;
        for (int i = 0; i < shipping.length; i++) {
            if (shipping[i] == null) {
                shipping[i] = ship;
                break;
            } else if (shipping[shipping.length - 1] != null) {
                aux = true;
            }
        }
        if (aux == true) {
            throw new OrderExceptionImpl("Sem posicoes disponiveis");
        }
        return aux;
    }

    /**
     *
     * @param ship
     * @return
     * @throws OrderExceptionImpl
     */
    @Override
    public boolean removeShipping(IShipping ship) throws OrderExceptionImpl {
        int index = 0;
        int j = 0;
        boolean aux = false;
        if (ship instanceof IShipping) {
            for (int i = 0; i < shipping.length; i++) {
                if (shipping[i] != null) {
                    index = i;
                    aux = true;
                }
            }
        }
        if (aux == true) {
            for (j = index; j < shipping.length - 1 && shipping[j] != null; j++) {
                shipping[j] = shipping[j + 1];
            }
            shipping[j] = null;

        } else {
            throw new OrderExceptionImpl("Shipping nao encontrado");
        }
        return aux;
    }

    /**
     *
     * @return
     */
    @Override
    public int clean() {
        int count = 0;
        if (status != ShipmentStatus.CANCELLED) {
           return 0;
        } else if (status == ShipmentStatus.CANCELLED) {
            for (int i = 0; i < shipping.length; i++) {
                if (shipping[i] != null) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 
     * @throws OrderExceptionImpl
     * @throws ContainerExceptionImpl
     * @throws PositionExceptionImpl
     * @throws ContainerException
     * @throws PositionException 
     */
    @Override
    public void validate() throws OrderExceptionImpl, ContainerExceptionImpl, PositionExceptionImpl, ContainerException, PositionException {
        for (int i = 0; i < shipping.length; i++) {
            if (shipping[i] != null) {
                shipping[i].validate();
            }
        }
        this.shipping = getShippings();
    }

    /**
     * 
     * @throws OrderExceptionImpl
     * @throws ContainerExceptionImpl
     * @throws PositionExceptionImpl 
     */
    @Override
    public void close() throws OrderExceptionImpl, ContainerExceptionImpl, PositionExceptionImpl {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que retorna "true" ou "false" para o caso da order esteja
     * fechada ou nao
     *
     * @return boolean 
     */
    @Override
    public boolean isClosed() {
        return isClosed;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String summary() {
        String text = "ORDER"
                + "Destination : " + destination + "\n"
                + "Customer : " + customer + "\n"
                + "ID : " + id + "\n"
                + "Year : " + year + "\n"
                + "Month : " + month + "\n"
                + "Day : " + day + "\n"
                + "Cost : " + cost + "\n";
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

    @Override
    public String toString() {
        return "Order{" + "destination=" + destination + ", customer=" + customer + ", id=" + id + ", year=" + year + ", month=" + month + ", day=" + day + ", items=" + items + '}';
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
