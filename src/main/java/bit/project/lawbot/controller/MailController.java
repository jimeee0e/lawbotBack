package bit.project.lawbot.controller;

import bit.project.lawbot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService service;

    @Autowired
    MailSenderService jimi;
    @GetMapping("/test")
    public int testMail(){

//        jimi.sendEmail("woon.woon.jo@gmail.com","하하","보냈지롱");
        return service.mailTest();
    }
}
