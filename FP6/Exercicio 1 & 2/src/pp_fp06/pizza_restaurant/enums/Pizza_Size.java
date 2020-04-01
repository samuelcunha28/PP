package pp_fp06.pizza_restaurant.enums;

public enum Pizza_Size {
    SMALL, MEDIUM, BIG;

    public static String PizzaSizeToString(Pizza_Size size) {
        switch (size) {
            case SMALL:
                return "This Pizza is small size";
            case MEDIUM:
                return "This Pizza is medium size";
            case BIG:
                return "This Pizza is big size";
            default:
                return "Not a valid Pizza size";
        }
    }
}
