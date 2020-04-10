package enums;

public enum BrakeType {
    /**
     * tipo de travão: pinças
     */
    CALIPERS,

    /**
     * tipo de travão: hidraulico
     */
    HYDRAULIC;

    /**
     * Enum para tipo de Travoes
     * @param tipo de break
     * @return break
     */
    public static String BrakeType(BrakeType tipo){

        switch(tipo){
            case CALIPERS:
                return "Travões de Pinças";
            case HYDRAULIC:
                return "Travões de Hidraulicas";
            default:
                return "Travões Invalidos";
        }
    }
}
