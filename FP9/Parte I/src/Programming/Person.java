package Programming;

public class Person {
    // variaveis de instância de Person
    private String name;
    private String date;
    private String address;
    private int citizenCard;
    private int vatNumber;
    private double baseSalary;

    // contrutor default de Person
    public Person() {
    }

    // construtor de Person
    public Person(String name, String date, String address, int citizenCard, int vatNumber, double baseSalary) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.citizenCard = citizenCard;
        this.vatNumber = vatNumber;
        this.baseSalary = baseSalary;
    }

    // GETTERS E SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCitizenCard() {
        return citizenCard;
    }

    public void setCitizenCard(int citizenCard) {
        this.citizenCard = citizenCard;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // metodo toString para imprimir
    public String toString() {
        String text = "Nome : " + name + "\n"
                + "Data de nascimento : " + date + "\n"
                + "Morada : " + address + "\n"
                + "Número cartão de cidadão : " + citizenCard + "\n"
                + "NIF : " + vatNumber + "\n"
                + "Salário base : " + baseSalary + "\n";
        return text;
    }
}
