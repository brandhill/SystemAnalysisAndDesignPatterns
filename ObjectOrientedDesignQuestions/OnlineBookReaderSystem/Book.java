package OnlineBookReaderSystem;

public class Book {
	int bookId;
	String title;
	String description;
	String Author;
	boolean userLock;
	public Book(int bookId, String title, String description, String author) {
		this.bookId = bookId;
		this.title = title;
		this.description = description;
		Author = author;
	}
	
	
}
