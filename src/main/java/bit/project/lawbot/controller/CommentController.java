package bit.project.lawbot.controller;

import bit.project.lawbot.domain.CommentDTO;
import bit.project.lawbot.domain.PostDTO;
import bit.project.lawbot.service.CommentService;
import bit.project.lawbot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
//    @Autowired
//    private TokenProvider tokenProvider;
    @Autowired
    CommentService service;

    @PostMapping("/getList")
    public List<CommentDTO> selectCommentList(@RequestBody CommentDTO dto){
        System.out.println("dto하하"+dto);
        return service.selectCommentList(dto);
    }

    @PostMapping("/get")
    public CommentDTO selectComment(@RequestBody CommentDTO dto){
        System.out.println(dto);
        return service.selectComment(dto);
    }

    @PostMapping("/write")
    public long insertComment(@RequestBody CommentDTO dto) {

        System.out.println("댓글쓰기 "+ dto);
        return service.insertComment(dto);
    }

    @PostMapping("/delete")
    public int deleteComment(@RequestBody CommentDTO dto) {
        return service.deleteComment(dto);
    }

    @PostMapping("/update")
    public int updateComment(@RequestBody CommentDTO dto) {
        System.out.println("업뎃코멘"+dto);
        return service.updateComment(dto);
    }
}
