package bit.project.lawbot.mapper;

import bit.project.lawbot.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {
	public List<PostDTO> selectPostList(PostDTO dto);
	public int insertPost(PostDTO dto);
	public PostDTO selectPost(PostDTO dto);
	public PostDTO deletePost(PostDTO dto);
	public PostDTO updatePost(PostDTO dto);
}
