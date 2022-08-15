package bit.project.lawbot.mapper;

import bit.project.lawbot.domain.ChatDTO;
import bit.project.lawbot.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {
	public int insertChatLog(ChatDTO dto);
}
