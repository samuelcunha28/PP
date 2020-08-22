package Exceptions;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
*/
public class DeliveryExceptionImpl extends DeliveryException {

    private String msg;

    /**
     * Creates a new instance of DeliveryExceptionImpl without detail message.
     */
    public DeliveryExceptionImpl() {
    }

    /**
     * Constructs an instance of DeliveryExceptionImpl with the specified detail message.
     *
     * @param msg specified message
     */
    public DeliveryExceptionImpl(String msg) {
        this.msg = msg;
    }
}