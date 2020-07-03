package exceptions;

public class PhoneManagerException extends Exception {

    public PhoneManagerException(String message) {
        super("Phone Manager error: " + message);
    }

}
