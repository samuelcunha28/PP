package OrderManagement;

import java.io.IOException;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.management.IOrder;
import order.management.IOrderImporter;
import org.json.simple.parser.ParseException;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class Import implements IOrderImporter {

    @Override
    public void importData(IOrder arg0, String arg1) throws IOException, ParseException, ContainerException, OrderException, PositionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
