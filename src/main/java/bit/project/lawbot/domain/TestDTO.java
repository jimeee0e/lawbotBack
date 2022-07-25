package bit.project.lawbot.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Document(collection = "test")
@Data
public class TestDTO {
    private String _id;
    private String 판례번호;
    private String 사건번호;

    private String 사건명;
    private String 소송유형;
    private String 담당법원;
    private String 결과;
    private ArrayList<Map<String,String>> 본문;
    //private ArrayList<Map<String,String>> 각주; 로 하면 안됨
    private Map<String,String> 각주;
    private ArrayList<String> 참조조문;
}
