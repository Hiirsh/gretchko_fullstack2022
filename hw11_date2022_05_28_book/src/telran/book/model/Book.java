package telran.book.model;

import javax.xml.crypto.Data;

public class Book {
    // isbn, title, author, yearOfPublishing
    private String isbn;
    private String author;
    private String title;
    private int yearOfPublishing;

    public Book(String isbn, String author, String title, int yearOfPublishing) {
        if (isbn.length() == 13) {
            this.isbn = "" + isbn;
        }
        if (isbn.length() == 10) {
            this.isbn = "978" + isbn;
        }
        this.author = author;
        this.title = title;
        if (yearOfPublishing > 1000) {
            this.yearOfPublishing = yearOfPublishing;
        }
        if (yearOfPublishing >= 0 && yearOfPublishing <= 22) {
            this.yearOfPublishing = 2000 + yearOfPublishing;
        }
        if (yearOfPublishing > 22 && yearOfPublishing <= 99) {
            this.yearOfPublishing = 1900 + yearOfPublishing;
        }

    }

    public Book(String isbn, String firstName, String lastName, String title, int yearOfPublishing) {
        if (isbn.length() == 13) {
            this.isbn = "" + isbn;
        }
        if (isbn.length() == 10) {
            this.isbn = "978" + isbn;
        }
        this.author = firstName + " " + lastName;
        this.title = title;
        if (yearOfPublishing > 1000) {
            this.yearOfPublishing = yearOfPublishing;
        }
        if (yearOfPublishing >= 0 && yearOfPublishing <= 22) {
            this.yearOfPublishing = 2000 + yearOfPublishing;
        }
        if (yearOfPublishing > 22 && yearOfPublishing <= 99) {
            this.yearOfPublishing = 1900 + yearOfPublishing;
        }
    }

    public Book(String isbn, String author, String title) {
        if (isbn.length() == 13) {
            this.isbn = "" + isbn;
        }
        if (isbn.length() == 10) {
            this.isbn = "978" + isbn;
        }
        this.author = author;
        this.title = title;
    }

    public Book(String isbn, String firstName, String lastName, String title) {
        if (isbn.length() == 13) {
            this.isbn = "" + isbn;
        }
        if (isbn.length() == 10) {
            this.isbn = "978" + isbn;
        }
        this.author = firstName + " " + lastName;
        this.title = title;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(long isbn, String author, String title, int yearOfPublishing) {
        if (("" + isbn).length() == 13) {
            this.isbn = "" + isbn;
        }
        if (("" + isbn).length() == 10) {
            this.isbn = "978" + isbn;
        }
        this.author = author;
        this.title = title;
        if (yearOfPublishing > 1000) {
            this.yearOfPublishing = yearOfPublishing;
        }
        if (yearOfPublishing >= 0 && yearOfPublishing <= 22) {
            this.yearOfPublishing = 2000 + yearOfPublishing;
        }
        if (yearOfPublishing > 22 && yearOfPublishing <= 99) {
            this.yearOfPublishing = 1900 + yearOfPublishing;
        }
    }

    public Book(long isbn, String author, String title) {
        if (("" + isbn).length() == 13) {
            this.isbn = "" + isbn;
        }
        if (("" + isbn).length() == 10) {
            this.isbn = "978" + isbn;
        }
        this.author = author;
        this.title = title;

    }

    public Book(long isbn, String firstName, String lastName, String title) {
        if (("" + isbn).length() == 13) {
            this.isbn = "" + isbn;
        }
        if (("" + isbn).length() == 10) {
            this.isbn = "978" + isbn;
        }
        this.author = firstName + " " + lastName;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn.length() == 13) {
            this.isbn = "" + isbn;
        }
        if (isbn.length() == 10) {
            this.isbn = "978" + isbn;
        }
    }

    public void setIsbn(long isbn) {
        if (("" + isbn).length() == 13) {
            this.isbn = "" + isbn;
        }
        if (("" + isbn).length() == 10) {
            this.isbn = "978" + isbn;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        if (yearOfPublishing > 1000) {
            this.yearOfPublishing = yearOfPublishing;
        }
        if (yearOfPublishing >= 0 && yearOfPublishing <= 22) {
            this.yearOfPublishing = 2000 + yearOfPublishing;
        }
        if (yearOfPublishing > 22 && yearOfPublishing <= 99) {
            this.yearOfPublishing = 1900 + yearOfPublishing;
        }
    }

}
