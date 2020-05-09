/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio5;

/**
 *
 * @author Samuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ContinentHipermarket cont1 = new ContinentHipermarket(2.55, 1.80, 20.2,
                0.50, "Continente", 123);
        JumbHipermarket jumb1 = new JumbHipermarket(1.50, 1.80, 2.50,
                0.50, "Jumbo 1", 4564);

        System.out.println("ContinentHipermarket 1: " + "\n" + cont1);
        System.out.println("Pontos de cont1: " + cont1.getPoints(80));
        System.out.println("--------------------");
        System.out.println("JumbHipermarket 1: " + "\n" + jumb1);
        System.out.println("Pontos de jumb1: " + jumb1.getPoints(20));
    }

}
