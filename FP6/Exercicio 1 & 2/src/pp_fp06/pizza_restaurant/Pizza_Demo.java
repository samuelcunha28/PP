package pp_fp06.pizza_restaurant;

import pp_fp06.pizza_restaurant.enums.Ingredient_Type;
import pp_fp06.pizza_restaurant.enums.Pizza_Size;

import java.time.LocalDateTime;
import java.time.Month;

import static pp_fp06.pizza_restaurant.enums.Ingredient_Type.ANIMAL;
import static pp_fp06.pizza_restaurant.enums.Ingredient_Type.VEGETAL;

public class Pizza_Demo {

    public static void main(String[] args) {

        //instancia dos ingredientes da pizza1
        Ingredient ingrediente1 = new Ingredient("Massa", 1, Ingredient_Type.ANIMAL);
        Ingredient ingrediente2 = new Ingredient("Tomate", 2, Ingredient_Type.VEGETAL);
        Ingredient ingrediente3 = new Ingredient("Queijo", 3, Ingredient_Type.VEGETAL);

        //instancia dos ingredientes da pizza2
        Ingredient ingrediente4 = new Ingredient("Pimento", 4, Ingredient_Type.VEGETAL);
        Ingredient ingrediente5 = new Ingredient("Ananás", 5, Ingredient_Type.VEGETAL);
        Ingredient ingrediente6 = new Ingredient("Coentros", 6, Ingredient_Type.VEGETAL);

        //Instancia da pizza1
        Pizza pizza1 = new Pizza(1, "Celeste", "Boa!", Pizza_Size.BIG);
        //Instancia da pizza2
        Pizza pizza2 = new Pizza(2, "Havaiana", "Muito boa!", Pizza_Size.MEDIUM);

        //adiciona ingredientes à pizza1
        pizza1.addIngrediente(ingrediente1);
        pizza1.addIngrediente(ingrediente2);
        pizza1.addIngrediente(ingrediente3);
        //adiciona ingredientes à pizza2
        pizza2.addIngrediente(ingrediente4);
        pizza2.addIngrediente(ingrediente5);
        pizza2.addIngrediente(ingrediente6);

        System.out.println(pizza1.getPreco());

        //remove o ingrediente de ID 2 da pizza1
        pizza1.removeIngrediente(2);
        //print da descrição e ingredientes da pizza1
        System.out.println(pizza1.getDescription());

        //print de todas as informações da pizza1
        System.out.println(pizza1.toString());

        //print da descrição e ingredientes da pizza2
        System.out.println(pizza2.getDescription());

        //instancia da data dinal da ementa
        LocalDateTime dataFinalEmenta = LocalDateTime.of(2019, Month.MARCH, 30, 11, 30);

        //Instancia da ementa1
        Ementa ementa1 = new Ementa(dataFinalEmenta);

        //adiciona as pizzas à ementa1
        ementa1.addPizza(pizza1);
        ementa1.addPizza(pizza2);

        //verificar se a ementa1 é válida
        ementa1.validaEmenta();
        System.out.println(ementa1.isValida());

        //remove a pizza de id 2 da ementa
        ementa1.removePizza(2);

        //print de todas as informações da ementa
        System.out.println(ementa1.toString());
    }
}

