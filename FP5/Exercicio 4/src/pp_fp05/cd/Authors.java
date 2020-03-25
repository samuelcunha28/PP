package pp_fp05.cd;

public class Authors {
    
    public String name;
    public int age;
    public String address;
    public int NIF;
    public int NIB;
    public String authortype;
    public static int objcount = 0;
    
    public Authors(String tempName, int tempAge, String tempAddress, int tempNIF, int tempnib, String tempAuthorType ){
        
        name = tempName;
        age = tempAge;
        address = tempAddress;
        NIF = tempNIF;
        NIB = tempnib;
        authortype = tempAuthorType;
        objcount++;
    }
    
    public Authors(String tempName, int tempAge, String tempAuthorType){
        name = tempName;
        age = tempAge;
        authortype = tempAuthorType;
        objcount++;
    }
    
    public void authorPrint(){
        if ("Seller".equals(authortype)){
            System.out.println("Nome do autor: "+name);
            System.out.println("Idade: "+age);
            System.out.println("Morada: "+address);
            System.out.println("NIF: "+NIF);
            System.out.println("NIB: "+NIB);
            System.out.println("Tipo de autor: "+authortype);
        } else {
            System.out.println("Nome do autor: "+name);
            System.out.println("Idade: "+age);
            System.out.println("Tipo de autor: "+authortype);
        }
    }
}