public enum TipoIngredient {
    /**
     *
     */
    ANIMAL,
    /**
     *
     */
    VEGETAL,
    /**
     *
     */
    MINERAL;

    /**
     * @param tipo
     * @return
     */
    public static String IngredientTypeToString(TipoIngredient tipo) {
        switch (tipo) {
            case ANIMAL:
                return "This Ingredient  origin is animal.";
            case VEGETAL:
                return "This Ingredient  origin is vegetal.";
            case MINERAL:
                return "This Ingredient  origin is mineral.";
            default:
                return "The origin is not valid";
        }
    }
}
