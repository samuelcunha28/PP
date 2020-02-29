package testecabazfruta;

/**
 *
 * @author Samuel
 */
public class FrutaPeso extends Fruta{
    private double peso;
    
    public FrutaPeso() {
        super();
        peso = 0.0;
    }
    
    public FrutaPeso(String nome, double preco, double peso) {
        super(nome, preco);
        this.peso = peso;
    }
    
    public FrutaPeso(FrutaPeso fp) {
        super(fp.getNome(), fp.getPreco());
        peso = fp.getPeso();
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double newPeso) {
        peso = newPeso;
    }
    
    public double aPagar() {
        return peso * this.getPeso();
    }
    
    public String toString(){
        StringBuilder txt = new StringBuilder();
        txt.append("Nome = " + this.getNome() + "\n");
        txt.append("Preco Unid. = " + this.getPreco() + "\n");
        txt.append("Peso = " + peso + "\n");
        txt.append("A pagar = " + this.aPagar() + "\n");
        return txt.toString();
    }
    
    public FrutaPeso clone() {
        return new FrutaPeso(this);
    }
}
