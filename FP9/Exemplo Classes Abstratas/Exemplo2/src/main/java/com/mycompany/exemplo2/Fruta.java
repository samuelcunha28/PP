package com.mycompany.exemplo2;

/**
 * Classe que representa uma fruta e os seus metodos
 * @author Samuel
 */
public abstract class Fruta {
    /**
     * Variáveis de instância de fruta
     */
    private String nome;
    private double preco;
    
    /**
     * Construtor default de Fruta
     */
    public Fruta() {
        nome = "";
        preco = 0.0;
    }
    
    /**
     * Construtor de Fruta
     * @param nm nome da fruta
     * @param preco preco da fruta
     */
    public Fruta(String nm, double preco) {
        nome = nm;
        this.preco = preco;
    }

    /**
     * Getter para Nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter para preco
     * @return preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Setter para preco
     * @param nvPreco 
     */
    public void setPreco(double nvPreco) {
        this.preco = nvPreco;
    }
    
    /**
     * Metodo abstrato a pagar pela fruta
     * @return 
     */
    public abstract double aPagar();
    
    /**
     * Metodo abstrato para imprimir
     * @return 
     */
    public abstract String toString();
    
    /**
     * Metodo abstrato para clone
     * @return 
     */
    public abstract Fruta clone();
}
