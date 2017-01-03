package OnlineBookReaderSystem;

import java.util.List;

public interface UserDAOLayer {
	
	boolean addUser(User user);
	
	boolean updateUser(User user);
	
	boolean deleteUser(int userId);
	
	boolean lockUser(int userId);
	
	boolean unlockUser(int userId);
}
