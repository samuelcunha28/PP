package Exceptions;

import order.exceptions.BoxException;
import order.packing.IBox;
/**
 * Class representing the exception scenarios related to {@link IBox Box contract} instantiation and management
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
public class BoxException2 extends BoxException {

    /**
     * Constructs an instance of {@link BoxException} with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public BoxException2(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of {@link BoxException} without detail message.
     */
    public BoxException2() {
        super();
    }
}
