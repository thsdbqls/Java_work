package d260122_03;

public class Book {
	
	String isbn;            // 도서번호
	
	String title;        // 책 이름
	String author;       // 저자
    String publisher;    // 출판사
	
	String year;            // 출판 연도
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String isbn, String title, String author, String publisher, String year) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", year="
				+ year + "]";
	}

	
	
}
