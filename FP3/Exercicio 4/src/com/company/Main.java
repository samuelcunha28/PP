package com.company;

public class Main {

    public static void main(String[] args) {
        int numero = Integer.parseInt(args[0]);
        double radianos;

        radianos = numero * (Math.PI / 180);
        System.out.println(radianos);
    }
}
