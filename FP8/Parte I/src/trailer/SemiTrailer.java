package trailer;

public class SemiTrailer extends Trailer {
    // variaveis de instancia de semitrailer
    private int spareTyreNumber;

    // metodo construtor default de semitrailer
    public SemiTrailer() {
    }

    // metodo construtor de semitrailer
    public SemiTrailer(int axesNumber, int load, int spareTyreNumber) {
        super(axesNumber, load);
        this.spareTyreNumber = spareTyreNumber;
    }

    // TODOS GETTERS E SETTERS
    public int getSpareTyreNumber() {
        return spareTyreNumber;
    }

    public void setSpareTyreNumber(int spareTyreNumber) {
        this.spareTyreNumber = spareTyreNumber;
    }
}
