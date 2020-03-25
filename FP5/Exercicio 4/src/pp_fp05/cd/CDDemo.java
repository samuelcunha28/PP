package pp_fp05.cd;

public class CDDemo {

    public static void main(String[] args) {
        Authors[] a = {new Authors("John Doe", 30,"Not a seller"),
                       new Authors("John Smith", 31,"New york", 123456, 789101112, "Seller")};
        
        Authors[] b = {new Authors("Mike", 35,"Not a seller")};
        
        System.out.println("Número de autores criados :"+Authors.objcount);
        System.out.println("--------------------------------------------");
        if(Authors.objcount <= 5){
        } else {
            System.out.println("Remova Autores!!!!");
            return;
        }
        
        
        Tracks[] t = {new Tracks(1, "Ho Hey", 90), 
                      new Tracks(2, "Stubborn Love", 105)};
        
        t[0].author = a;
        t[1].author = b;
        
        CD cd = new CD("The Lumineers", 2012, "Dualtone Records", t, 49.99f);
        
        cd.printCDinfo();
    }
}