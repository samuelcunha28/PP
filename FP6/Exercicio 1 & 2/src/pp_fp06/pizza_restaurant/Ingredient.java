package pp_fp06.pizza_restaurant;

import pp_fp06.pizza_restaurant.enums.Ingredient_Type;

public class Ingredient {
    private String name;
    private int codigo;
    private Ingredient_Type origem;

    Ingredient() {
    }

    /**
     *
     * @param name
     * @param codigo
     * @param origem
     */
    public Ingredient(String name, int codigo, Ingredient_Type origem) {
        this.name = name;
        this.codigo = codigo;
        this.origem = origem;
    }

    /**
     *
     */
    public void print() {
        System.out.print(name);
        System.out.print(codigo);
        System.out.println(origem);
    }

    public String getName() {
        return name;
    }

    public int getCodigo() {
        return codigo;
    }

    public Ingredient_Type getOrigem() {
        return origem;
    }
}
