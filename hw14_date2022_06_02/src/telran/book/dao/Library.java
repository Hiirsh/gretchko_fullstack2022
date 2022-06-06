package telran.book.dao;

import telran.book.model.Book;

public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
    }

    public boolean addBook(Book book) {
        if (books.length == size) {
            return false;
        }
        books[size++] = book;
        return true;

    }

    public Book removeBookByTitle(String title) {
        int index = findIndex(title);
        if (index != -1) {
            Book res = books[index];
            books[index] = books[--size];
            books[size] = null;
            return res;
        }
        return null;
    }

    private int findIndex(String title) {
        for (int i = 0; i < size; i++) {
            if (title.equals(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    private int findIndex(long isbn) {
        for (int i = 0; i < size; i++) {
            if (isbn == books[i].getIsbn()) {
                return i;
            }
        }
        return -1;
    }

    public Book findBookByTitle(String title) {
        int index = findIndex(title);
        return index == -1 ? null : books[index];
    }

    public Book updateBook(long isbn, String newAuthor) {
        int index = findIndex(isbn);
        if (index != -1) {
            books[index].setAuthor(newAuthor);
            return books[index];
        }
        return null;
    }

    public void printBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void printBooks(int fromYear) {
        for (int i = 0; i < size; i++) {
            if (books[i].getYearOfPublishing() >= fromYear) {
                System.out.println(books[i]);
            }
        }
    }

    public void printBooks(int fromYear, int toYear) {
        for (int i = 0; i < size; i++) {
            if (books[i].getYearOfPublishing() >= fromYear && books[i].getYearOfPublishing() <= toYear) {
                System.out.println(books[i]);
            }
        }
    }
}
