package bit.project.lawbot.controller;

import bit.project.lawbot.domain.BaseDTO;
import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.PrecedentDTO;
import bit.project.lawbot.service.ChartService;
import bit.project.lawbot.service.PrecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/precedent")
public class PrecedentController {
    @Autowired
    PrecedentService service;
    @PostMapping("/getList")
    public BaseDTO<PrecedentDTO> selectPrecedentList(@RequestBody BaseDTO dto) {
        return service.selectPrecedentList(dto);
    }

    @PostMapping("/get")
    public PrecedentDTO selectPrecedent(@RequestBody PrecedentDTO dto) {
        return service.selectPrecedentDTO(dto);
    }
}
