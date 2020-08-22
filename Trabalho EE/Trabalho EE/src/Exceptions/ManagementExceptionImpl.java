package Exceptions;
import exceptions.ManagementException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class ManagementExceptionImpl extends ManagementException {

    /**
     * Creates a new instance of ManagementException without detail message.
     */
    public ManagementExceptionImpl() {
    }

    /**
     * Constructs an instance of ManagementException with the specified detail message.
     *
     * @param msg specified message
     */
    public ManagementExceptionImpl(String msg) {
        super(msg);
    }
}