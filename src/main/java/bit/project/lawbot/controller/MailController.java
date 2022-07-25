package bit.project.lawbot.controller;

import bit.project.lawbot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService service;
    @GetMapping("/test")
    public int testMail(){
        return service.mailTest();
    }
}
