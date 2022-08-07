package bit.project.lawbot.controller;

import bit.project.lawbot.domain.PrecedentDTO;
import bit.project.lawbot.domain.StatuteDTO;
import bit.project.lawbot.service.StatuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statute")
public class StatuteController {

    @Autowired
    StatuteService service;
    @PostMapping("/getList")
    public List<StatuteDTO> selectStatuteList(@RequestBody StatuteDTO dto) {
        return service.selectStatuteList(dto);
    }
}
