package bit.project.lawbot.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
public class PagingDTO {
    private int page = 1;
    private int size = 10;

    private int maxPage;
    private int total;

    private String searchText;

    public int start(){
        return (page - 1) * size;
    }
    public void settingMaxPage() {
        this.maxPage = total / size;
        if(total % size > 0){
            this.maxPage++;
        }
    }
    public PagingDTO(){
        this.searchText = "";
    }
}
