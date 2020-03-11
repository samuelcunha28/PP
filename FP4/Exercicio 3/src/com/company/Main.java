package com.company;

import pp_fp04.exchange.CurrencyRates;

public class Main {
    static User user1;

    public static void main(String[] args) {
        System.out.println("Valores de Cambio");
        for (int i = 0; i < CurrencyRates.TaxMatrix.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < CurrencyRates.TaxMatrix[i].length; j++) {
                System.out.print((CurrencyRates.TaxMatrix[i][j]) + "\t" + "\t");
            }
        }
        user1.id[0] = 'A';
        user1.id[1] = 'B';
        user1.id[2] = 'C';
        user1.name = new char[]{'B', 'r', 'u', 'n', 'o'};
        user1.email = new char[]{'b', 'm', 'o', '@', 'e', 's', 't', 'g',
                'f', '.', 'i', 'p', 'p', '.', 'p', 't'};

        user1.expenses.setCarValues(100.99, 0);
        user1.expenses.setCarValues(200.99, 2);
        user1.expenses.setCarValues(140.99, 3);
        user1.expenses.setCarValues(101.50, 6);
        user1.expenses.setNumber1(4);

        user1.expenses.setFoodValues(10, 0);
        user1.expenses.setFoodValues(20, 1);
        user1.expenses.setFoodValues(30, 2);
        user1.expenses.setFoodValues(40, 3);
        user1.expenses.setNumber2(4);

        char[] carro = new char[]{'M', 'e', 'r', 'c', 'e', 'd', 'e', 's'};
        user1.expenses.setDescriptionCar(carro);

        user1.expenses.costCar();
        CurrencyRates.ConversaoValor();
        CurrencyRates.ConversaoMedia();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------User 1------------");
        System.out.println("Total Despesas carro: ");
        System.out.println("Em Euros: " + user1.expenses.getSoma() + " â‚¬");
        System.out.println("Em Dolar: " + CurrencyRates.getValorDolar() + " $");
        System.out.println("Em Iene: " + CurrencyRates.getValorIene() + " Ienes");
        System.out.println("Em Libras: " + CurrencyRates.getValorLibra() + " Â£");

        System.out.println(" ");

        System.out.println("Medias Despesas carro: ");
        System.out.println("Em Euros: " + user1.expenses.getMedia() + " â‚¬");
        System.out.println("Em Dolar: " + CurrencyRates.getMediaDolar() + " $");
        System.out.println("Em Iene: " + CurrencyRates.getMediaIene() + " Ienes");
        System.out.println("Em Libras: " + CurrencyRates.getMediaLibra() + " Â£");

        System.out.println(" ");

        user1.expenses.costFood();
        CurrencyRates.ConversaoValor();
        CurrencyRates.ConversaoMedia();

        System.out.println("Total Despesas comida: ");
        System.out.println("Em Euros: " + user1.expenses.getSoma() + " â‚¬");
        System.out.println("Em Dolar: " + CurrencyRates.getValorDolar() + " $");
        System.out.println("Em Iene: " + CurrencyRates.getValorIene() + " Ienes");
        System.out.println("Em Libras: " + CurrencyRates.getValorLibra() + " Â£");

        System.out.println(" ");

        System.out.println("Medias Despesas comida: ");
        System.out.println("Em Euros: " + user1.expenses.getMedia() + " â‚¬");
        System.out.println("Em Dolar: " + CurrencyRates.getMediaDolar() + " $");
        System.out.println("Em Iene: " + CurrencyRates.getMediaIene() + " Ienes");
        System.out.println("Em Libras: " + CurrencyRates.getMediaLibra() + " Â£");
    }
}
