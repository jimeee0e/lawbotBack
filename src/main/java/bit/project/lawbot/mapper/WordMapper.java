package bit.project.lawbot.mapper;

import bit.project.lawbot.domain.PostDTO;
import bit.project.lawbot.domain.WordDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordMapper {
	public List<WordDTO> selectWordList(WordDTO dto);
	public WordDTO selectWord(WordDTO dto);
}
