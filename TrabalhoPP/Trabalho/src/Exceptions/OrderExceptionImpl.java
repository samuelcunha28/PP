package Exceptions;

import order.exceptions.OrderException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class OrderExceptionImpl extends OrderException {

    public OrderExceptionImpl() {
    }

    /**
     * Metodo para envio da mensagem de excecao
     *
     * @param msg mensagem a ser enviada
     */
    public OrderExceptionImpl(String msg) {
        super(msg);
    }
}