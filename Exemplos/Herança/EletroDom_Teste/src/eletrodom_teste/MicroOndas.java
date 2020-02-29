package eletrodom_teste;

/**
 * @author Samuel
 * MicroOndas é um EletroDom especial que tem potência variável e um temporizador
 * de funcionamento
 */
public class MicroOndas extends EletroDom {
    // Variáveis de instância
    private int tempo;
    private int potAtual;
    
    // Construtores
    public MicroOndas() {
        super();
        tempo = 0;
        potAtual = 0;
    }
    
    public MicroOndas(String mk, int pot, boolean estado) {
        super(mk, pot, estado);
        tempo = 0;
        potAtual = 0;
    }
    
    public MicroOndas(MicroOndas micro) {
        super(micro.getMarca(), micro.getPotencia(), micro.getEstado());
        tempo = micro.getTempo();
        potAtual = micro.getPotAtual();
    }
    
    // Métodos de Instância 

    public int getTempo() {
        return tempo;
    }

    public int getPotAtual() {
        return potAtual;
    }
    
    public void aumentaPot(int val) {
        int potencia = this.getPotencia();
        int novoValor = potAtual + val;
        potAtual = (novoValor > potencia) ? potencia : novoValor;
    }
    
    public void diminuirPot(int val) {
        potAtual -= val;
    }
    
    public void ligar(int pot, int tmp) {
        super.ligar();
        potAtual = pot;
        tempo = tmp;
    }
    
    public int consumo() {
        return (this.getEstado() ? potAtual : 0);
    }
    
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append(super.toString());
        txt.append("Pot. Atual: ");
        txt.append(potAtual + "\n");
        txt.append("Tempo: " + tempo + "\n");
        return txt.toString();
    }
    
    public MicroOndas clone() {
        return new MicroOndas(this);
    }
}
