package bit.project.lawbot.service;

import bit.project.lawbot.domain.AlarmDTO;
import java.util.List;

public interface AlarmService {
	public int selectAlarmCount(AlarmDTO dto);
	public List<AlarmDTO> selectAlarmList(AlarmDTO dto);
	public int insertAlarm(AlarmDTO dto);
	public int deleteAlarm(AlarmDTO dto);
}