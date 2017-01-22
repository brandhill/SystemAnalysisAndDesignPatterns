package ChatServerDesign;

import java.util.List;
import java.util.Set;

public class UserServiceLayer {
	UserDAOLayer userDaoLayer;
	public User Login(int userId,String password) {
		User user = userDaoLayer.getUser(userId);
		if(user==null) {
			return null;
		}
		if(user.getPassword().equals(password)) {
			user.setOnline(true);
			updateUser(user);
			return user;
		}
		else 
			return null;
	}
	
	public User SignUp(User user) {
		return userDaoLayer.addUser(user);
	}
	
	public User deleteUser(User user) {
		return userDaoLayer.deleteUser(user);
	}
	
	public User updateUser(User user) {
		return userDaoLayer.updateUser(user);
	}
	
	public Set<User> getFriends(int userId) {
		return userDaoLayer.getFriends(userId);
	}
	
	public Set<User> getFriendsRequestSentList(int userId) {
		return userDaoLayer.getFriendRequestSentList(userId);
	}
	
	public Set<User> getFriendRequestReceivedList(int userId) {
		return userDaoLayer.getFriendRequestReceivedList(userId);
	}
	
	public boolean sendFriendRequest(int userId,int friendId) {
		User user = userDaoLayer.getUser(userId);
		User friend = userDaoLayer.getUser(friendId);
		if(user==null || friend == null 
				|| userDaoLayer.getFriendRequestSentList(userId).contains(friend)
				|| userDaoLayer.getFriendRequestReceivedList(friendId).contains(user)
				|| userDaoLayer.getFriendRequestSentList(friendId).contains(user)
				|| userDaoLayer.getFriendRequestReceivedList(userId).contains(friend))
			return false;
		userDaoLayer.addFriendRequestSent(user, friend);
		userDaoLayer.addFriendRequestReceived(friend, user);
		return true;
	}
	
	public boolean acceptFriendRequest(int userId,int friendId) {
		User user = userDaoLayer.getUser(userId);
		User friend = userDaoLayer.getUser(friendId);
		userDaoLayer.deleteFriendRequestSent(friend, user);
		userDaoLayer.deleteFriendRequestReceived(user, friend);
		return userDaoLayer.addFriend(user, friend);
	}
	
	public void rejectFriendRequest(int userId,int friendId) {
		User user = userDaoLayer.getUser(userId);
		User friend = userDaoLayer.getUser(friendId);
		userDaoLayer.deleteFriendRequestSent(friend, user);
		userDaoLayer.deleteFriendRequestReceived(user, friend);
	}
	
	
	
}
