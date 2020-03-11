package pp_fp04.exchange;

import com.company.Expenses;

public class CurrencyRates {
    public static double[][] TaxMatrix = new double[][]{{1.00000, 0.76900, 96.1141, 0.67131},
            {1.30030, 1.00000, 124.989, 0.87290},
            {96.06148, 125.00000, 1.00000, 143.26648}};

    private static double ValorDolar = 0;
    private static double ValorIene = 0;
    private static double ValorLibra = 0;
    private static double MediaDolar = 0;
    private static double MediaIene = 0;
    private static double MediaLibra = 0;
    public Expenses expenses;

    public void setValor(double ValorDolar, double ValorIene, double ValorLibra) {
        this.ValorDolar = ValorDolar;
        this.ValorIene = ValorIene;
        this.ValorLibra = ValorLibra;
    }

    public void setMedia(double MediaDolar, double MediaIene, double MediaLibra) {
        this.MediaDolar = MediaDolar;
        this.MediaIene = MediaIene;
        this.MediaLibra = MediaLibra;
    }

    public static void ConversaoValor() {
        ValorDolar = 0;
        ValorIene = 0;
        ValorLibra = 0;

        ValorDolar = Expenses.getSoma() * TaxMatrix[1][0];
        ValorIene = Expenses.getSoma() * TaxMatrix[1][2];
        ValorLibra = Expenses.getSoma() * TaxMatrix[1][3];
    }

    public static void ConversaoMedia() {
        MediaDolar = 0;
        MediaIene = 0;
        MediaLibra = 0;

        MediaDolar = Expenses.getMedia() * TaxMatrix[1][0];
        MediaIene = Expenses.getMedia() * TaxMatrix[1][2];
        MediaLibra = Expenses.getMedia() * TaxMatrix[1][3];
    }

    public static double getValorDolar() {
        return ValorDolar;
    }


    public static void setValorDolar(double ValorDolar) {
        CurrencyRates.ValorDolar = ValorDolar;
    }

    public static double getValorIene() {
        return ValorIene;
    }

    public static void setValorIene(double ValorIene) {
        CurrencyRates.ValorIene = ValorIene;
    }

    public static double getValorLibra() {
        return ValorLibra;
    }

    public static void setValorLibra(double ValorLibra) {
        CurrencyRates.ValorLibra = ValorLibra;
    }

    public static double getMediaDolar() {
        return MediaDolar;
    }

    public static void setMediaDolar(double MediaDolar) {
        CurrencyRates.MediaDolar = MediaDolar;
    }

    public static double getMediaIene() {
        return MediaIene;
    }

    public static void setMediaIene(double MediaIene) {
        CurrencyRates.MediaIene = MediaIene;
    }

    public static double getMediaLibra() {
        return MediaLibra;
    }

    public static void setMediaLibra(double MediaLibra) {
        CurrencyRates.MediaLibra = MediaLibra;
    }
}
