package ChatServerDesign;

import java.util.List;
import java.util.Set;

public interface ChatDAOLayer {
	
	public boolean addConversation(Conversation conversation);
	
	public boolean updateConversation(Conversation conversation);
	
	public Conversation getConversation(int chatId);
	
	public boolean deletePrivateChat(int privateChatId);
	
	public Set<GroupChat> getGroupChats(int userId);
	
	public Set<PrivateChat> getPrivateChats(int userId);
	
}
