package bit.project.lawbot.service;

import bit.project.lawbot.domain.BaseDTO;
import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.PrecedentDTO;
import bit.project.lawbot.domain.StatuteDTO;

import java.util.List;

public interface StatuteService {
	public BaseDTO<StatuteDTO> selectStatuteList(BaseDTO<StatuteDTO> dto);
	public StatuteDTO selectStatuteDTO(StatuteDTO dto);
	public List<StatuteDTO> searchStatuteList(StatuteDTO dto);
}
