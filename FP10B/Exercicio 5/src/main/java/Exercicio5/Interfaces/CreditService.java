/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio5.Interfaces;

/**
 *
 * @author Samuel
 */
public interface CreditService {
    
    public double getAnnualRate();
    public void setAnnualRate(double r);
    public double computeMonthlyPayment( double ammount, int months);
}
