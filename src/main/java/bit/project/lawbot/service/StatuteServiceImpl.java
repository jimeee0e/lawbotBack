package bit.project.lawbot.service;

import bit.project.lawbot.domain.PrecedentDTO;
import bit.project.lawbot.domain.StatuteDTO;
import bit.project.lawbot.domain.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StatuteServiceImpl implements StatuteService {

	@Autowired
	private MongoTemplate template;

	@Override
	public List<StatuteDTO> selectStatuteList(StatuteDTO dto) {
		Query query = new Query();
		Pageable pageable = PageRequest.of(dto.getPage()-1,dto.getSize());
		query.with(pageable);

		List<StatuteDTO> list = template.find(query,StatuteDTO.class,"statute");
		return list;
	}

	@Override
	public StatuteDTO selectStatuteDTO(StatuteDTO dto) {
		return null;
	}

	@Override
	public List<StatuteDTO> searchStatuteList(StatuteDTO dto) {
		return null;
	}
}