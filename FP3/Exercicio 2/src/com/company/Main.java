package com.company;

public class Main {

    public static void main(String[] args) {
        int[] numeros = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < numeros.length; i++) {
            boolean Primo = true;
            // excluir o nº 1
            if (numeros[i] == 1) {
                Primo = false;
            }

            // neste ciclo começar a dividir por 2 porque por 1 dá sempre 0
            for (int j = 2; j < numeros[i]; j++) {
                // a condição irá dividir por todos os numeros abaixo do numero[i]
                if (numeros[i] % j == 0) {
                    Primo = false;
                    break;
                }
            }

            if(Primo) {
                System.out.println(numeros[i] + " é primo");
            } else {
                System.out.println(numeros[i] + " não é primo");
            }
        }
        System.out.println("");

        for (int i = 0; i < numeros.length; i++) {
            int a = 0;
            for (int k = 1; k < numeros[i]; k++) {
                // a condição irá somar os divisores em a
                if (numeros[i] % k == 0) {
                    a += k;
                }
            }
            // a condição irá avaliar se a for igual ao número, o número é perfeito
            if (a == numeros[i]) {
                System.out.println(numeros[i] + " é número perfeito");
            }
        }
    }
}
