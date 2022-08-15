package bit.project.lawbot.controller;

import bit.project.lawbot.domain.ChatDTO;
import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.service.ChatService;
import bit.project.lawbot.service.MemberService;
import bit.project.lawbot.service.MongoService;
import bit.project.lawbot.util.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService service;

    @PostMapping("/send")
    public ChatDTO send(@RequestBody ChatDTO dto){
        System.out.println("테스트 옴"+dto);
        return service.insertChatLog(dto);
    }
}
