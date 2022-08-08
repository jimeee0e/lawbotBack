package bit.project.lawbot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {
    private long commentid;
    private long postid;
    private String content;
    private long member_no;
    private String writer;
    private String pass;
    private Date reg_date;
    private Date update_date;
    private int islive;
}
