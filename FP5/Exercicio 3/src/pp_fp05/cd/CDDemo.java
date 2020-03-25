package pp_fp05.cd;

public class CDDemo {

    public static void main(String[] args) {
        Author[] author1 = {new Author("John Doe", 30, "Not a seller"),
                new Author("John Smith", 31, "New york", 123456, 789101112, "Seller")};

        Author[] author2 = {new Author("Mike", 35, "Not a seller")};

        System.out.println("Número de autores criados :" + Author.objcount);
        System.out.println("--------------------------------------------");
        if (Author.objcount <= 5) {
        } else {
            System.out.println("Remova Autores!!!!");
            return;
        }


        Track[] t = {new Track(1, "Ho Hey", 90),
                new Track(2, "Stubborn Love", 105)};

        t[0].author = author1;
        t[1].author = author2;

        CD cd = new CD("The Lumineers", 2012, "Dualtone Records", t);

        cd.printCDinfo();
    }
}