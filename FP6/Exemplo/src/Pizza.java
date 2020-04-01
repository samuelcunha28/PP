public class Pizza {
    private final int MAX_INGREDIENTS = 5;
    private int id;
    private String name;
    private String description;
    private Ingredient[] ingredients;
    private Ingredient[] ingredientsPos;
    private int numberOfIngredients;
    private PizzaSize size;

    /**
     * Método construtor para a criação de uma instância de {@link Pizza pizza}.
     *
     * @param id Código que identifica uma <b>Pizza</b>
     * @param name Nome da <b>Pizza</b>
     * @param description Descrição resumida da <b>Pizza</b>
     */
    Pizza() {
    }

    /**
     *
     * @param id
     * @param name
     * @param description
     */
    public Pizza(int id, String name, String description) {
        numberOfIngredients = 0;
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     *
     * @param id
     * @param name
     * @param numberOfIngredients
     * @param description
     * @param array
     */
    public Pizza(int id, String name, int numberOfIngredients, String description, Ingredient[] array) {

        if (numberOfIngredients != 0 && numberOfIngredients <= MAX_INGREDIENTS) {
            this.ingredients = array;
            this.id = id;
            this.name = name;
            this.description = description;
            this.numberOfIngredients = numberOfIngredients;
        } else {
            System.out.println("Erro nos Ingredientes");
        }

    }

    /**
     *
     * @param id
     * @param name
     * @param description
     * @param array
     * @param numberOfIngredients
     * @param size
     */
    public Pizza(int id, String name, String description, Ingredient[] array, int numberOfIngredients, PizzaSize size) {
        if (numberOfIngredients != 0 && numberOfIngredients <= MAX_INGREDIENTS) {
            this.size = size;
            this.ingredients = array;
            this.id = id;
            this.name = name;
            this.description = description;
            this.numberOfIngredients = numberOfIngredients;
        } else {
            System.out.println("Erro nos Ingredientes");
        }
    }

    public Pizza(int id, String name, Ingredient[] array, int numberOfIngredients, PizzaSize size) {
        if (numberOfIngredients != 0 && numberOfIngredients <= MAX_INGREDIENTS) {
            this.size = size;
            this.ingredients = array;
            this.id = id;
            this.name = name;
            this.numberOfIngredients = numberOfIngredients;
        } else {
            System.out.println("Erro nos Ingredientes");
        }
    }

    /**
     *
     */
    public void PrintPizza() {

        System.out.println("");
        System.out.println(name);
        System.out.println(size);
        System.out.println(id);
        System.out.println(description);
        System.out.println(numberOfIngredients);

        for (Ingredient ingredient : ingredients) {
            //System.out.println(ingredient);
            ingredient.print();
        }

    }

    public String getDescription() {

        description = " ";
        description += "A pizza " + name + " tem ";
        description += numberOfIngredients + " Ingredientes : \n";

        for (Ingredient ingredient : ingredients) {
            description += ingredient.getName() + " ";
            description += ingredient.getCodigo() + " ";
            description += ingredient.getOrigem() + "\n";
        }

        return description;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    public void setNumberOfIngredients(int numberOfIngredients) {
        this.numberOfIngredients = numberOfIngredients;
    }

    public void removerIngrediente(int id) {
        int[] positions = new int[ingredients.length];
        int found = 0;

        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i].getCodigo() == id) {
                positions[i] = 1;
                found += 1;
            }
        }

        if (found > 0) {
            Ingredient[] tmp = new Ingredient[ingredients.length - found];
            int tmpPosition = 0;

            for (int i = 0; i < positions.length; i++) {
                if (positions[i] == 0) {
                    tmp[tmpPosition] = ingredients[i];
                    tmpPosition += 1;
                }
            }

            this.ingredients = tmp;
        } else {
            System.out.println("Não foi encontrado.");
        }

    }

    public Ingredient getIngredientsPos(int i) {

        ingredientsPos = ingredients;

        return ingredientsPos[i];
    }
}
