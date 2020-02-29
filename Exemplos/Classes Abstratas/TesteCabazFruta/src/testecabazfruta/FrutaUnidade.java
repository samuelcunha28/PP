/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testecabazfruta;

/**
 *
 * @author Samuel
 */
public class FrutaUnidade extends Fruta {
    private int quantidade;
    
    public FrutaUnidade() {
        super();
        quantidade = 0;
    }
    
    public FrutaUnidade(String nm, double preco, int quant) {
        super(nm, preco);
        this.quantidade = quant;
    }
    
    public FrutaUnidade(FrutaUnidade fu) {
        super(fu.getNome(), fu.getPreco());
        quantidade = fu.getQuant();
    }
    
    public int getQuant() {
        return quantidade;
    }
    
    public void setQuant(int qt) {
        quantidade = qt;
    }
    
    public double aPagar() {
        return quantidade * this.getPreco();
    }
    
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append("Nome = " + this.getNome() + "\n");
        txt.append("Preco Unid. = " + this.getPreco() + "\n");
        txt.append("Quantidade = " + quantidade + "\n");
        txt.append("A pagar = " + this.aPagar() + "\n");
        return txt.toString();
    }
    
    public FrutaUnidade clone() {
        return new FrutaUnidade(this);
    }
}
