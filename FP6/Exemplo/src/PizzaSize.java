public enum PizzaSize {
    /**
     *
     */
    SMALL,

    /**
     *
     */
    MEDIUM,

    /**
     *
     */
    BIG;

    /**
     *
     * @param size
     * @return
     */
    public static String PizzaSizeToString(PizzaSize size){
        switch(size){
            case SMALL:
                return "This Pizza is small.";
            case MEDIUM:
                return "This Pizza is medium.";
            case BIG:
                return "This Pizza is big.";
            default:
                return "The size is not valid";
        }
    }
}
