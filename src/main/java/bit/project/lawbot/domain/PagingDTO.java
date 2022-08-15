package bit.project.lawbot.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
public class PagingDTO {
    private int page = 1;
    private int size = 10;

    public int start(){
        return (page - 1) * size;
    }
}
