package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] listaA = {2, -5, -121, 102, -35, -2, 0, -125, 802, -10};
        int[] listaB = {6, 99, -1, 12, 1, -2};
        int duplicados = 0;

        // Unir os dois vetores em um vetor
        int[] listaC = IntStream.concat(Arrays.stream(listaA), Arrays.stream(listaB)).toArray();
        int L = listaC.length;

        // Elementos repetidos no vetor resultante
        for (int i = 0; i <= listaC.length; i++) {
            for (int j = i + 1; j < listaC.length; j++) {
                if (listaC[i] == listaC[j] && i != j) {
                    duplicados++;
                }
            }
        }
        // Imprimir o vetor resultante
        System.out.println(Arrays.toString(listaC));
        System.out.println("Numero de elementos repetidos no vetor: " + duplicados);
        }
}