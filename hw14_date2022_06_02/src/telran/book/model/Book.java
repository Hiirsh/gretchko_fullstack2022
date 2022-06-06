package telran.book.model;

public class Book {
	// isbn, title, author, yearOfPublishing
	private long isbn;
	private String title;
	private String author = "unknown";
	private int yearOfPublishing;

	public Book(long isbn, String title, String author, int yearOfPublishing) {
		this.isbn = checkIsbn(isbn);
		this.title = title;
		this.author = author;
		this.yearOfPublishing = yearOfPublishing;
	}

	public Book(long isbn, String title, int yearOfPublishing) {
		this.isbn = checkIsbn(isbn);
		this.title = title;
		this.yearOfPublishing = yearOfPublishing;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}

	private long checkIsbn(long isbn) {
		if (isbn >= 1_000_000_000_000l && isbn < 9_999_999_999_999l) {
			return isbn;
		}
		return -1;
	}

	public String toString() {
		return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Year: " + yearOfPublishing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}

}
