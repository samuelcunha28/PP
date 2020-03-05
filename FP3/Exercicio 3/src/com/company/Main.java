package com.company;

public class Main {

    public static void main(String[] args) {
        // matriz 4x3 previamente inicializada
        int[][] matriz = new int[][]{{1, 2, 3}, {3, 4, 4}, {4, 5, 6}, {6, 7, 8}};
        int[][] duplicados = {{0, 0, 0,}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int maior;
        int menor;
        int repetido = 0;
        int linha = 0;
        int coluna = 0;

        // print da matriz inicializada
        System.out.println("Matriz inicializada");
        for (int i = 0; i < 4; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }

        // calcular duplicados
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                for (int k = 0; k < matriz.length; k++) {
                    for (int l = 0; l < matriz[i].length; l++) {
                        if (matriz[i][j] == matriz[k][l]) {
                            duplicados[i][j] += 1;
                        }
                    }
                }
            }
        }
        System.out.println("");

        // print da quantidade de posições duplicadas
        System.out.println("Duplicados");
        for (int k = 0; k < 4; k++) {
            System.out.println("");
            for (int l = 0; l < 3; l++) {
                System.out.print(duplicados[k][l] + "\t");
            }
        }
        System.out.println("");

        // calculo do maior e menor de cada linha tal como o elemento mais repetido
        for (int i = 0; i < matriz.length; i++) {
            maior = matriz[i][0];
            menor = matriz[i][0];
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                }
                if (duplicados[i][j] > repetido) {
                    repetido = duplicados[i][j];
                    linha = i;
                    coluna = j;
                }
            }
            System.out.println("");
            System.out.println("Linha " + i);
            System.out.println("Maior: " + maior);
            System.out.println("Menor: " + menor);
        }

        System.out.println("");
        System.out.println("Mais repetido: " + matriz[linha][coluna]);
    }
}
