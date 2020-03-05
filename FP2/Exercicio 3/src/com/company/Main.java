package com.company;

public class Main {

    public static void main(String[] args) {
        int[] lista = {12, 5, -21, 10, -345, 22, 50, -125, 80, -1};
        int multiplicacao = 1; // tem que ser 1 porque multiplicando por 0 dá sempre 0
        int negativos = 0;
        int maior = 0;
        int menor = 0;
        // Calcular resultados
        for (int i = 0; i < lista.length; i++ ) {
            // condição para multiplicar todos os positivos
            if (lista[i] > 0) {
                multiplicacao *= lista[i];
            }
            // condição para verificar o numero de negativos
            if (lista[i] < 0) {
                negativos++;
            }
            // condição para verificar o maior numero da lista
            if (lista[i] > maior) {
                maior = lista[i];
            }
            // condição para verificar o menor numero da lista
            if (lista[i] < menor) {
                menor = lista[i];
            }
        }
        System.out.println("Multiplicacao dos positivos: " + multiplicacao);
        System.out.println("Numero total de negativos: " + negativos);
        System.out.println("Maior numero da lista: " + maior);
        System.out.println("Menor numero da lista: " + menor);
    }
}