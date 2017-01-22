package ChatServerDesign;

import java.util.Date;

public class Message {
	private int messageId;
	private String message;
	private User sentBy;
	private Date time;
	private Conversation conversation;
	public Message(String message, User sentBy,Conversation conversation,Date time) {
		this.message = message;
		this.sentBy = sentBy;
		this.conversation = conversation;
		this.time = time;
	}
	public int getMessageId() {
		return messageId;
	}
	public String getMessage() {
		return message;
	}
	public User getSentBy() {
		return sentBy;
	}
	public Conversation getConversation() {
		return conversation;
	}
	public Date getTime() {
		return time;
	}
	
}
