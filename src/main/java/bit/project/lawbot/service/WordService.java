package bit.project.lawbot.service;

import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.domain.WordDTO;

import java.util.List;

public interface WordService {
	public List<WordDTO> selectWordList(WordDTO dto);
	public WordDTO selectWord(WordDTO dto);
}
