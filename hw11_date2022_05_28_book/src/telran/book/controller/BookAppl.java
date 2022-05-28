package telran.book.controller;

import telran.book.model.Book;

public class BookAppl {
    public static void main(String[] args) {
        Book warAndPeace = new Book("Tolstoy", "War and Peace");
        Book crimeAndPunishment = new Book("1234567890123", "Feodor", "Dostoevsky", "Crime and Punishment");
        System.out.println(warAndPeace.getIsbn());
        System.out.println(crimeAndPunishment.getAuthor());
    }
}
