package com.company;

import pp_fp04.book.Book;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book();

        book1.Titulo = "Java 8";
        book1.Editor = "FCA";
        book1.autor.Acronimo = new char[]{'F', 'M', 'M'};
        book1.autor.Nome = "Fabio Martins";
        book1.autor.Nacionalidade = "Portuguesa";
        book1.Ano = 2017;
        book1.Paginas = 584;
        book1.Cotacao = 9.7;

        System.out.println("-----------Book 1----------");
        System.out.print("Titulo: ");
        System.out.println(book1.Titulo);
        System.out.print("Editor: ");
        System.out.println(book1.Editor);
        System.out.println("Acronimo: " + Arrays.toString(book1.autor.Acronimo));
        System.out.println("Autor 1:");
        System.out.println("Nome : " + book1.autor.Nome);
        System.out.println("Nacionalidade : " + book1.autor.Nacionalidade);
        System.out.print("Ano: ");
        System.out.println(book1.Ano);
        System.out.print("Paginas: ");
        System.out.println(book1.Paginas);
        System.out.print("Cotacao: ");
        System.out.println(book1.Cotacao);
    }
}