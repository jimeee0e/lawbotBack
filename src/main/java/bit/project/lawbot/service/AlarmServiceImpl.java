package bit.project.lawbot.service;

import bit.project.lawbot.domain.AlarmDTO;
import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.mapper.AlarmMapper;
import bit.project.lawbot.mapper.ChartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {
	@Autowired
	AlarmMapper mapper;

	@Override
	public int selectAlarmCount(AlarmDTO dto) {
		return mapper.selectAlarmCount(dto);
	}

	@Override
	public List<AlarmDTO> selectAlarmList(AlarmDTO dto) {
		return mapper.selectAlarmList(dto);
	}

	@Override
	public int insertAlarm(AlarmDTO dto) {
		return mapper.insertAlarm(dto);
	}

	@Override
	public int deleteAlarm(AlarmDTO dto) {
		return mapper.deleteAlarm(dto);
	}
}
