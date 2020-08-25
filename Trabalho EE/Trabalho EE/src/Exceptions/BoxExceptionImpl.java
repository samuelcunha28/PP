package Exceptions;
import exceptions.BoxException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class BoxExceptionImpl extends BoxException  {

    /**
     * Creates a new instance of BoxException without detail message.
     */
    public BoxExceptionImpl() {
    }

    /**
     * Constructs an instance of BoxException with the specified detail message.
     * 
     * @param msg specified message
     */
    public BoxExceptionImpl(String msg) {
        super(msg);
    }
} 