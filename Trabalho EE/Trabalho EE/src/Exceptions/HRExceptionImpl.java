package Exceptions;
import exceptions.HRException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class HRExceptionImpl extends HRException {

    /**
     * Creates a new instance of HRException without detail message.
     */
    public HRExceptionImpl() {
    }

    /**
     * Constructs an instance of HRException with the specified detail message.
     *
     * @param message specified message
     */
    public HRExceptionImpl(String message) {
        super(message);
    }
}