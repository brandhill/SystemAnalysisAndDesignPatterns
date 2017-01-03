package OnlineBookReaderSystem;

import java.util.Date;

public class BusinessServiceLayer {
	
	private static BusinessServiceLayer service = null;
	private BookDAOLayer bookDAO;
	private UserDAOLayer userDAO;
	private TransactionDAOLayer transactionDAO;
	private BusinessServiceLayer() {
		
	}
	
	static BusinessServiceLayer getInstace() {
		if(service==null) {
			service = new BusinessServiceLayer();
		}
		return service;
	}
	
	boolean addTransaction(User user,Book book) {
		
		if(!bookDAO.openBook(book.bookId)) {
			System.out.println("Book is currently used by another User");
			return false;
		}
		else if(!userDAO.lockUser(user.userId)) {
			System.out.println("You cannot open multiple books.");
			return false;
		}
		Transaction tran = new Transaction(book,user,new Date());
		return transactionDAO.addTransaction(tran);
	}
	
	boolean updateTransactionWithClosingDate(int tranId) {
		Transaction tran = transactionDAO.getTransaction(tranId);
		tran.closed = new Date();
		bookDAO.closeBook(tran.book.bookId);
		userDAO.unlockUser(tran.user.userId);
		return transactionDAO.updateTransaction(tran);
	}
	
}
