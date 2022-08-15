package bit.project.lawbot.controller;

import bit.project.lawbot.domain.AlarmDTO;
import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.service.AlarmService;
import bit.project.lawbot.service.MemberService;
import bit.project.lawbot.service.MongoService;
import bit.project.lawbot.util.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alarm")
public class AlarmController {
    @Autowired
    AlarmService service;

    @PostMapping("/myalarm")
    public int selectAlarmCount(@RequestBody AlarmDTO dto){
        return service.selectAlarmCount(dto);
    }

    @PostMapping("/myalarmlist")
    public List<AlarmDTO> selectAlarmList(@RequestBody AlarmDTO dto){
        return service.selectAlarmList(dto);
    }
}
