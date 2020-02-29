package testecabazfruta;

/**
 *
 * @author Samuel
 */
public abstract class Fruta {
    private String nome;
    private double preco;
    
    public Fruta() {
        nome = "";
        preco = 0.0;
    }
    
    public Fruta(String nm, double preco) {
        this.nome = nm;
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double nvPreco) {
        preco = nvPreco;
    }
    
    public abstract double aPagar();
    public abstract String toString();
    public abstract Fruta clone();
}
