package Exceptions;
import exceptions.PositionException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class PositionExceptionImpl extends PositionException {

    /**
     * Creates a new instance of PositionException without detail message.
     */
    public PositionExceptionImpl() {
    }

    /**
     * Constructs an instance of PositionException with the specified detail message.
     *
     * @param msg specified message
     */
    public PositionExceptionImpl(String msg) {
        super(msg);
    }
} 