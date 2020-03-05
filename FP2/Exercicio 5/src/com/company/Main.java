package com.company;

public class Main {

    public static void main(String[] args) {
        char[] nome = args[0].toCharArray();
        int i = 0;

        for (i = 4; i < nome.length; i++) {
            System.out.print(nome[i]);
        }
        System.out.print(",");
        for (i = 0; i < 4; i++) {
            System.out.print(nome[i]);
        }
    }
}
