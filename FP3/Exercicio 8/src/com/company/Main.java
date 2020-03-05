package com.company;

public class Main {

    public static void main(String[] args) {
        double m = Double.parseDouble(args[0]);
        double umEuro = 0;
        double doisEuro = 0;
        double Cinqucent = 0;

        while (m != 0) {
            if (m >= 2) {
                m -= 2;
                doisEuro += 1;
            } else if (m >= 1) {
                m -= 1;
                umEuro += 1;
            } else if (m >= 0.50) {
                m -= 0.50;
                Cinqucent += 1;
            }
        }
        System.out.print(doisEuro + " moedas de dois euros ");
        System.out.print(umEuro + " moedas de um euros ");
        System.out.print(Cinqucent + " moedas de cinquenta centimos ");
    }
}