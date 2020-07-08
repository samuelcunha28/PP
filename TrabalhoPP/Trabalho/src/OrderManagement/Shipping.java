package OrderManagement;

import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.management.*;
import order.packing.IContainer;
import order.base.*;
import order.management.ShipmentStatus;
import Exceptions.*;
import java.util.Arrays;

/**
 *
 * @author samue
 */
public class Shipping implements IShipping {

    private int orderId;
    private IPerson destination;
    private IContainer[] containers = new IContainer[10];
    private ShipmentStatus status = ShipmentStatus.AWAITS_TREATMENT;
    private ICustomer customer;
    private int count = 0;

    /**
     * Construtor de Shipping
     *
     * @param orderId
     * @param customer
     */
    public Shipping(int orderId, ICustomer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    /**
     * Verifica se o estado da order esta em tratamento. Se o mesmo nao estiver
     * em tratamento, nao esta pronto para ser adicionado Verifica se existe
     * espaço para adicionar o container ao array de containers
     *
     * @param con container a adicionar
     * @return boolean variavel auxiliar
     * @throws OrderExceptionImpl
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean addContainer(IContainer con) throws OrderExceptionImpl, ContainerExceptionImpl {
        boolean aux = false;
        if (status != ShipmentStatus.IN_TREATMENT) {
            throw new OrderExceptionImpl("Estado invalido! Nao se encontra em tratamento");
        } else {
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] == null) {
                    containers[i] = con;
                    break;
                } else if (containers[containers.length - 1] != null) {
                    aux = true;
                }
            }
            if (aux == true) {
                throw new ContainerExceptionImpl("Container sem posicoes disponiveis");
            }
        }
        return aux;
    }

    /**
     * Metodo que remove um container do array colocando a posicao eliminada a
     * null no final do array
     *
     * @param con container a remover
     * @return boolean variavel auxilar
     * @throws OrderExceptionImpl
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean removeContainer(IContainer con) throws OrderExceptionImpl, ContainerExceptionImpl {
        int index = 0;
        int j = 0;
        boolean aux = false;
        if (status != ShipmentStatus.IN_TREATMENT) {
            throw new OrderExceptionImpl("Order Status invalido");
        } else {
            if (con instanceof IContainer) {
                for (int i = 0; i < containers.length; i++) {
                    if (containers[i] != null && containers[i].getReference().equals(con.getReference())) {
                        index = i;
                        aux = true;
                    }
                }
            }
            if (aux == true) {
                for (j = index; j < containers.length - 1 && containers[j] != null; j++) {
                    containers[j] = containers[j + 1];
                }
                containers[j] = null;

            } else {
                throw new ContainerExceptionImpl("Item nao encontrado");
            }
        }
        return aux;
    }

    /**
     * Metodo que verifica se o container existe atraves da sua referencia
     *
     * @param con
     * @return boolean variavel auxiliar
     */
    @Override
    public boolean existsContainer(IContainer con) {
        boolean aux = false;
        if (con instanceof IContainer) {
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] != null && containers[i].getReference().equals(con.getReference())) {
                    aux = true;
                }
            }
        }
        return aux;
    }

    /**
     * Metodo que encontra um container atraves da sua referencia e retorna a
     * sua posicao do array de containers
     *
     * @param con
     * @return
     */
    @Override
    public IContainer findContainer(String con) {
        IContainer aux = null;
        for (int i = 0; i < this.count; i++) {
            if (con.equals(this.containers[i].getReference())) {
                aux = this.containers[i];
            }
        }
        return aux;
    }

    /**
     * Metodo que retorna a informacao sobre o destino
     *
     * @return destination
     */
    public IPerson getDestination() {
        return this.destination;
    }

    /**
     * Metodo que atribui/define o destino
     *
     * @param person
     */
    public void setDestination(IPerson person) {
        this.destination = person;
    }

    /**
     * Metodo que retorna o cliente
     *
     * @return customer
     */
    public ICustomer getCustomer() {
        return this.customer;
    }

    /**
     * Metodo que retorna o estado do envio
     *
     * @return status
     */
    @Override
    public ShipmentStatus getShipmentStatus() {
        return this.status;
    }

    /**
     * Metodo que retorna o ID da order
     *
     * @return orderId
     */
    public int getId() {
        return this.orderId;
    }

    /**
     * Metodo que define o estado do pedido: 
     * - Caso o estado do pedido seja "AWAITS_TREATMENT", o mesmo so pode ser 
     * alterado para "IN_TREATMENT" visto que nao faz sentido saltar estados 
     * - Caso o estado do pedido esteja "IN_TREATMENT", so pode ser alterado para 
     * "CLOSED" pelas mesmas razoes acima ditas. Caso seja encontrado o container, 
     * é corrido o metodo "validate()"
     * - Caso o estado do pedido seja "SHIPPED", so pode ser alterado para "CLOSED"
     * 
     *
     * @param status
     * @throws OrderExceptionImpl caso haja um erro na order ou nao seja 
     * compativel para mudanca de estado
     * @throws ContainerExceptionImpl caso nao seja encontrado nenhum container
     * no array
     * @throws PositionExceptionImpl
     */
    @Override
    public void setShipmentStatus(ShipmentStatus status) throws OrderExceptionImpl, ContainerExceptionImpl, PositionExceptionImpl, ContainerException, PositionException {
        int counter = 0;
        if (status instanceof ShipmentStatus) {
            if (status == ShipmentStatus.IN_TREATMENT && this.status == ShipmentStatus.AWAITS_TREATMENT) {
                this.status = ShipmentStatus.IN_TREATMENT;
            } else if (status == ShipmentStatus.CLOSED && this.status == ShipmentStatus.IN_TREATMENT) {
                for (int i = 0; i < this.containers.length; i++) {
                    if (this.containers[i] != null) {
                        counter++;
                    }
                }
                if (counter > 0) {
                    validate();
                } else if (counter == 0) {

                    throw new ContainerExceptionImpl("Nao foram encontrados containers no array");
                }
                this.status = ShipmentStatus.CLOSED;
            } else if (status == ShipmentStatus.SHIPPED && this.status == ShipmentStatus.CLOSED) {
                this.status = ShipmentStatus.SHIPPED;
            } else {
                throw new OrderExceptionImpl("Order Status ERROR, current OrderStatus: " + this.status);
            }

        }
    }

    /**
     * Metodo que cria um novo array de containers sem posicoes nulas
     *
     * @return con containers
     */
    @Override
    public IContainer[] getContainers() {
        int counter = 0;
        for (int i = 0; i < this.containers.length; i++) {
            if (this.containers[i] != null) {
                counter++;
            }
        }
        IContainer[] con = new IContainer[counter];
        for (int i = 0; i < con.length; i++) {
            con[i] = containers[i];
        }
        return con;
    }

    /**
     * Metodo que valida todas as posicoes do array que nao estejam nulas
     *
     * @throws ContainerException
     * @throws PositionException
     */
    @Override
    public void validate() throws ContainerException, PositionException {

        for (int i = 0; i < containers.length; i++) {
            if (containers[i] != null) {
                containers[i].validate();
            }
        }
        this.containers = getContainers();
    }

    /**
     * Metodo que obtem o custo do container
     * @return
     */
    @Override
    public double getCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * Pequeno sumario do interior da ShippingOrder
     * @return String
     */
    @Override
    public String summary() {
        return "ShippingOrder{" +
                "id=" + orderId +
                ", customer=" + customer +
                ", destination=" + destination +
                ", containers=" + Arrays.toString(containers) +
                ", orderStatus=" + status +
                '}';
    }
}
