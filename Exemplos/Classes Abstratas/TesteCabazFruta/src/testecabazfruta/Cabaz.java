package testecabazfruta;

/**
 *
 * @author Samuel
 */
public class Cabaz {

    public static int MAX_CAP = 100;

    private Fruta[] cabaz = new Fruta[MAX_CAP];
    private int total = 0;

    public void insereFruta(Fruta f) {
        if (total < MAX_CAP) {
            cabaz[total] = f.clone();
            total++;
        }
    }
    
    public double valorTotal() {
        double valor = 0.0;
        for(int i = 0; i < total; i++) {
            valor += cabaz[i].aPagar();
        }
        return valor;
    }

    public double valorTotaldoTipo(String tipoFruta) {
        double valor = 0.0;
        for (int i = 0; i < total; i++) {
            if (cabaz[i].getClass().getName().equals(tipoFruta)) {
                valor += cabaz[i].aPagar();
            }
        }
        return valor;
    }

    public int numTotaldoTipo(String tipoFruta) {
        int contador = 0;
        for (int i = 0; i < total; i++) {
            if (cabaz[i].getClass().getName().equals(tipoFruta)) {
                contador++;
            }
        }
        return contador;
    }
}
