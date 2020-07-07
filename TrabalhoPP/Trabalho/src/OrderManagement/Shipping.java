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

    private int orderID;
    private IPerson destination;
    private IContainer[] containers = new IContainer[10];
    private ICustomer customer;
    private ShipmentStatus status;
    private int count = 0;

    /**
     *
     * @param orderID
     * @param customer
     */
    public Shipping(int orderID, ICustomer customer) {
        this.orderID = orderID;
        this.customer = customer;
    }

    /**
     *
     * @param container
     * @return
     * @throws OrderExceptionImpl
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean addContainer(IContainer container) throws OrderExceptionImpl, ContainerExceptionImpl {
        boolean aux = false;
        if (status != ShipmentStatus.IN_TREATMENT) {
            throw new OrderExceptionImpl("Estado invalido");
        } else {
            if (container.isClosed()) {
                throw new ContainerExceptionImpl("O contentor " + container.getReference() + " ja existe/nao se encontra fechado");
            } else {
                for (int i = 0; i < containers.length; i++) {
                    if (containers[i] == null) {
                        containers[i] = container;
                        break;
                    } else if (containers[containers.length - 1] != null) {
                        aux = true;
                    }
                }
                if (aux) {
                    throw new ContainerExceptionImpl("O container nao tem posicoes disponiveis");
                }
            }
        }
        return aux;
    }

    /**
     *
     * @param container
     * @return
     * @throws OrderExceptionImpl
     * @throws ContainerExceptionImpl
     */
    @Override
    public boolean removeContainer(IContainer container) throws OrderExceptionImpl, ContainerExceptionImpl {
        int j, index = 0;
        boolean aux = false;
        if (status != status.IN_TREATMENT) {
            throw new OrderExceptionImpl("Estado invalido");
        } else {
            if (container instanceof IContainer) {
                for (int i = 0; i < containers.length; i++) {
                    if (containers[i] != null && containers[i].getReference().equals(container.getReference())) {
                        index = i;
                        aux = true;
                    }
                }
            }
            if (aux) {
                for (j = index; j < containers.length - 1 && containers[j] != null; j++) {
                    containers[j] = containers[j + 1];
                }
                containers[j] = null;
            } else {
                throw new ContainerExceptionImpl("O container nao foi encontrado");
            }
        }
        return aux;
    }

    /**
     *
     * @param container
     * @return
     */
    @Override
    public boolean existsContainer(IContainer container) {
        boolean aux = false;
        if (container instanceof IContainer) {
            for (int i = 0; i < containers.length; i++) {
                if (containers[i] != null && containers[i].getReference().equals(container.getReference())) {
                    aux = true;
                }
            }
        }
        return aux;
    }

    /**
     *
     * @param container
     * @return
     */
    @Override
    public IContainer findContainer(String container) {
        IContainer aux = null;
        for (int i = 0; i < this.count; i++) {
            if (container.equals(this.containers[i].getReference())) {
                aux = this.containers[i];
            }
        }
        return aux;
    }

    /**
     *
     * @return
     */
    @Override
    public ShipmentStatus getShipmentStatus() {
        return this.status;
    }

    /**
     *
     * @param status
     * @throws OrderExceptionImpl
     * @throws ContainerExceptionImpl
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
                    throw new ContainerExceptionImpl("Nao foram encontrados containers");
                }
                this.status = ShipmentStatus.CLOSED;
            } else if (status == ShipmentStatus.SHIPPED && this.status == ShipmentStatus.CLOSED) {
                this.status = ShipmentStatus.SHIPPED;
            } else {
                throw new OrderExceptionImpl("Erro no pedido. Pedido atual: " + this.status);
            }
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public IContainer[] getContainers() {
        int counter = 0;
        for (int i = 0; i < this.containers.length; i++) {
            if (this.containers[i] != null) {
                counter++;
            }
        }
        IContainer[] container = new IContainer[counter];
        for (int i = 0; i < containers.length; i++) {
            container[i] = containers[i];
        }
        return container;
    }

    /**
     * 
     * @throws ContainerExceptionImpl
     * @throws PositionExceptionImpl 
     */
    @Override
    public void validate() throws ContainerException, PositionException{
        for (int i = 0; i < containers.length; i++) {
            if (containers[i] != null) {
                containers[i].validate();
            }
        }
        this.containers = getContainers();
    }

    /**
     * 
     * @return 
     */
    @Override
    public String summary() {
        System.out.println("SHIPPING");
        
        String text = "ID: " + orderID + "\n"
                + "Customer: " + customer + "\n"
                + "Destination: " + destination + "\n"
                + "Containers: " + Arrays.toString(containers) + "\n"
                + "Order Status: " + status + "\n";
        return text;
    }

    @Override
    public double getCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
