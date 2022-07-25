package bit.project.lawbot.service;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.PrecedentDTO;

import java.util.List;

public interface PrecedentService {
	public List<PrecedentDTO> selectPrecedentList(PrecedentDTO dto);
	public PrecedentDTO selectPrecedentDTO(PrecedentDTO dto);
	public List<PrecedentDTO> searchPrecedentList(PrecedentDTO dto);
}
