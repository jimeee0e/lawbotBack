package bit.project.lawbot.domain;

import lombok.Data;

import java.util.List;

@Data
public class BaseDTO<T> {
    private List<T> list;
    private T dto;
    private PagingDTO paging;

    public BaseDTO(){
        this.paging = new PagingDTO();
    }
}
