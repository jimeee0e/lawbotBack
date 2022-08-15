package bit.project.lawbot.mapper;

import bit.project.lawbot.domain.AlarmDTO;
import bit.project.lawbot.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmMapper {
	public int selectAlarmCount(AlarmDTO dto);
	public List<AlarmDTO> selectAlarmList(AlarmDTO dto);
	public int insertAlarm(AlarmDTO dto);
	public int deleteAlarm(AlarmDTO dto);
}
