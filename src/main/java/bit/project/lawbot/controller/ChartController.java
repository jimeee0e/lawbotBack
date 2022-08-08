package bit.project.lawbot.controller;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.service.ChartService;
import bit.project.lawbot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    ChartService service;
    @PostMapping("/chart2")
    public ChartDTO selectChart2(@RequestBody ChartDTO dto){
        System.out.println(dto);
        dto = service.selectAttackerType(dto);
        System.out.println("되돌려줄값"+dto);
        return dto;
    }

    @PostMapping("/chart1")
    public List<ChartDTO> selectChart1(@RequestBody ChartDTO dto){
        System.out.println(dto);
        return service.selectHarmResponse(dto);
    }
    @PostMapping("/chart3")
    public List<ChartDTO> selectChart3(@RequestBody ChartDTO dto){
        System.out.println(dto);
        return service.selectHarmType(dto);
    }
}
