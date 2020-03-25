package pp_fp05.cd;

public class Author {
    protected String name;
    protected int age;
    protected String address;
    protected int NIF;
    protected int NIB;
    protected String authorType;
    protected static int objcount = 0;

    public Author(String tempName, int tempAge, String tempAddress, int tempNIF, int tempNIB, String tempAuthorType) {
        this.name = tempName;
        this.age = tempAge;
        this.address = tempAddress;
        this.NIF = tempNIF;
        this.NIB = tempNIB;
        this.authorType = tempAuthorType;
        objcount++;
    }

    public Author(String tempName, int tempAge, String tempAuthorType){
        name = tempName;
        age = tempAge;
        authorType = tempAuthorType;
        objcount++;
    }

    public void authorPrint(){
        if ("Seller".equals(authorType)){
            System.out.println("Nome do autor: "+name);
            System.out.println("Idade: "+age);
            System.out.println("Morada: "+address);
            System.out.println("NIF: "+NIF);
            System.out.println("NIB: "+NIB);
            System.out.println("Tipo de autor: "+authorType);
        } else {
            System.out.println("Nome do autor: "+name);
            System.out.println("Idade: "+age);
            System.out.println("Tipo de autor: "+authorType);
        }
    }
}
