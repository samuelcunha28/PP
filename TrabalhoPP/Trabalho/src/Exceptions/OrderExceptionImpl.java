package Exceptions;

import order.exceptions.OrderException;

/**
 *
 * @author samue
 */
public class OrderExceptionImpl extends OrderException{

    public OrderExceptionImpl() {
    }

    public OrderExceptionImpl(String msg) {
        super(msg);
    }
    
    
}
