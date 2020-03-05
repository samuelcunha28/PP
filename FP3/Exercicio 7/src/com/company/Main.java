package com.company;

public class Main {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]); // a=5 dividendo
        int b = Integer.parseInt(args[1]); // b=2 divisor
        int q = 0, r; // quociente e resto
        int aux; // valor da subtracao a ser armazenado

        aux = a;

        while (aux >= b) {
            aux = aux - b;
            q = q + 1;
        }

        r = aux;

        System.out.println(q);
        System.out.println(r);
    }
}
