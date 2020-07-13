package OrderManagement;

import java.time.LocalDate;
import order.base.ICustomer;
import order.base.IPerson;
import Exceptions.*;
import order.management.IOrder;
import order.management.IShipping;
import order.packing.IItem;
import order.exceptions.ContainerException;
import order.exceptions.PositionException;
import order.management.ShipmentStatus;

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
     * Construtor de Order
     *
     * @param destination destino da order do tipo IPerson
     * @param customer cliente da order do tipo ICustomer
     * @param id id da order (inteiro)
     * @param date data da order (tipo Date)
     * @param cost custo da order (inteiro)
     */
    public Order(IPerson destination, ICustomer customer, int id, Date date, int cost) {
        this.destination = destination;
        this.customer = customer;
        this.id = id;
        this.date = date;
        this.cost = cost;
    }

    /**
     * Metodo para obter o destino da order
     *
     * @return destino do tipo IPerson
     */
    @Override
    public IPerson getDestination() {
        return this.destination;
    }

    /**
     * Metodo para atribuir o destino da order
     *
     * @param destination destino a atribuir do tipo IPerson
     */
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
     * Metodo para atribuir o cliente
     *
     * @param customer do tipo ICustomer
     */
    @Override
    public void setCustomer(ICustomer customer) {
        this.customer = customer;
    }

    /**
     * Metodo para obter todos os itens da order
     *
     * @return items
     */
    @Override
    public IItem[] getItems() {
        int aux = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                aux++;
            }
        }
        IItem[] newItems = new IItem[aux];
        for (int i = 0; i < newItems.length; i++) {
            newItems[i] = items[i];
        }
        return newItems;
    }

    /**
     * Metodo que atribui o id da order
     *
     * @param id id a atribuir (inteiro)
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para retornar o id da order
     *
     * @return id da order
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Metodo para atribuir a data da order
     *
     * @param year ano da order
     * @param month mes da order
     * @param day dia da order
     */
    @Override
    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Metodo para obter a data
     *
     * @return data atual
     */
    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }

    /**
     * Metodo para adicionar um item à order
     *
     * @param item item a ser adicionado a order do tipo IItem
     * @return variavel auxiliar
     * @throws OrderExceptionImpl caso nao haja posicoes suficientes e lancada a
     * excecao
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
     * Metodo para obter os envios da order
     *
     * @return variavel auxiliar com os itens
     */
    @Override
    public IShipping[] getShippings() {
        int aux = 0;

        for (int i = 0; i < shipping.length; i++) {
            if (shipping[i] != null) {
                aux++;
            }
        }
        IShipping[] newItems = new IShipping[aux];
        for (int i = 0; i < newItems.length; i++) {
            newItems[i] = shipping[i];
        }
        return newItems;
    }
    
    /**
     * Metodo que retorna o numero de itens da order
     * @return variabel auxiliar com o numero de itens
     */
    @Override
    public int getNumberOfItems() {
        int aux = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                aux ++;
            }
        }
        return aux ;
    }

    /**
     * Metodo para adicionar um envio a order
     *
     * @param ship envio a ser enviado
     * @return variavel auxiliar
     * @throws OrderExceptionImpl caso nao haja posicoes livres para adicionar o
     * envio, e lancada uma excecao
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
     * Metodo para remover um envio da order
     *
     * @param ship envio a ser removido
     * @return variavel auxiliar
     * @throws OrderExceptionImpl caso nao seja encontrado o envio a ser
     * excluido
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
     * Metodo que retorna o numero de envios que sejam cancelados
     * 
     * @return variavel auxiliar contador
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
     * Metodo que verifica se a order e valida para envio
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
     * Metodo que "fecha" a order
     * @throws OrderExceptionImpl
     * @throws ContainerExceptionImpl
     * @throws PositionExceptionImpl
     */
    @Override
    public void close() throws OrderExceptionImpl, ContainerExceptionImpl, PositionExceptionImpl, ContainerException, PositionException {
        validate();
        isClosed = true;
    }

    /**
     * Metodo que retorna "true" ou "false" para o caso da order esteja fechada
     * ou nao
     *
     * @return boolean
     */
    @Override
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * Metodo para atribuir o custo da order
     * @param cost custo da order (inteiro)
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Metodo que retorna o custo da order
     * @return custo da order (double)
     */
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
