package ChatServerDesign;

import java.util.List;
import java.util.Set;

public interface UserDAOLayer {
	
	public User addUser(User user);
	
	public User getUser(int userId);
	
	public User updateUser(User user);
	
	public User deleteUser(User user);
	
	public boolean addFriend(User user,User friend);
	
	public boolean deleteFriend(User userId,User friendId);
	
	public Set<User> getFriends(int userId);
	
	public boolean addFriendRequestSent(User fromUser,User toUser);
	
	public boolean deleteFriendRequestSent(User fromUser,User toUser);
	
	public Set<User>  getFriendRequestSentList(int userId);
	
	public boolean addFriendRequestReceived(User fromUser,User toUser);
	
	public boolean deleteFriendRequestReceived(User fromUser,User toUser);
	
	public Set<User>  getFriendRequestReceivedList(int userId);
	
}
