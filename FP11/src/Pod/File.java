package Pod;

public class File {
    /**
     * variaveis de instancia de Pod.File
     */
    private String nome;
    private String extention = "mp3";
    private double size;
    private int duracao;

    /**
     * Construtor default de Pod.File
     */
    public File() {
        this.nome = null;
        this.extention = null;
        this.size = 0;
        this.duracao = 0;
    }

    /**
     * Contrutor de Pod.File
     * @param nome nome do ficheiro
     * @param extention extensao do ficheiro (mp3 ou outro)
     * @param size tamanho do ficheiro
     * @param duracao duracao do ficheiro
     */
    public File(String nome, String extention, double size, int duracao) {
        this.nome = nome;
        this.extention = extention;
        this.size = size;
        this.duracao = duracao;
    }

    /**
     * Getter para Nome
     * @return nome do ficheiro
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter para nome
     * @param nome nome do ficheiro
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter para extensao
     * @return extensao do ficheiro
     */
    public String getExtention() {
        return extention;
    }

    /**
     * Setter para extensao
     * @param extention extensao do ficheiro
     */
    public void setExtention(String extention) {
        this.extention = extention;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Getter para duracao
     * @return duracao do ficheiro
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Setter para duracao
     * @param duracao duracao do ficheiro
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * Metodo toString para imprimir
     * @return texto a imprimir
     */
    @Override
    public String toString() {
        String text =  "Nome: " + nome + "\n";
        text += "Duracao: " + duracao + "\n";
        return text;
    }
}
