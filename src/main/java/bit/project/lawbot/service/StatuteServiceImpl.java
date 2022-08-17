package bit.project.lawbot.service;

import bit.project.lawbot.domain.BaseDTO;
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
	public BaseDTO<StatuteDTO> selectStatuteList(BaseDTO<StatuteDTO> dto) {
		Query query = new Query();
		Criteria cri = new Criteria();
		cri.orOperator(
				Criteria.where("항").elemMatch(Criteria.where("항내용").regex(dto.getPaging().getSearchText())),
				Criteria.where("조문내용").regex(dto.getPaging().getSearchText())
				//Criteria.where("항").elemMatch(Criteria.where("호").elemMatch(Criteria.where("호내용").regex(dto.getPaging().getSearchText()))
		);
		query.addCriteria(cri);
		dto.getPaging().setTotal((int) template.count(query,StatuteDTO.class));
		dto.getPaging().settingMaxPage();

		Pageable pageable = PageRequest.of(dto.getPaging().getPage()-1,dto.getPaging().getSize());
		query.with(pageable);
		dto.setList(template.find(query,StatuteDTO.class,"statute"));


//		Query query = new Query();
//		Criteria cri = new Criteria();
//		cri.orOperator(
//				Criteria.where("항").elemMatch(Criteria.where("항내용").regex(dto.getPaging().getSearchText())),
//				Criteria.where("조문내용").regex(dto.getPaging().getSearchText()),
//				Criteria.where("항").elemMatch(Criteria.where("호").elemMatch(Criteria.where("호내용").regex(dto.getPaging().getSearchText())))
//		);
//		query.addCriteria(cri);
//		dto.setList(template.find(query,StatuteDTO.class,"statute"));
//
//		Pageable pageable = PageRequest.of(dto.getPaging().getPage()-1,dto.getPaging().getSize());
//		query.with(pageable);
//
//		dto.getPaging().setTotal((int) template.count(query,StatuteDTO.class));
//		dto.getPaging().settingMaxPage();
		return dto;
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