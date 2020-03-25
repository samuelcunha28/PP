package pp_fp05.expense;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExpensesDemo {

    public static void main(String[] args) {
        Expense expense1 = new Expense("Comida", 12.5f, "2020-03-25");
        Expense expense2 = new Expense("Seguro Carro", 225.58f, "2020-03-20");

        User user1 = new User("Samuel", "samuel@gmail.com", "1998-11-12");
        User user2 = new User("Toni", "toni@gmail.com", "1976-09-24");

        user1.expenses[0] = expense1;
        user2.expenses[1] = expense2;

        // USER 1 OUTPUT
        System.out.println("User1 ID: " + user1.id);
        System.out.println("User1 Name: " + user1.nome);
        System.out.println("User1 Email: " + user1.email);
        System.out.println("User1 Birth: " + user1.birthDate);

        System.out.println("");

        // USER 1 EXPENSES OUTPUT
        System.out.println("User1 Expense ID: " + user1.expenses[0].id);
        System.out.println("User1 Expense Type: " + user1.expenses[0].type);
        System.out.println("User1 Expense Amount: " + user1.expenses[0].amount);
        System.out.println("User1 Expense Date: " + user1.expenses[0].date);

        System.out.println("");

        // USER 2 OUTPUT
        System.out.println("User2 ID: " + user2.id);
        System.out.println("User2 Name: " + user2.nome);
        System.out.println("User2 Email: " + user2.email);
        System.out.println("User2 Birth: " + user2.birthDate);

        System.out.println("");

        // USER 2 EXPENSES OUTPUT
        System.out.println("User2 Expense ID: " + user2.expenses[1].id);
        System.out.println("User2 Expense Type: " + user2.expenses[1].type);
        System.out.println("User2 Expense Amount: " + user2.expenses[1].amount);
        System.out.println("User2 Expense Date: " + user2.expenses[1].date);
    }
}
