package bit.project.lawbot.controller;

import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.domain.WordDTO;
import bit.project.lawbot.service.MemberService;
import bit.project.lawbot.service.MongoService;
import bit.project.lawbot.service.WordService;
import bit.project.lawbot.util.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {
    @Autowired
    WordService service;

    @PostMapping("/getWordList")
    public List<WordDTO> selectWordList(@RequestBody WordDTO dto){
        System.out.println("dto하하"+dto);
        return service.selectWordList(dto);
    }

    @PostMapping("/getWord")
    public WordDTO selectWord(@RequestBody WordDTO dto){
        return service.selectWord(dto);
    }
}