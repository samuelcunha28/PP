package com.mycompany.exemplo2;

/**
 * Classe de teste
 *
 * @author Samuel
 */
public class TesteCabazFruta {

    public static void main(String[] args) {

        Cabaz cabaz = new Cabaz();

        cabaz.insereFruta(new FrutaUnidade("Papaia", 3.22, 2));
        cabaz.insereFruta(new FrutaUnidade("Meloa", 1.5, 2));
        cabaz.insereFruta(new FrutaPeso("Banana", 2.20, 2.5));
        cabaz.insereFruta(new FrutaPeso("Laranja", 2.70, 2.5));
        cabaz.insereFruta(new FrutaPeso("Manga", 3.70, 1.0));
        
        System.out.println("A Pagar: " + cabaz.valorTotal());
        System.out.println("Total fruta unidade: " + cabaz.valorTotaldoTipo("FrutaUnidade"));
    }
}
