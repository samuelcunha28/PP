package eletrodom_teste;

/**
 *
 * @author Samuel
 */

/**
 * EletroDom é uma classe que generaliza a informação e os métodos comuns aos 
 * vários eletrodomésticos que possuimos, por isso, não tem grandes 
 * particularidades
 */
public class EletroDom {
    private String marca;
    private int potencia;
    private boolean ligado;
    
    public EletroDom() {
        marca = "";
        potencia = 0;
        ligado = false;
    }
    
    public EletroDom(String mk, int pot, boolean estado) {
        marca = mk;
        potencia = pot;
        ligado = estado;
    }
    
    public EletroDom(EletroDom eletro) {
        marca = eletro.getMarca();
        potencia = eletro.getPotencia();
        ligado = eletro.getEstado();
    }
    
    // Métodos de instância
    public String getMarca() {
        return marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public boolean getEstado() {
        return ligado;
    }
    
    public void ligar() {
        ligado = true;
    }
    
    public void desligar() {
        ligado = false;
    }
    
    public int consumo() {
        return (ligado ? potencia : 0);
    }
    
    public void setPotencia(int npt) {
        potencia = npt;
    }
    
    public String toString() {
        StringBuilder txt = new StringBuilder("\nELETRO: \n");
        txt.append("Marca: ");
        txt.append(marca + "\n");
        txt.append("Potencia: ");
        txt.append(potencia + " watts\n");
        if (ligado) txt.append("ESTÁ LIGADO! \n");
        else txt.append("ESTÁ DESLIGADO! \n");
        return txt.toString();
    }
    
    public EletroDom clone() {
        return new EletroDom(this);
    }
}
