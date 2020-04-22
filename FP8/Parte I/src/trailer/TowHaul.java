package trailer;

import enums.TrailerType;

public class TowHaul extends Trailer {
    // variaveis de instancia de towhaul
    private TrailerType trailerType;

    // metodo construtor default de towhaul
    public TowHaul() {
    }

    // metodo construtor de towhaul
    public TowHaul(int axesNumber, int load, TrailerType trailerType) {
        super(axesNumber, load);
        this.trailerType = trailerType;
    }

    // TODOS GETTERS E SETTERS
    public TrailerType getTrailerType() {
        return trailerType;
    }

    public void setTrailerType(TrailerType trailerType) {
        this.trailerType = trailerType;
    }
}
