package bit.project.lawbot.controller;

import bit.project.lawbot.domain.BaseDTO;
import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.domain.PostDTO;
import bit.project.lawbot.service.MemberService;
import bit.project.lawbot.service.MongoService;
import bit.project.lawbot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
//    @Autowired
//    private TokenProvider tokenProvider;
    @Autowired
    PostService service;

    @PostMapping("/getList")
    public BaseDTO<PostDTO> selectPostList(@RequestBody BaseDTO<PostDTO> dto){
        System.out.println("dto하하"+dto);
        return service.selectPostList(dto);
    }
//    @PostMapping("/getList")
//    public List<PostDTO> selectPostList(@RequestBody PostDTO dto){
//        System.out.println("dto하하"+dto);
//        return service.selectPostList(dto);
//    }

    @PostMapping("/get")
    public PostDTO selectPost(@RequestBody PostDTO dto){
        System.out.println(dto);
        return service.selectPost(dto);
    }

    @PostMapping("/write")
    public int insertPost(@RequestBody PostDTO dto) {
        return service.insertPost(dto);
    }

    @PostMapping("/delete")
    public int deletePost(@RequestBody PostDTO dto) {
        return service.deletePost(dto);
    }

    @PostMapping("/update")
    public int updatePost(@RequestBody PostDTO dto) {
        return service.updatePost(dto);
    }
}
