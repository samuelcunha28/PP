package com.mycompany.exemplo2;

/**
 * Classe de manutenção de um cabaz
 * @author Samuel
 */
public class Cabaz {
    /**
     * Variavel de classe 
     */
    public static int MAX_CAP = 100;
    
    /**
     * Variaveis de instancia de Cabaz
     */
    private Fruta[] cabaz = new Fruta[MAX_CAP];
    private int total = 0;
    
    /**
     * Metodo para inserir fruta no array de frutas
     * @param f fruta
     */
    public void insereFruta(Fruta f) {
        if(total < MAX_CAP) {
            cabaz[total] = f.clone();
            total++;
        }
    }
    
    /**
     * Valor total a pagar pelas frutas
     * @return valor
     */
    public double valorTotal() {
        double valor = 0.0;
        for(int i = 0; i < total; i++) {
            valor += cabaz[i].aPagar();
        }
        return valor;
    }
    
    /**
     * Valor total a pagar do tipo de fruta
     * @param tipoFruta
     * @return valor
     */
    public double valorTotaldoTipo(String tipoFruta) {
        double valor = 0.0;
        for(int i = 0; i < total; i++) {
            if(cabaz[i].getClass().getName().equals(tipoFruta)) {
                valor += cabaz[i].aPagar();
            }
        }
        return valor;
    }
    
    /**
     * Numero total de frutas de tipo
     * @param tipoFruta
     * @return contador
     */
    public int numTotaldoTipo(String tipoFruta) {
        int contador = 0;
        for(int i = 0; i < total; i++) {
            if(cabaz[i].getClass().getName().equals(tipoFruta)) {
                contador++;
            }
        }
        return contador;
    }
}
