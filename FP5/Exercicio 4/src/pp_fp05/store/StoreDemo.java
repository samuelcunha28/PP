package pp_fp05.store;

import java.util.Calendar;
import java.util.GregorianCalendar;
import pp_fp05.cd.CD;
import pp_fp05.cd.Tracks;

public class StoreDemo {

    public static void main(String[] args) {
        
        Tracks[] t = {new Tracks(1, "Ho Hey", 90), 
                      new Tracks(2, "Stubborn Love", 105)};

        CD[] cd1 = {new CD("The Lumineers", 2009, "Dualtone Records", t, 15.99f),
                    new CD("The Bros", 1998, "Dualtone Records", t, 14.0f),
                    new CD("T-series", 1999, "Dualtone Records", t, 4.99f)};
        
        CD[] cd2 = {new CD("The Lumineers", 2009, "Dualtone Records", t, 15.99f),
                    new CD("The Niggaz", 2018, "Dualtone Records", t, 100.98f)};
        
 
        Sale[] sales = {new Sale(1, new GregorianCalendar(2020, Calendar.MARCH,25).getTime(),cd1),
                        new Sale(2, new GregorianCalendar(2020, Calendar.MARCH,24).getTime(),cd2)};
        
        sales[0].cds = cd1;
        sales[1].cds = cd2;
        
        for (Sale sale : sales) {
            sale.PrintSales();
        }
    }
}
