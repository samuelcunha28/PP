package enums;

public enum MaterialType {
    /**
     * tipo de material: carbono
     */
    CARBON,

    /**
     * tipo de material: aluminio
     */
    ALUMINIUM;

    /**
     * Enum para tipo de material
     * @param tipo de material
     * @return material
     */
    public static String BrakeType(MaterialType tipo){

        switch(tipo){
            case CARBON:
                return "Material de carbono";
            case ALUMINIUM:
                return "Material de aluminio";
            default:
                return "Materiais Invalidos";
        }
    }
}
