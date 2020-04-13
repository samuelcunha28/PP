public class Pessoa {
    // variaveis de instancia de pessoa
    private String nome;
    private String date;
    private String morada;
    private int id;
    private int NIF;

    // construtor default de Pessoa
    public Pessoa() {
    }

    // construtor de Pessoa
    public Pessoa(String nome, String date, String morada, int id, int NIF) {
        this.nome = nome;
        this.date = date;
        this.morada = morada;
        this.id = id;
        this.NIF = NIF;
    }

    // TODOS GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    // metodo toString para imprimir
    public String toString() {
        String text = "Nome : " + nome + "\n"
                + "Data de nascimento : " + date + "\n"
                + "Morada : " + morada + "\n"
                + "Número de cartão de cidadão : " + id + "\n"
                + "Número de identificação fiscal : " + NIF + "\n";
        return text;
    }
}
