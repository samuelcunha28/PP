package Exceptions;

import order.exceptions.*;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class PositionExceptionImpl extends PositionException {

    public PositionExceptionImpl() {
    }

    /**
     * Metodo para envio da mensagem de excecao
     *
     * @param msg mensagem a ser enviada
     */
    public PositionExceptionImpl(String msg) {
        super(msg);
    }
}
