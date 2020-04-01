import java.time.LocalDateTime;

public class Ementa {
    private LocalDateTime date;
    private final int MAX_PIZZAS = 10;
    private static final int MAX_MENUS = 1;
    private Pizza[] pizzalist;
    private static int counter = 0;

    Ementa() {
    }

    private Ementa(Pizza[] pizzalist) {
        if (pizzalist.length > MAX_PIZZAS) {
            System.out.println("Maximo de Pizzas ultrapassado!!!");
        } else {
            for (int i = 0; i < pizzalist.length; i++) {
                for (int j = 0; j < pizzalist[i].getIngredients().length; j++) {
                    if (pizzalist[i].getIngredientsPos(i).getOrigem() == TipoIngredient.VEGETAL) {
                        this.pizzalist = pizzalist;
                        this.date = LocalDateTime.now();
                        counter += 1;
                    }
                }
            }
        }
    }

    public static Ementa returnInstance(Pizza[] pizzalist) {
        if (Ementa.counter < MAX_MENUS) {
            return (new Ementa(pizzalist));
        } else {
            System.out.println("Já existe uma ementa.");
            return null;
        }
    }

    public void printEmenta() {
        if (counter > 1) {
            System.out.println("PIZZAS DA EMENTA");
            System.out.println(date);

            for (Pizza pizzalist1 : pizzalist) {
                pizzalist1.PrintPizza();
            }
        } else {
            System.out.println("Nenhuma Pizza Vegetariana!!!");
        }

    }
}
