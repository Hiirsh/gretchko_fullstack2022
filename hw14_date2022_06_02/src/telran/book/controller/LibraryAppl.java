package telran.book.controller;

import telran.book.dao.Library;
import telran.book.model.Book;

public class LibraryAppl {
    public static void main(String[] args) {
        Library library = new Library(6);
        library.addBook(new Book(2000000000000l, "Book0", 1998));
        library.addBook(new Book(3000000000000l, "Book1", "Author1", 1998));
        library.addBook(new Book(4000000000000l, "Book2", "Author1", 1995));
        library.addBook(new Book(5000000000000l, "Book3", "Author2", 1990));
        library.addBook(new Book(6000000000000l, "Book4", 1981));
        library.printBooks();
    }
}
