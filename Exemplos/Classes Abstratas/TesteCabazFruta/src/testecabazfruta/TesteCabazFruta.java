package testecabazfruta;

/**
 *
 * @author Samuel
 */
public class TesteCabazFruta {

    public static void main(String[] args) {

        Cabaz cabaz = new Cabaz();
        cabaz.insereFruta(new FrutaUnidade("Papaia", 3.22, 2));
        cabaz.insereFruta(new FrutaUnidade("Meloa", 1.50, 2));
        cabaz.insereFruta(new FrutaPeso("Banana", 2.20, 2.25));
        cabaz.insereFruta(new FrutaPeso("Laranja", 2.70, 2.5));
        cabaz.insereFruta(new FrutaPeso("Manga", 3.70, 1.0));
        cabaz.insereFruta(new FrutaPeso("Coco", 3.90, 2.0));
        System.out.println("A pagar: " + cabaz.valorTotal());
        System.out.println("Total fruta Unidade: " + cabaz.valorTotaldoTipo("FrutaUnidade"));
        System.out.println("A Peso: " + cabaz.numTotaldoTipo("FrutaPeso"));
    }
}
