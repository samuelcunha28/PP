package Exceptions;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class TransportExceptionImpl {

    private String msg;

    /**
     * Creates a new instance of TransportExceptionImpl without detail message.
     */
    public TransportExceptionImpl() {
    }

    /**
     * Constructs an instance of TransportExceptionImpl with the specified detail message.
     *
     * @param msg specified message
     */
    public TransportExceptionImpl(String msg) {
        this.msg = msg;
    }
} 