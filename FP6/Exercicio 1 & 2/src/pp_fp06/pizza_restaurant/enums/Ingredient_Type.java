package pp_fp06.pizza_restaurant.enums;

public enum Ingredient_Type {
    ANIMAL, VEGETAL, MINERAL;

    public static String IngredientTypeToString(Ingredient_Type type) {
        switch (type) {
            case ANIMAL:
                return "This Ingredient is Animal Type";
            case VEGETAL:
                return "This Ingredient is Vegetal Type";
            case MINERAL:
                return "This Ingredient is Mineral Type";
            default:
                return "Not a valid Ingredient Type";
        }
    }
}
