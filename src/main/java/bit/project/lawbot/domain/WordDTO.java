package bit.project.lawbot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class WordDTO {
    private long cloud_idx;
    private String word;
    private long count;
    private Date date;
}
