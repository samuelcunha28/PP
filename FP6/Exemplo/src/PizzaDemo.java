public class PizzaDemo {

    public static void main(String[] args) {
        Ingredient[] Inglist1 = {new Ingredient("Tomate", 12, TipoIngredient.VEGETAL),
                new Ingredient("Chouriças", 16, TipoIngredient.ANIMAL),
                new Ingredient("Cenoura", 12, TipoIngredient.ANIMAL),
                new Ingredient("Queijo", 13, TipoIngredient.ANIMAL)};

        Ingredient[] Inglist2 = {new Ingredient("Tomate", 12, TipoIngredient.ANIMAL),
                new Ingredient("Chouriças", 16, TipoIngredient.ANIMAL)};

        Ingredient[] Inglist3 = {new Ingredient("Alface", 18, TipoIngredient.VEGETAL),
                new Ingredient("Couves", 17, TipoIngredient.VEGETAL)};

        Pizza p1 = new Pizza(1, "Pizza Samuel", "Eu fiz a pizza", Inglist1, 4, PizzaSize.BIG);
        Pizza p2 = new Pizza(2, "Pizza Jorge", "O Jorge fez a Pizza", Inglist2, 2, PizzaSize.MEDIUM);
        Pizza p3 = new Pizza(3, "Macarena", Inglist3, 2, PizzaSize.BIG);

        Pizza[] Pizzalist1 = {new Pizza(1, "Pizza Jorge", "O jorge e um grande pizzeiro", Inglist1, 4, PizzaSize.BIG),
                new Pizza(2, "Pizza Jorge", "O Jorge fez a Pizza", Inglist2, 2, PizzaSize.MEDIUM)};

        Ementa ementa1 = Ementa.returnInstance(Pizzalist1);

        ementa1.printEmenta();

    }
}
