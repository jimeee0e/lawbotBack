package bit.project.lawbot.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "statute")
@Data
public class StatuteDTO {
    private String _id;
    private String 법령아이디;
    private String 법령명한글;

    private String 법령명약칭;
    private String 조문키;
    private String 조문번호;
    private String 조문가지번호;

    private String 조문제목;
    private String 조문내용;

    private List<Map<String,Object>> 항;
}
