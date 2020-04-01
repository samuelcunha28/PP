package pp_fp06.pizza_restaurant;

import pp_fp06.pizza_restaurant.enums.Ingredient_Type;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static pp_fp06.pizza_restaurant.enums.Ingredient_Type.VEGETAL;

public class Ementa {
    /**
     * MAX_PIZZAS varivel que define o numero maximo de pizzas de uma ementa
     * dataInicio data de inicio da ementa
     * dataFim data final da ementa
     * pizzas vetor de pizzas da ementa
     * numberOfPizzas numero de pizzas presentes na ementa
     * valida atributo que determina se a ementa é valida ou nao
     */
    private final int MAX_PIZZAS = 10;
    //private Date dataInicio;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Pizza[] pizzas;
    private int numberOfPizzas = 0;
    private boolean valida;

    /**
     *
     * @param dataFim data final da ementa
     * dataInicio é inicializada com a data de criação da ementa
     * A ementa não é valida por pre-definição
     */
    public Ementa(LocalDateTime dataFim) {
        this.dataFim = dataFim;
        this.dataInicio = this.dataInicio.now();
        this.pizzas = new Pizza[MAX_PIZZAS];
        this.valida = false;
    }

    /**
     *
     * @return o vetor das pizzas
     */
    public Pizza[] getPizzas() {
        return pizzas;
    }

    /**
     * coloca o vetor de pizzas na ementa
     * @param pizzas - vetor de pizzas
     */
    public void setPizzas(Pizza[] pizzas) {
        this.pizzas = pizzas;
    }

    /**
     *
     * @return o numero de pizzas
     */
    public int getNumberOfPizzas() {
        return numberOfPizzas;
    }

    /**
     * coloca o numero de pizzas na ementa
     * @param numberOfPizzas - numero de pizzas
     */
    public void setNumberOfPizzas(int numberOfPizzas) {
        this.numberOfPizzas = numberOfPizzas;
    }

    /**
     *
     * @return uma string com a dataInicial da ementa
     */
    public String getDataInicio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = this.dataInicio.format(formatter);
        return formattedDateTime;
    }

    /**
     * coloca a data inicial da ementa
     * @param dataInicio - dataInicial da ementa
     */
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     *
     * @return uma string com a dataFinal da ementa
     */
    public String getDataFim() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = this.dataFim.format(formatter);
        return formattedDateTime;
    }

    /**
     * coloca a dataFinal da ementa
     * @param dataFim - dat final da ementa
     */
    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    /**
     *
     * @return se é válida ou não
     */
    public boolean isValida() {
        return valida;
    }

    /**
     * Este metodo adiciona uma pizza à ementa
     * @param pizza pizza para adicionar à ementa
     * verifica a validação da ementa
     */
    public void addPizza(Pizza pizza){
        if(this.numberOfPizzas < MAX_PIZZAS){
            this.pizzas[numberOfPizzas] = pizza;
            this.numberOfPizzas++;
            this.validaEmenta();
        }
        else{
            System.out.println("ja nao cabe mais gordo!");
        }
    }

    /**
     * Este metodo remove uma pizza da ementa
     * @param id Id da pizza a remover
     * @pos é inicializada a -1
     * primeiro for vai percorrer o vetor das pizzas da ementa
     * primeiro if vai verificar se o id da pizza na posição i é igual ao id recebido
     * caso seja, a variavel pos vai guardar o indice i
     * segundo for vai percorrer o vetor das pizzas da ementa e vai passar a pizza na posição j+1 para a posição j, até ao fim do vetor
     * a ultima posição do vetor passa a null
     * o numero de pizzas é decrementado
     * verifica a validação da ementa
     */
    public void removePizza(int id){
        int pos = -1;
        for(int i=0; i<this.numberOfPizzas; i++){
            if(this.pizzas[i].getId() == id){
                pos = i;
            }
        }
        for(int j=pos; j<this.numberOfPizzas; j++){
            this.pizzas[j] = this.pizzas[j+1];
        }
        this.pizzas[this.numberOfPizzas] = null;
        this.numberOfPizzas--;
        this.validaEmenta();
    }

    /**
     * Este método vai verificar se a ementa é válida ou não, e caso seja o atributo válida passa a true
     * @contAnimal - contador que vai guardar o numero de ingredientes de origem animal de cada pizza
     * primeiro for vai percorrer o vetor de pizzas da ementa
     * segundo for vai percorrer os ingredientes de cada pizza
     * primeiro if vai verificar se a origem do ingrediente na posição j da pizza na posição i, é animal
     * se for de origem animal, incrementa a variavel contAnimal
     * segundo if vai verificar se o contAnimal for igual a 0, entao é porque existe uma pizza vegetariana, validando a ementa
     * @contAnimal volta a 0
     */
    public void validaEmenta(){
        int contAnimal = 0;
        for(int i=0; i<this.numberOfPizzas; i++){
            for(int j=0; j<this.pizzas[i].getNumberOfIngredients(); j++){
                if(this.pizzas[i].getIngredients()[j].getOrigem() == Ingredient_Type.ANIMAL){
                    contAnimal++;
                }
            }
            if(contAnimal == 0){
                this.valida = true;
            }
            else{
                this.valida = false;
            }
            contAnimal = 0;
        }
    }


    /**
     * metodo toString() vai imprimir todos os dados da ementa na tela
     * @return uma string com todas as informações da ementa
     */
    @Override
    public String toString() {
        String s = "";
        s+="Data inicial: " + this.getDataInicio() + "\n";
        s+="Data Final: " + this.getDataFim() + "\n";
        s+="Nº de pizzas: " + this.getNumberOfPizzas() + "\n";
        for(int i=0; i<numberOfPizzas; i++){
            s+="Pizza: " + pizzas[i].toString();
        }
        return s;
    }
}
