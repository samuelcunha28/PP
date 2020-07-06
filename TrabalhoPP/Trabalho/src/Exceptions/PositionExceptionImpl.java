package Exceptions;

import order.exceptions.*;

/**
 *
 * @author samue
 */
public class PositionExceptionImpl extends PositionException {

    public PositionExceptionImpl() {
    }

    public PositionExceptionImpl(String msg) {
        super(msg);
    }
}