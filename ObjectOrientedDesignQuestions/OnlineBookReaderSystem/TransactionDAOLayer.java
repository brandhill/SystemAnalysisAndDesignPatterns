package OnlineBookReaderSystem;

import java.util.Date;

public interface TransactionDAOLayer {
	
	boolean addTransaction(Transaction tran);
	
	boolean deleteTransaction(int tranId);
	
	boolean updateTransaction(Transaction tran);
	
	Transaction getTransaction(int tranId);
	
}
