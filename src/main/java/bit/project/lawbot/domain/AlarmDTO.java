package bit.project.lawbot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class AlarmDTO {
    private long alarm_idx;
    private long member_no;
    private long comment_idx;
    private Date date;
    private int islive;


    private long post_idx;
    private String post_title;
    private String my_comment_content;
}
