/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio6;

/**
 *
 * @author Samuel
 */
abstract class Company {
    // variaveis de instância de Company
    private String name;
    private int vatNumber;

    // construtor default de Company
    public Company() {
    }

    // construtor de Company
    public Company(String name, int vatNumber) {
        this.name = name;
        this.vatNumber = vatNumber;
    }

    // GETTERS E SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Override
    public String toString() {
        String text = "";
        text += "Company name: " + name + "\n";
        text += "Company vatNumber: " + vatNumber + "\n";
        return text;
    }
}
