/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio6;

/**
 *
 * @author Samuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ContinentHipermarket Cont1 = new ContinentHipermarket(2.55, 1.80, 20.2,
                0.50, "Continente", 123);
        JumbHipermarket jumb1 = new JumbHipermarket(1.50, 1.80, 2.50,
                0.50, "Jumbo 1", 4564);

        //System.out.println(Cont1.getPoints(80));
        //System.out.println(jumb1.getPoints(80));

        /**
         * Usa a data atual do pc e compara quem da mais pontos
         */
        System.out.println("Mais pontos: ");
        Hipermarket.verifyPoints(80,jumb1,Cont1);

        GasStation g1 = new GasStation(1.80,"Station 1", "1", 123);
        GasStation g2 = new GasStation(1.20,"Station 2", "2", 124);
        GasStation g3 = new GasStation(1.15,"Station 3", "3", 125);
        GasStation g4 = new GasStation(1.40,"Station 4", "4", 126);
        GasStation g5 = new GasStation(1.50,"Station 5", "5", 127);

        System.out.println("Gasolina mais barata: ");
        GasStation group[] = {g1, g2, g3, g4, g5};
        Hipermarket hgroup[] = {Cont1 , jumb1};

        GasStation gf = GasStation.verify(group);
        System.out.println(gf.toString());

        System.out.println("Cabaz mais barato: ");
        Hipermarket gh = Hipermarket.compararCabaz(hgroup,12.5,10.0,5);
        System.out.println(gh.toString());
    }

}
