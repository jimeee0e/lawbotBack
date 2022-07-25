package bit.project.lawbot.controller;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/statute")
public class StatuteController {
    @Autowired
    ChartService service;
    @PostMapping("/chart1")
    public ChartDTO selectChart(@RequestBody ChartDTO dto) {
        System.out.println(dto);
        List<Integer> result1 = null;
        List<Integer> result2 = null;
        if (dto.getType().equals("1")) {
            if (dto.getStudent().equals("초등학생")) {
                result1 = Arrays.asList(1, 2, 10);
                result2 = Arrays.asList(25, 34, 11);
            } else if (dto.getStudent().equals("중학생")) {
                result1 = Arrays.asList(15, 2, 33);
                result2 = Arrays.asList(1, 5, 9);
            } else if (dto.getStudent().equals("고등학생")) {
                result1 = Arrays.asList(55, 3, 25);
                result2 = Arrays.asList(9, 55, 34);
            }
        }
        dto.setResult1(result1);
        dto.setResult2(result2);
        return dto;
        //return service.selectChart(dto);->아직 디비에서 가져오는거 아니니까
    }

    @GetMapping("/chartTest")
    public List<ChartDTO> selectChart2(){
        System.out.println();
        ChartDTO dto = new ChartDTO();
        dto.setType("초");
        System.out.println(service.selectHarmPlace(dto));
        return null;
        //return service.selectChart(dto);->아직 디비에서 가져오는거 아니니까
    }

    @PostMapping("/chart2")
    public ChartDTO selectChart2(@RequestBody ChartDTO dto){
        System.out.println(dto);
        dto = service.selectAttackerType(dto);
        System.out.println("되돌려줄값"+dto);
        return dto;
    }
}
