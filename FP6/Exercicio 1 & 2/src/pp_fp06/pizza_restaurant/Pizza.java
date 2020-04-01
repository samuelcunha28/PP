package pp_fp06.pizza_restaurant;

import pp_fp06.pizza_restaurant.enums.Pizza_Size;

import java.util.Arrays;

public class Pizza {
    /**
     * MAX_INGREDIENTS - numero maximo de ingredientes numa pizza
     * id - id da pizza
     * name - nome da pizza
     * description - descrição da pizza
     * numberOfIngredients - numero de ingredientes na pizza
     */
    private final int MAX_INGREDIENTS = 5;
    private int id;
    private String name;
    private String description;
    private Ingredient[] ingredients;
    private int numberOfIngredients;
    private float preco = 0;
    private Pizza_Size tamanho;

    /**
     * Método construtor para a criação de uma instância de {@link Pizza pizza}.
     *
     * @param id          Código que identifica uma <b>Pizza</b>
     * @param name        Nome da <b>Pizza</b>
     * @param description Descrição resumida da <b>Pizza</b>
     * @param tamanho         - tamanho da pizza
     */
    /*
    public Pizza(int id, String name, String description, PizzaSize tam) {
<<<<<<< HEAD
        numberOfIngredients = 0;
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = new Ingredient[MAX_INGREDIENTS];
        this.tamanho = tam;

    }*/

    public Pizza(int id, String name, String description, Pizza_Size tamanho) {
        numberOfIngredients = 0;
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = new Ingredient[MAX_INGREDIENTS];

        this.tamanho = tamanho;
        addPreco();
    }

    /**
     * @return o id da Pizza
     */
    public int getId() {
        return id;
    }

    /**
     * coloca o id da Pizza
     *
     * @param id - id da Pizza
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return o nome da Pizza
     */
    public String getName() {
        return name;
    }

    /**
     * coloca o nome da Pizza
     *
     * @param name - nome da Pizza
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return a descrição da Pizza
     */
    public String getDescription() {
        return ("A pizza " + this.getName() + " possui " + this.getNumberOfIngredients() + " ingredientes:" + Arrays.toString(this.ingredients));
    }

    /**
     * coloca a descrição da Pizza
     *
     * @param description - descrição da Pizza
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return o vetor de ingredientes da Pizza
     */
    public Ingredient[] getIngredients() {
        return ingredients;
    }

    /**
     * coloca o vetor de ingredientes da Pizza
     *
     * @param ingredients - vetor de ingredientes da Pizza
     */
    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
        this.numberOfIngredients = this.ingredients.length;
    }

    /**
     * @return o numero de ingredientes da Pizza
     */
    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    /**
     * coloca o numero de ingredientes da Pizza
     *
     * @param numberOfIngredients - numero de ingredientes da Pizza
     */
    public void setNumberOfIngredients(int numberOfIngredients) {
        this.numberOfIngredients = numberOfIngredients;
    }

    public float getPreco() {
        return preco;
    }

    public Pizza_Size getTamanho() {
        return tamanho;
    }

    public void setTamanho(Pizza_Size tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * metodo que vai adicionar um ingrediente à pizza
     *
     * @param ingrediente parametro recebido
     *                    primeiro if vai verificar se o numero de ingredientes é inferior ao numero maximo de ingredientes
     *                    caso seja, é adicionado o ingrediente
     *                    numero de ingredientes é incrementado
     */
    public void addIngrediente(Ingredient ingrediente) {
        if (numberOfIngredients < MAX_INGREDIENTS) {
            this.ingredients[numberOfIngredients] = ingrediente;
            this.numberOfIngredients++;
        } else {
            System.out.println("Ta cheia gordo!");
        }
    }

    /**
     * metodo que vai remover um ingrediente da Pizza
     *
     * @param id - paramentro recebido
     * @posicao - variavel inicializada a -1
     * primeiro for vai percorrer o vetor de ingredientes
     * primeiro if vai verificar se o codigo do ingrediente na posição i é igual ao id recebido
     * caso seja a variavel posicao vai guardar o indice i
     * segundo for vai percorrer o vetor de ingredientes a começar em posicao
     * vai puxar todos os elementos a partir de j 1 posição para trás
     * ultima posição do vetor fica null
     * numero de ingredientes é decrementado
     */
    public void removeIngrediente(int id) {
        int posicao = -1;
        for (int i = 0; i < this.numberOfIngredients; i++) {
            if (this.ingredients[i].getCodigo() == id) {
                posicao = i;
            }
        }
        for (int j = posicao; j < this.numberOfIngredients; j++) {
            this.ingredients[j] = this.ingredients[j + 1];
        }
        this.ingredients[numberOfIngredients] = null;
        numberOfIngredients--;
    }
    /*
    private void headPreco(){
        if(this.tamanho == PizzaSize.SMALL){
            this.preco = 3;
        }
        else{
            if(this.tamanho == PizzaSize.MEDIUM){
                this.preco = 6;
            }
            else{
                this.preco = 12;
            }
        }
    }*/

    private void addPreco() {
        float pequeno = 3;
        float medio = 6;
        float grande = 12;
        if (this.tamanho == Pizza_Size.SMALL) {
            this.preco = pequeno;
        }
        if (this.tamanho == Pizza_Size.MEDIUM) {
            this.preco = medio;
        }
        if (this.tamanho == Pizza_Size.BIG) {
            this.preco = grande;
        }

    }

    /**
     * metodo toString() vai printar todos os dados da pizza
     *
     * @return String com todas as informações da pizza
     */
    @Override
    public String toString() {
        String s = "";
        s += "ID: " + this.getId() + "\n";
        s += "Nome: " + this.getName() + "\n";
        s += "Descrição: " + this.description + "\n";
        s += "Tamanho: " + this.tamanho + "\n";
        s += "Nº de ingredientes: " + this.getNumberOfIngredients() + "\n";
        for (int i = 0; i < this.numberOfIngredients; i++) {
            s += ingredients[i].toString();
        }
        s += "Preço: " + this.getPreco();
        return s;
    }


}
