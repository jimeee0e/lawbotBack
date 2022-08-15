package bit.project.lawbot.service;

import bit.project.lawbot.domain.ChatDTO;
import bit.project.lawbot.domain.MemberDTO;

public interface ChatService {
	public ChatDTO insertChatLog(ChatDTO dto);
}
