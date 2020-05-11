package com.mycompany.exemplo2;

/**
 * Classe que representa uma fruta à unidade (sublclasse de fruta) e os seus metodos
 * @author Samuel
 */
public class FrutaUnidade extends Fruta {
    /**
     * Variaveis de instância de FrutaUnidade
     */
    private int quantidade;
    
    /**
     * Construtor default de FrutaUnidade
     */
    public FrutaUnidade() {
        super();
        quantidade = 0;
    }
    
    /**
     * Construtor para FrutaUnidade
     * @param nm nome da fruta
     * @param preco preco da fruta
     * @param quant quantidade de fruta
     */
    public FrutaUnidade(String nm, double preco, int quant) {
        super(nm, preco);
        quantidade = quant;
    }
    
    /**
     * Construtor para FrutaUnidade
     * @param fu 
     */
    public FrutaUnidade(FrutaUnidade fu) {
        super(fu.getNome(), fu.getPreco());
        quantidade = fu.getQuant();
    }
    
    /**
     * Getter para quantidade
     * @return quantidade
     */
    public int getQuant() {
        return quantidade;
    }
    
    /**
     * Setter para quantidade
     * @param qt quantidade
     */
    public void setQuant(int qt) {
        quantidade = qt;
    }
    
    /**
     * Metodo abstrato herdado a Pagar
     * @return quantidade * preco
     */
    public double aPagar() {
        return quantidade * this.getPreco();
    }
    
    /**
     * Metodo abstrato herdado toString
     * @return sb
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome = " + this.getNome() + "\n");
        sb.append("Preço Unid. = " + this.getPreco() + "\n");
        sb.append("Quantidade = " + quantidade + "\n");
        sb.append("A Pagar = " + this.aPagar() + "\n");
        return sb.toString();
    }
    
    /**
     * Metodo abstrato herdado clone
     * @return  new FrutaUnidade
     */
    public FrutaUnidade clone() {
        return new FrutaUnidade(this);
    }
}
