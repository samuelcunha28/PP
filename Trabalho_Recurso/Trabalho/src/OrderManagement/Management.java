package OrderManagement;

import order.base.ICustomer;
import order.exceptions.OrderException;
import order.management.IManagement;
import order.management.IOrder;
import Exceptions.*;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class Management implements IManagement {

    private IOrder[] shippings= new IOrder[10];
    private IOrder order;

    public Management() {
    }
    
    /**
     * Construtor de Management
     * @param order order do tipo IOrder
     */
    public Management(IOrder order) {
        this.order = order;
    }
    
    /**
     * Metodo para adicionar uma order 
     * @param order order a ser adicionada do tipo IOrder
     * @return boolean test 
     * @throws OrderExceptionImpl e lancada a excecao caso a order nao exista  
     */
    @Override
    public boolean add(IOrder order) throws OrderExceptionImpl {
        boolean test = false;
        for (int i = 0; i < shippings.length; i++) {
            if (shippings[i] == null) {
                order = shippings[i];
                break;
            } else if (shippings[shippings.length - 1] != null) {
                test = true;
            }
        }
        if (test) {
            throw new OrderExceptionImpl("A order nao existe");
        }
        return test;
    }
    
    /**
     * Metodo que remove uma order
     * @param order order a ser removida do tipo IOrder
     * @return boolean test
     * @throws OrderException e lancada uma excecao caso a order nao exista
     */
    @Override
    public boolean remove(IOrder order) throws OrderException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param cust
     * @return 
     */
    @Override
    public IOrder[] getOrders(ICustomer cust) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public IOrder[] getOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
