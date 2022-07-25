package bit.project.lawbot.service;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.mapper.ChartMapper;
import bit.project.lawbot.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {
	@Autowired
	ChartMapper mapper;

	@Override
	public ChartDTO selectChart(ChartDTO dto) {
		return null;
	}

	@Override
	public List<ChartDTO> selectHarmResponse(ChartDTO dto) {
		return mapper.selectHarmResponse(dto);
	}

	@Override
	public ChartDTO selectAttackerType(ChartDTO dto) {
		return mapper.selectAttackerType(dto);
	}

	@Override
	public List<ChartDTO> selectHarmPlace(ChartDTO dto) {
		return mapper.selectHarmPlace(dto);
	}

	@Override
	public List<ChartDTO> selectHarmType(ChartDTO dto) {
		return mapper.selectHarmType(dto);
	}
}
