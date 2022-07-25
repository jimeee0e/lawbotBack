package bit.project.lawbot.mapper;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChartMapper {
	public ChartDTO selectChart(ChartDTO dto);
	public List<ChartDTO> selectHarmResponse(ChartDTO dto);
	public ChartDTO selectAttackerType(ChartDTO dto);
	public List<ChartDTO> selectHarmPlace(ChartDTO dto);
	public List<ChartDTO> selectHarmType(ChartDTO dto);
}
