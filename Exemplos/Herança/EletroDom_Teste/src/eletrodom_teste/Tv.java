package eletrodom_teste;

/**
 * @author Samuel
 * Tv é uma classe que representa um EletroDom especial que tem alguns atributos
 * e funções de uma televisão
 */
public class Tv extends EletroDom {
    // Variáveis de instância
    private int canal;
    private int volume;
    private int ecra;
    
    // Construtores
    public Tv() {
        super();
        canal = 1;
        volume = 5;
        ecra = 0;
    }
    
    public Tv(String mk, int pot, boolean estado, int canal, int vol, int tam) {
        super(mk, pot, estado);
        this.canal = canal;
        this.volume = vol;
        this.ecra = tam;
    }
    
    public Tv (Tv tv) {
        super(tv.getMarca(),tv.getPotencia(), tv.getEstado());
        canal = tv.getCanal();
        volume = tv.getVolume();
        ecra = tv.getDimEcra();
    }
    
    // Métodos de instância

    public int getCanal() {
        return canal;
    }

    public int getVolume() {
        return volume;
    }

    public int getDimEcra() {
        return ecra;
    }
    
    public void aumentaVol(int val) {
        volume += val;
    }
    
    public void diminuiVol(int val) {
        volume -= val;
    }
    
    public void mudarCanal(int chan) {
        canal = chan;
    }
    
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append(super.toString());
        txt.append("Canal: " + canal + "\n");
        txt.append("Volume: " + volume + "\n");
        txt.append("Ecra: " + ecra + "\n");
        return txt.toString();
    }
    
    public Tv clone() {
        return new Tv(this);
    }
}

