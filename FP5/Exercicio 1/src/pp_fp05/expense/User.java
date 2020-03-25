package pp_fp05.expense;

public class User {
    private static int nextId = 0;

    protected final int EXPENSES_SIZE = 31;
    protected int id;
    protected String nome;
    protected String email;
    protected String birthDate;
    protected Expense[] expenses;

    /**
     * Construtor do {@link User} que inicializa o array de {@link Expense}
     * com o tamanho por omissão {@value #EXPENSES_SIZE}
     *
     * @param tempNome nome do {@link User}
     * @param tempEmail email do {@link User}
     * @param tempBirthDate data de nascimento do {@link User}
     */
    public User(String tempNome, String tempEmail, String tempBirthDate) {
        expenses = new Expense[EXPENSES_SIZE];
        id = nextId++;
        nome = tempNome;
        email = tempEmail;
        birthDate = tempBirthDate;
    }

}
