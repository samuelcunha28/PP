package com.company;

public class Main {

    public static void main(String[] args) {
        char[] nome = {'A', 'n', 'a', ' ', 'S', 'a', 'n', 't', 'o', 's', '\n'};
        int vogais = 0;
        int consoantes = 0;

        // ciclo para imprimir apelido
        for (int i = 4; i < nome.length - 1; i++) {
            System.out.print(nome[i]);
        }
        System.out.print(",");
        // ciclo para imprimir nome
        for (int i = 0; i < nome.length - 8; i++) {
            System.out.print(nome[i]);
        }
        System.out.println("");
        // condição para verificar o número de vogais e consoantes
        for (int i = 0; i < nome.length; i++) {
            if(nome[i] == 'A' || nome[i] == 'a' || nome[i] == 'o' ) {
                vogais++;
            } else {
                consoantes++;
            }
        }
        System.out.println("Numero de vogais: " + vogais);
        System.out.println("Numero de consoantes: " + (consoantes -2)); // tirar 2 por causa do espaço e \n
    }
}
