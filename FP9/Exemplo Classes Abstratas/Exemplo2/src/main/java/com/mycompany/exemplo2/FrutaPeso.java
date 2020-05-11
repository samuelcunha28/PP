package com.mycompany.exemplo2;

/**
 * Classe que representa uma fruta pelo peso (subclasse de fruta) e os seus metodos
 * @author Samuel
 */
public class FrutaPeso extends Fruta{
    /**
     * Variaveis de instancia de FrutaPeso
     */
    private double peso;
    
    /**
     * Construtor default de FrutaPeso
     */
    public FrutaPeso() {
        super();
        peso = 0.0;
    }
    
    /**
     * Construtor para FrutaPeso
     * @param nome nome da fruta
     * @param preco preco da fruta
     * @param peso peso da fruta
     */
    public FrutaPeso(String nome, double preco, double peso) {
        super(nome, preco);
        this.peso = peso;
    }
    
    /**
     * Construtor para FrutaPeso
     * @param fp 
     */
    public FrutaPeso(FrutaPeso fp) {
        super(fp.getNome(), fp.getPreco());
        peso = fp.getPeso();
    }
    
    /**
     * Getter para peso
     * @return peso
     */
    public double getPeso() {
        return peso;
    }
    
    /**
     * Setter para peso
     * @param np novo peso
     */
    public void setPeso(double np) {
        peso = np;
    }
    
    /**
     * Metodo abstrato herdado aPagar
     * @return peso * preco
     */
    public double aPagar() {
        return peso * this.getPreco();
    }
    
    /**
     * Metodo abstrato herdado toString
     * @return sb
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome = " + this.getNome() + "\n");
        sb.append("Preço Unid. = " + this.getPreco() + "\n");
        sb.append("Peso = " + peso + "\n");
        sb.append("A Pagar = " + this.aPagar() + "\n");
        return sb.toString();
    }
    
    /**
     * Metodo abstrato herdade clone
     * @return new FrutaPeso
     */
    public FrutaPeso clone() {
        return new FrutaPeso(this);
    }
}
