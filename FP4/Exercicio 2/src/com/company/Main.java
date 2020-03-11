package com.company;

import java.util.Arrays;

public class Main {
    static User user1;

    public static void main(String[] args) {
        double sumcar = 0, sumfood = 0;
        int indexcar = 0, indexfood = 0;
        user1.id[0] = 'A';
        user1.id[1] = 'B';
        user1.id[2] = 'C';
        user1.name = new char[]{'S', 'A', 'M', 'U', 'E', 'L'};
        user1.email = new char[]{'s', 'a', 'm', 'u', 'e', 'l', '@', 'e', 's', 't',
                'g', '.', 'i', 'p', 'p', '.', 'p', 't'};

        user1.expenses.carValues[0] = 100.99;
        user1.expenses.carValues[1] = 200.99;
        user1.expenses.carValues[2] = 140.99;
        user1.expenses.carValues[3] = 101.50;
        user1.expenses.number1 = 4;
        System.out.println("--------Despesas automoveis---------");
        System.out.print("Car description: ");
        System.out.println(Expenses.descriptionCar);
        System.out.print("Car values: ");
        System.out.println(Arrays.toString(user1.expenses.carValues)); // array to string para imprimir os valores do array

        System.out.println("--------Despesas alimentares---------");
        user1.expenses.foodValues[0] = 10;
        user1.expenses.foodValues[1] = 20;
        user1.expenses.foodValues[2] = 30;
        user1.expenses.foodValues[3] = 40;
        user1.expenses.number2 = 4;

        System.out.print("Food description: ");
        System.out.println(Expenses.descriptionFood);
        System.out.print("Food values: ");
        System.out.println(Arrays.toString(user1.expenses.foodValues)); // array to string para imprimir os valores do array
        //----------------------------------------------------------------------------------------------------------------------
        //2.3

        for (int i = 0; i < user1.expenses.carValues.length; i++) {
            if (user1.expenses.carValues[i] != 0.0) {
                sumcar += user1.expenses.carValues[i];
                indexcar++;
            }
        }

        for (int i = 0; i < user1.expenses.foodValues.length; i++) {
            if (user1.expenses.foodValues[i] != 0.0) {
                sumfood += user1.expenses.foodValues[i];
                indexfood++;
            }
        }

        System.out.println("");
        System.out.println("Soma total dos gastos do carro: " + sumcar);
        System.out.println("Media dos gastos do carro: " + (sumcar / indexcar));
        System.out.println("");
        System.out.println("Soma total dos gastos da comida: " + sumfood);
        System.out.println("Media dos gastos da comida: " + (sumfood / indexfood));

        // 2.4
        /**
         * Não era possível aceder às variáveis da classe porque elas estavam privadas
         */
    }
}
