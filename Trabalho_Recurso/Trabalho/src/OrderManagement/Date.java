package OrderManagement;

/*
* Nome: <Samuel Luciano Correia da Cunha>
* Número: <8160526>
* Turma: <T3>
*
* Nome: <João Emanuel Carvalho Leocádio>
* Número: <8160523>
* Turma: <T2>
 */
public class Date {
    // variaveis de instancia
    private int day;
    private int month;
    private int year;

    /**
     * Metodo construtor de Date 
     * @param day dia (inteiro)
     * @param month mes (inteiro
     * @param year ano (inteiro)
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Metodo para obter o dia
     * @return dia (inteiro)
     */
    public int getDay() {
        return day;
    }

    /**
     * Metodo para atribuir o dia
     * @param day dia a atribuir (inteiro)
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Metodo para obter o mes
     * @return mes (inteiro)
     */
    public int getMonth() {
        return month;
    }

    /**
     * Metodo para atribuir o mes
     * @param month mes a atribuir (inteiro)
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Metodo para obter o ano
     * @return ano (inteiro)
     */
    public int getYear() {
        return year;
    }

    /**
     * Metodo para atribuir o ano
     * @param year ano a atribuir (inteiro)
     */
    public void setYear(int year) {
        this.year = year;
    }
}