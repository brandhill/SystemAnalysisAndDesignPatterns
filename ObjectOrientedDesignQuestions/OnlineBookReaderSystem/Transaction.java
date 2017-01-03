package OnlineBookReaderSystem;

import java.util.Date;

public class Transaction {
	int tranId;
	Book book;
	User user;
	Date assigned;
	Date closed;
	public Transaction(Book book, User user, Date assigned) {
		this.book = book;
		this.user = user;
		this.assigned = assigned;
	}
	
}
