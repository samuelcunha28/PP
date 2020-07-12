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
    
    public Management(IOrder order) {
        this.order = order;
    }

    
    /**
     * 
     * @param order
     * @return
     * @throws OrderExceptionImpl 
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
            throw new OrderExceptionImpl("Array sem posicoes disponiveis");
        }
        return test;
    }
    
    
    @Override
    public boolean remove(IOrder arg0) throws OrderException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IOrder[] getOrders(ICustomer arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IOrder[] getOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
