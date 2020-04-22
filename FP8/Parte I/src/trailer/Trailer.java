package trailer;

public class Trailer {
    // variaveis de instancia de trailer
    private int axesNumber = 2;
    private int load;

    // metodo construtor default de trailer
    public Trailer() {
    }

    // metodo construtor de trailer
    public Trailer(int axesNumber, int load) {
        this.axesNumber = axesNumber;
        this.load = load;
    }

    // TODOS GETTERS E SETTERS
    public int getAxesNumber() {
        return axesNumber;
    }

    public void setAxesNumber(int axesNumber) {
        this.axesNumber = axesNumber;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
}
