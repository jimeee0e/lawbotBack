package bit.project.lawbot.controller;

import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.service.MemberService;
import bit.project.lawbot.service.MongoService;
import bit.project.lawbot.util.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alarm")
public class AlarmController {
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    MemberService service;

    @Autowired
    MongoService testService;
    @PostMapping("/join")
    public int insertMember(@RequestBody MemberDTO dto){
        System.out.println("dto하하"+dto);
        return service.insertMember(dto);
    }

    @GetMapping("/testtest")
    public int test(){
        MemberDTO dto = new MemberDTO();
        dto.setEmail("test@mail.com");
        dto.setPass("haha");
        return service.insertMember(dto);
    }

    @PostMapping("/mypage")
    public MemberDTO selectMember(@RequestBody MemberDTO dto) {
        return service.selectMember(dto);
    }

    @PostMapping("/withdraw")
    public MemberDTO deleteMember(@RequestBody MemberDTO dto) {
        return service.deleteMember(dto);
    }

    @PostMapping("/modify")
    public int updateMember(@RequestBody MemberDTO dto) {
        System.out.println(dto);
        return service.updateMember(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginMember(@RequestBody MemberDTO dto) {
        System.out.println("로그인 "+dto);
        MemberDTO user = service.loginMember(dto);
        if(user != null) {
            // 토큰 생성
            final String token = tokenProvider.create(user);
            user.setToken(token);
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(null);
        }
    }

    @GetMapping("/logintest")
    public ResponseEntity<?> loginTest() {
        MemberDTO dto = new MemberDTO();
        dto.setEmail("test@mail.com");
        dto.setPass("haha");
        MemberDTO user = service.loginMember(dto);
        System.out.println("user 받아왓나" + user);
        if(user != null) {
            // 토큰 생성
            //final String token = tokenProvider.create(user);
            //user.setToken(token);
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(null);
        }
    }

    @PostMapping("/idcheck")
    public int idCheckMember(@RequestBody MemberDTO dto) {
        return service.idCheckMember(dto);
    }
    @PostMapping("/googleLogin")
    public int googleLogin(@RequestBody MemberDTO dto) {
        return 0;//임시로지움
    }

    @PostMapping("/kakaoLogin")
    public int kakaoLogin(@RequestBody MemberDTO dto) {
        return 0;//임시로지움
    }
    @GetMapping("/mongo")
    public int testMongo() {
        //System.out.println("흐히히ㅣ");
        //testService.haha();
        //testService.test1();
        //testService.test2();
        //testService.test3();
        //testService.test4();
        //testService.test5();
        return 1515;//임시로지움
    }
}
