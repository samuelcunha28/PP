package OrderManagement;

import order.base.ICustomer;
import order.management.IManagement;
import order.management.IOrder;
import Exceptions.*;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class Management implements IManagement {

    private IOrder[] shippings = new IOrder[10];
    private IOrder order;

    public Management() {
    }

    /**
     * Construtor de Management
     *
     * @param order order do tipo IOrder
     */
    public Management(IOrder order) {
        this.order = order;
    }

    /**
     * Metodo para adicionar uma order
     *
     * @param order order a ser adicionada do tipo IOrder
     * @return boolean test
     * @throws OrderExceptionImpl e lancada a excecao caso a order nao exista
     */
    @Override
    public boolean add(IOrder order) throws OrderExceptionImpl {
        boolean test = false;
        for (int i = 0; i < shippings.length; i++) {
            if (shippings[i] == null) {
                order = shippings[i];
                break;
            } else if (shippings[shippings.length - 1] != null) {
                test = true;
            }
        }
        if (test) {
            throw new OrderExceptionImpl("A order nao existe");
        }
        return test;
    }

  
    /**
     * Metodo que remove uma order
     *
     * @param order order a ser removida do tipo IOrder
     * @return boolean test
     * @throws OrderExceptionImpl e lancada uma excecao caso a order nao exista
     */
    @Override
    public boolean remove(IOrder order) throws OrderExceptionImpl {
        int index = 0;
        int j = 0;
        boolean aux = false;
        if (order instanceof IOrder) {
            for (int i = 0; i < shippings.length; i++) {
                if (shippings[i] != null) {
                    index = i;
                    aux = true;
                }
            }
        }
        if (aux == true) {
            for (j = index; j < shippings.length - 1 && shippings[j] != null; j++) {
                shippings[j] = shippings[j + 1];
            }
            shippings[j] = null;

        } else {
            throw new OrderExceptionImpl("Item nao encontrado");
        }
        return aux;
    }
     
    /**
     * Metodo que cria um novo array de order, buscando as sem posicoes nulas
     * @return
     */
    @Override
    public IOrder[] getOrders() {
        int counter = 0;
        for (int i = 0; i < this.shippings.length; i++) {
            if (this.shippings[i] != null) {
                counter++;
            }
        }
        IOrder[] ord = new IOrder[counter];
        for (int i = 0; i < ord.length; i++) {
            ord[i] = shippings[i];
        }
        return ord;
    }

    @Override
    public IOrder[] getOrders(ICustomer arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
