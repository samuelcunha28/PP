package Interfaces;

public interface CreditService {
    public double getAnnualRate();

    public void setAnnualRate(double r);

    public double computeMonthlyPayment(double ammount, int months);
}
