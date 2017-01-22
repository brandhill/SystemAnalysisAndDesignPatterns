package ChatServerDesign;

import java.util.Date;

public class ChatServiceLayer {
	
	ChatDAOLayer chatDAOLayer; 
	UserDAOLayer userDaoLayer;
	
	public void addPrivateChat(int userId1, int userId2) {
		User user1 = userDaoLayer.getUser(userId1);
		User user2 = userDaoLayer.getUser(userId2);
		PrivateChat privateChate = new PrivateChat(user1, user2);
		user1.getPrivateChats().add(privateChate);
		user2.getPrivateChats().add(privateChate);
		userDaoLayer.updateUser(user1);
		userDaoLayer.updateUser(user2);
		chatDAOLayer.addConversation(privateChate);
	}
	
	public void addGroupChat(int userId) {
		User user = userDaoLayer.getUser(userId);
		GroupChat groupChat = new GroupChat(user);
		user.getGroupChats().add(groupChat);
		userDaoLayer.updateUser(user);
		chatDAOLayer.addConversation(groupChat);
	}
	
	public void addUserToGroupChat(int chatId, int userId) {
		User user = userDaoLayer.getUser(userId);
		GroupChat groupChat = (GroupChat) chatDAOLayer.getConversation(chatId);
		groupChat.users.add(user);
		user.getGroupChats().add(groupChat);
		userDaoLayer.updateUser(user);
		chatDAOLayer.updateConversation(groupChat);
	}
	
	public void addMessage(int chatId,String message,int sentById) {
		User sentBy = userDaoLayer.getUser(sentById);
		Conversation conversation = chatDAOLayer.getConversation(chatId);
		Message message1 = new Message(message, sentBy, conversation, new Date());
		conversation.getMessages().add(message1);
		chatDAOLayer.updateConversation(conversation);
	}
	
	public Conversation getConversation(int chatId) {
		return chatDAOLayer.getConversation(chatId);
	}
	
	public boolean deletePrivateChat(int privateChatId,int userId) {
		PrivateChat privateChat = (PrivateChat) chatDAOLayer.getConversation(privateChatId);
		return chatDAOLayer.getPrivateChats(userId).remove(privateChat);
	}
	
	public boolean leaveGroupChat(int groupChatId,int userId) {
		User user = userDaoLayer.getUser(userId);
		Conversation groupChat = chatDAOLayer.getConversation(groupChatId);
		if( groupChat.getUsers().remove(user) &&
		user.getGroupChats().remove(groupChat) )
			return true;
		else 
			return false;
	}
}
