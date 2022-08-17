package bit.project.lawbot.service;

import bit.project.lawbot.domain.BaseDTO;
import bit.project.lawbot.domain.StatuteDTO;
import bit.project.lawbot.domain.WordDTO;
import bit.project.lawbot.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

	@Autowired
	private WordMapper mapper;

	@Override
	public List<WordDTO> selectWordList(WordDTO dto) {
		return mapper.selectWordList(dto);
	}

	@Override
	public WordDTO selectWord(WordDTO dto) {
		return null;
	}
}