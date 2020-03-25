package com.company;

public class Main {

    public static void main(String[] args) {
        double soma_ano = 0;

        System.out.println("Despesas por mes e dia");
        for (int i = 0; i < YearExpenses.MatrizDespesas[i].length; i++) {
            System.out.println(" ");
            for (int j = 0; j < YearExpenses.MatrizDespesas[i].length; j++) {
                System.out.print((YearExpenses.MatrizDespesas[i][j]) + "\t" + "\t");
            }
        }
        // De seguida fazer todos os calculos como na ficha anterior
        for (int i = 0; i < YearExpenses.MatrizDespesas.length; i++) {
            if (YearExpenses.MatrizDespesas[i][0] != 0.0) {
                soma_ano += YearExpenses.MatrizDespesas[i][0];
            }
        }

        System.out.println("Soma total dos gastos do carro: " + soma_ano);


    }
}