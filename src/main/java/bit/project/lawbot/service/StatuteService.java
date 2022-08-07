package bit.project.lawbot.service;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.PrecedentDTO;
import bit.project.lawbot.domain.StatuteDTO;

import java.util.List;

public interface StatuteService {
	public List<StatuteDTO> selectStatuteList(StatuteDTO dto);
	public StatuteDTO selectStatuteDTO(StatuteDTO dto);
	public List<StatuteDTO> searchStatuteList(StatuteDTO dto);
}
