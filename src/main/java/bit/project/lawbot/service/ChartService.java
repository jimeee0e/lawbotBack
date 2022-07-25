package bit.project.lawbot.service;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.MemberDTO;

import java.util.List;

public interface ChartService {
	public ChartDTO selectChart(ChartDTO dto);
	public List<ChartDTO> selectHarmResponse(ChartDTO dto);
	public ChartDTO selectAttackerType(ChartDTO dto);
	public List<ChartDTO> selectHarmPlace(ChartDTO dto);
	public List<ChartDTO> selectHarmType(ChartDTO dto);
}
