package com.company;

public class Main {

    public static void main(String[] args) {
	    int[][] matrizA = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
	    int[][] matrizB = new int[3][3];

	    // imprimir a matriz A
	    for (int i = 0; i < 3; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrizA[i][j] + "\t");
            }
        }
	    // atribuir os valores da matriz transposta para a matriz B
	    for (int i = 0; i < 3; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                matrizB[j][i] = matrizA[i][j];
            }
        }

        // imprimir a matriz B (matriz transposta)
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrizB[i][j] + "\t");
            }
        }
    }
}
