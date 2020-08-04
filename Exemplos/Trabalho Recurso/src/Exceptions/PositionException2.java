package Exceptions;

import order.exceptions.PositionException;
import order.packing.IPosition;

/**
 * Class representing the exception scenarios related to {@link IPosition postion contract} instantiation and management 
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
public class PositionException2 extends PositionException{
    
    /**
     * Constructs an instance of {@link PositionException} with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public PositionException2(String msg){
        super(msg);
    }
    
    /**
     * Constructs an instance of {@link PositionException} without detail message.
     */
    public PositionException2() {
        super();
    }
}
