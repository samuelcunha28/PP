package Management_Implementation;

import Exceptions.OrderException2;
import Person_Implementation.Customer;
import order.base.ICustomer;
import order.exceptions.OrderException;
import order.management.IManagement;
import order.management.IOrder;
import order.packing.IContainer;

/**
 * This class implements {@link IManagement}.
 *
 * Nome: José Pedro Fernandes 
 * Número: 8190239 
 * Turma: LEI T4
 *
 * Nome: Hugo Maia Alves
 * Número: 8160521
 * Turma: LEIT2
 * 
 */
public class Management implements IManagement {

    /**
     * Represents the price per cubic volume unit.
     */
    private final static double CUBICPRICE = 0.50;

    /**
     * Represents the management's orders.
     */
    private IOrder[] orders;

    /**
     * The total number of orders.
     */
    private int totalOfOrders;

    /**
     * Getter of the constant {@link Management#CUBICPRICE CUBICPRICE}.
     * 
     * @return The {@link Management#CUBICPRICE CUBICPRICE}.
     */
    protected static double getCubicPrice(){
        return Management.CUBICPRICE;
    }
    
    /**
     * Creates an instance of <code>Management</code>.
     */
    public Management(){
        this.orders = new IOrder[2];
    }
    
    /**
     * Adds a new {@link IOrder order} to the {@link IManagement order manager}.
     * 
     * @param iorder {@link IOrder order} to be added
     * @return 
        {@link Boolean#TRUE true} if the {@link IOrder order} is inserted.
        {@link Boolean#FALSE false} if the {@link IOrder order} already exists in the {@link IContainer container}.

     * @throws OrderException if {@link IOrder order} is null.
     */
    @Override
    public boolean add(IOrder iorder) throws OrderException {
        if (iorder == null) {
            throw new OrderException2("Null parameter");
        }

        if (this.totalOfOrders != 0) {
            for (IOrder order : this.getOrders()) {
                if (order.equals(iorder)) {
                    return false;
                }
            }
        }
        if (this.totalOfOrders == this.orders.length) {
            IOrder[] clone = this.orders;
            this.orders = new IOrder[this.totalOfOrders * 2];

            for (int i = 0; i < this.totalOfOrders; i++) {
                this.orders[i] = clone[i];
            }
        }
        this.orders[this.totalOfOrders] = iorder;
        this.totalOfOrders++;

        return true;
    }

    /**
     * Removes an {@link IOrder order} from the {@link IManagement order manager}
     * 
     * @param iorder {@link IOrder order} to be removed
     * @return 
        {@link Boolean#TRUE true} if the {@link IOrder order} is removed.
        {@link Boolean#FALSE false} if the {@link IOrder order} does't exists.
     * @throws OrderException if: the parameter is null.
     */
    @Override
    public boolean remove(IOrder iorder) throws OrderException {
        if (iorder == null) {
            throw new OrderException2("Null parameter");
        }
        for (int i = 0; i < this.totalOfOrders; i++) {

            if (iorder.equals(this.orders[i])) {

                for (; i < this.totalOfOrders - 1; i++) {
                    this.orders[i] = this.orders[i + 1];
                }

                this.orders[i] = null;
                this.totalOfOrders--;

                return true;
            }
        }

        return false;
    }
    
     /**
     * Gets the number of {@link Management#orders} of a certain {@link ICustomer customer}.
     * 
     * @param customer {@link ICustomer customer} to search for.
     * @return The number of {@link Management#orders orders} for a certain {@link ICustomer customer}.
     */
    private int getNumberOfOrdersPerCustumer(ICustomer customer){
        int numberOfOrders = 0;
        
        for(IOrder order : this.orders){
            if(order.getCustomer().equals((Customer)customer)){
                numberOfOrders++;
            }
        }
        return numberOfOrders;
    }

     /**
     * Gets the Management's {@link Management#orders orders} of a certain {@link ICustomer customer}.
     * 
     * @param customer {@link ICustomer customer} to search for.
     * @return The {@link Management#orders orders} for a certain {@link ICustomer customer}.
     */
    @Override
    public IOrder[] getOrders(ICustomer customer) {
        int k = 0;
        
        IOrder[] custumerOrders = new IOrder[this.getNumberOfOrdersPerCustumer(customer)];
        
        for(int i = 0;i < this.totalOfOrders;i++){
            if(this.orders[i].getCustomer().equals(customer)){
                custumerOrders[k] = this.orders[i];
                k++;
            }
        }
        
        return custumerOrders;
    }

    /**
     * Getter of the attribute {@link Management#orders orders} with no null positions.
     * 
     * @return Management's {@link Management#orders orders} without null positions.
     */
    @Override
    public IOrder[] getOrders() {
        IOrder[] ordersCopy = new IOrder[this.totalOfOrders];
        for (int i = 0; i < this.totalOfOrders; i++) {
            ordersCopy[i] = this.orders[i];
        }
        return ordersCopy;
    }

}
