/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio1;

/**
 *
 * @author Samuel
 */
public interface GasService {
    
    public double getGasPrice();
    
    public void setGasPrice(double p);
    
    public double getGasTotal(double litres);
}
