package OnlineBookReaderSystem;

import java.util.List;

public interface BookDAOLayer {
	boolean addBook(Book book);
	
	boolean updateBook(Book book);
	
	boolean deleteBook(int bookId);
	
	List<Book> searchBookByTitle(String Title);
	
	List<Book> searchBookByAuthor(String Author);
	
	boolean openBook(int bookId);
	
	boolean closeBook(int bookId);
}
