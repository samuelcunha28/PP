package com.company;

public class Expenses {
    // Despesas para o mes de Março
    private static final int NUMBER_OF_DAYS = 31;
    // Para despesas com o automóvel
    protected static int number1;
    /**
     * Vetor com o valor das despesas de automóvel durante o dia do mês
     * (o indice do vetor corresponde ao dia do mes)
     */
    protected static double[] carValues = new double[NUMBER_OF_DAYS];
    protected static char[] descriptionCar = new char[]{'C','A','R'};
    // Para despesas alimentares
    protected static int number2;
    protected static double[] foodValues = new double[NUMBER_OF_DAYS]; // Em euros
    protected static char[] descriptionFood = new char[]{'F','O','O','D'};
}

