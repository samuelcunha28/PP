package com.company;

public class YearExpenses {
    protected static final int NUMBER_OF_MONTHS = 12;
    protected static final int NUMBER_OF_DAYS = 31;
    protected static int number;
    protected static int value;
    protected static double[][] MatrizDespesas = new double[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {96.06148, 125.00000, 1.00000, 143.26648, 123.45, 253.66, 96.06148, 125.00000, 1.00000, 143.26648, 123.45, 253.66}};

    public static int getNumberOfMonths() {
        return NUMBER_OF_MONTHS;
    }

    public static int getNumberOfDays() {
        return NUMBER_OF_DAYS;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        YearExpenses.number = number;
    }

    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        YearExpenses.value = value;
    }
}
