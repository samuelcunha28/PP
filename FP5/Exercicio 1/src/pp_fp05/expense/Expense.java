package pp_fp05.expense;

public class Expense {
    private static int nextId = 0;
    protected int id;
    protected String type;
    protected float amount;
    protected String date;

    public Expense(String tempType, float tempAmount, String tempDate) {
        id = nextId++;
        type = tempType;
        date = tempDate;
        amount = tempAmount;
    }
}
