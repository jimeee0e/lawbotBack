package bit.project.lawbot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {
    private long post_idx;
    private String category;
    private String title;
    private String content;
    private long member_no;
    private String writer;
    private String pass;
    private String ip;
    private Date reg_date;
    private Date update_date;
    private int islive;
}
