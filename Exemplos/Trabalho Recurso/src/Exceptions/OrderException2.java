package Exceptions;

import order.exceptions.OrderException;
import order.management.IOrder;
        
/**
 * Class representing the exception scenarios related to {@link IOrder order contract} instantiation and management 
 * 
 * Nome: José Pedro Fernandes 
 * Número: 8190239 
 * Turma: LEI T4
 * 
 * Nome: Hugo Maia Alves
 * Número: 8160521
 * Turma: LEIT2
 * 
 */
public class OrderException2 extends OrderException {

    /**
     * Constructs an instance of {@link OrderException} with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public OrderException2(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of {@link OrderException} without detail message.
     */
    public OrderException2() {
        super();
    }
    
}
