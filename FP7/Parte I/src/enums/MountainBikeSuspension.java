package enums;

public enum MountainBikeSuspension {
    /**
     * suspensão simples
     */
    SIMPLE,
    /**
     * suspensão dupla
     */
    DOUBLE,
    /**
     * sem suspensão
     */
    SEM;

    /**
     * Enumeração para escolher suspension de BikeStore.MountainBike
     *
     * @param tipo de suspension
     * @return tipo de suspension
     */
    public static String MountainBikeSuspensionToString(MountainBikeSuspension tipo) {

        switch (tipo) {
            case SIMPLE:
                return "Suspensao simples";
            case DOUBLE:
                return "Suspensao dupla";
            default:
                return "Sem suspensão";
        }
    }
}
