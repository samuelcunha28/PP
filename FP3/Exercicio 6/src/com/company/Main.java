package com.company;

public class Main {

    public static void main(String[] args) {
        double Input = Double.parseDouble(args[0]);
        double valor, valor1, valor2;

        valor = Input / 100;
        valor1 = (int) valor;
        valor2 = Input % 100;

        System.out.print(valor1);
        System.out.print(" euros e ");
        System.out.print(valor2);
        System.out.print(" centimos ");
    }
}