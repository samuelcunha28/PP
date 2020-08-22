package Exceptions;

import order.exceptions.ContainerException;
import order.packing.IContainer;
/**
 * Class representing the exception scenarios related to {@link IContainer container contract} instantiation and management 
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
public class ContainerException2 extends ContainerException{
    
    /**
     * Constructs an instance of {@link ContainerException} with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public ContainerException2 (String msg){
        super(msg);
    }
    
    /**
     * Constructs an instance of {@link ContainerException} without detail message.
     */
    public ContainerException2() {
        super();
    }
    
}
