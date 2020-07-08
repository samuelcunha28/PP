/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderManagement;

import order.base.ICustomer;
import order.exceptions.OrderException;
import order.management.IManagement;
import order.management.IOrder;

/**
 *
 * @author samue
 */
public class Management implements IManagement {

    @Override
    public boolean add(IOrder arg0) throws OrderException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
