package pp_fp05.store;

import java.util.Date;
import pp_fp05.cd.CD;

public class Sale {

    protected int saleID;
    protected Date date;
    CD[] cds;
    protected double finalPrice;

    Sale(int tempSaleID, Date tempDate, CD[] tempCds) {
        saleID = tempSaleID;
        date = tempDate;
        finalPrice = totalPrice(tempCds);
    }

    public void PrintSales() {
        System.out.println("SaleID : " + saleID);
        System.out.println("Sale date : " + date);

        for (CD cd : cds) {
            if (cd.price != 0.0) {
                System.out.println("Nome do CD: " + cd.name);
                System.out.println("Ano de lançamento: " + cd.year);
                System.out.println("Editora: " + cd.editor);
                System.out.println("Preco: " + cd.price + " €");
            } else {
                System.out.println("Nome do CD: " + cd.name);
                System.out.println("Ano de lançamento: " + cd.year);
                System.out.println("Editora: " + cd.editor);
                System.out.println("Preco: SEM PREÇO");
            }
        }
        System.out.println("Preco total: " + finalPrice);
    }


    public final double totalPrice(CD[] cds) {
        double result = 0;

        for (CD cd : cds) {
            result += cd.price;
        }
        return result;
    }
}