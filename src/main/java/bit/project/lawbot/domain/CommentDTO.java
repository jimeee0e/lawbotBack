package bit.project.lawbot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {

    private long comment_idx;
    private long post_idx;
    private long parent_comment_idx;
    private int level = 1;
    private String content;
    private long member_no;
    private String writer;
    private String pass;
    private String ip;
    private Date reg_date;
    private Date update_date;
    private int islive;
}
