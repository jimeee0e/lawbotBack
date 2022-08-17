package bit.project.lawbot.service;

import bit.project.lawbot.domain.BaseDTO;
import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.PrecedentDTO;

import java.util.List;

public interface PrecedentService {
	public BaseDTO<PrecedentDTO> selectPrecedentList(BaseDTO<PrecedentDTO> dto);
	public PrecedentDTO selectPrecedentDTO(PrecedentDTO dto);
	public List<PrecedentDTO> searchPrecedentList(PrecedentDTO dto);
}
