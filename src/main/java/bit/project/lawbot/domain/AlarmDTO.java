package bit.project.lawbot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class AlarmDTO {
    private long alarm_idx;
    private long my_member_no;
    private long comment_idx;
    private int islive;
}
