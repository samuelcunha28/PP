package Exceptions;

public class NonSupportedException extends Exception {
    /**
     * Excecao para ficheiros que nao sao suportados pelo Pod.PPod
     */
    public NonSupportedException(String m) {
        super(m);
    }
}
