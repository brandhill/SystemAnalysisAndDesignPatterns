package ChatServerDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private int userId;
	private String userName;
	private String password;
	private boolean isOnline;
	private Set<User> friends;
	private Set<User> friendRequestsReceived;
	private Set<User> friendRequestsSent;
	private Set<GroupChat> groupChats;
	private Set<PrivateChat> privateChats;
	public User(int userId, String userName,boolean isOnline) {
		this.userId = userId;
		this.userName = userName;
		this.isOnline = isOnline;
		this.friends = new HashSet<User>();
		this.friendRequestsReceived = new HashSet<User>();
		this.friendRequestsSent = new HashSet<User>();
		this.groupChats = new HashSet<GroupChat>();
		this.privateChats = new HashSet<PrivateChat>();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean getOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<User> getFriends() {
		return friends;
	}
	public Set<User> getFriendRequestsReceived() {
		return friendRequestsReceived;
	}
	public Set<User> getFriendRequestsSent() {
		return friendRequestsSent;
	}
	public Set<GroupChat> getGroupChats() {
		return groupChats;
	}
	public Set<PrivateChat> getPrivateChats() {
		return privateChats;
	}
	
	/*public void sendFriendRequest(User user) {
		friendRequestsSent.add(user);
	}
	public void cancelFriendRequestSent(User user) {
		friendRequestsSent.remove(user);
	}
	public void receiveFriendRequest(User user) {
		friendRequestsReceived.add(user);
	}
	public void rejectFriendRequestReceived(User user) {
		friendRequestsReceived.remove(user);
	}
	public void addFriend(User user) {
		friends.add(user);
	}
	public void deleteFriend(User user) {
		friends.remove(user);
	}
	public void addPrivateChat(PrivateChat privateChat) {
		privateChats.add(privateChat);
	}
	public void deletePrivateChat(PrivateChat privateChat) {
		privateChats.remove(privateChat);
	}
	public void addGroupChat(GroupChat groupChat) {
		groupChats.add(groupChat);
	}
	public void deleteGroupChat(GroupChat groupChat) {
		groupChats.remove(groupChat);
	}*/
	
	
}
