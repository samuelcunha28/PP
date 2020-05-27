package Exceptions;

public class FullMemoryException extends Exception {
    /**
     * Exception customizada para caso a memoria esteja cheia
     */
    public FullMemoryException(String m) {
        super(m);
    }
}
