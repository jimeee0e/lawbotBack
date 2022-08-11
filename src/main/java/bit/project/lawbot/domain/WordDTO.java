package bit.project.lawbot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class WordDTO {
    private long postid;
    private String category;
    private String title;
    private String content;
    private long member_no;
    private Date reg_date;
    private Date update_date;
    private int islive;
}
