package com.company;

// 1.2 Os warnings é que é um membro estático de User
// 1.3 Nenhuma diferença foi detetada e não teve nenhum impacto no output final
public class Main {

    static User user1;
    static User user2;
    public static void main(String[] args) {
        // inicialização dos valores User1
	    user1.id[0] = 'A';
        user1.id[1] = 'B';
        user1.id[2] = 'C';
        user1.name = new char[]{'S', 'a', 'm', 'u', 'e', 'l'};
        user1.email = new char[]{'s', 'a', 'm', 'u', 'e', 'l', '@', 'e',
        's', 't', 'g', '.', 'i', 'p', 'p', '.', 'p', 't'};

        // Print atributos do User1
        System.out.println("-------User 1--------");
        System.out.print("ID: ");
        System.out.println(user1.id);
        System.out.print("Name: ");
        System.out.println(user1.name);
        System.out.print("Email: ");
        System.out.println(user1.email);

        // inicialização dos valores User2
        user2.id[0] = 'D';
        user2.id[1] = 'E';
        user2.id[2] = 'F';
        user2.name = new char[]{'L', 'u', 'c', 'i', 'a', 'n', 'o'};
        user2.email = new char[]{'l', 'u', 'c', 'i', 'a', 'n', 'o', '@',
                'e', 's', 't', 'g', '.', 'i', 'p', 'p', '.', 'p', 't'};

        // Print atributos do User2
        System.out.println("-------User 2--------");
        System.out.print("ID: ");
        System.out.println(user2.id);
        System.out.print("Name: ");
        System.out.println(user2.name);
        System.out.print("Email: ");
        System.out.println(user2.email);
    }
}
