package OrderManagement;

import com.google.gson.Gson;
import java.io.FileReader;
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

    private String filePath = "import.json";

    public Import() {
    }
    
    /**
     * Metodo que ira importar um ficheiro json para uma determinada order
     * 
     * @param order order a ser importada
     * @param filePath caminho do ficheiro importado
     * @throws IOException
     * @throws ParseException
     * @throws ContainerException
     * @throws OrderException
     * @throws PositionException 
     */
    @Override
    public void importData(IOrder order, String filePath) throws IOException, ParseException, ContainerException, OrderException, PositionException {

        FileReader fr = new FileReader(filePath);
        int i;
        System.out.println("Formato JSON importado com sucesso para o ficheiro: " + filePath);
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
        fr.close();
    }
}