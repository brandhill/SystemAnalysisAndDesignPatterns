package ChatServerDesign;

import java.util.ArrayList;
import java.util.List;

public abstract class Conversation {
	protected int chatId;
	protected List<Message> messages;
	protected List<User> users;
	public Conversation() {
		this.messages = new ArrayList<Message>();
		this.users = new ArrayList<User>();
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	public int getChatId() {
		return chatId;
	}
	public List<User> getUsers() {
		return users;
	}
}

class GroupChat extends Conversation {
	
	public GroupChat(User user) {
		super();
		this.users.add(user);
	}

	void addUser(User user) {
		users.add(user);
	}
}

class PrivateChat extends Conversation {
	public PrivateChat(User user1,User user2) {
		super();
		this.users.add(user1);
		this.users.add(user2);
	}
}