package bit.project.lawbot.mapper;

import bit.project.lawbot.domain.BaseDTO;
import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
	public List<PostDTO> selectPostList(BaseDTO dto);
	public int insertPost(PostDTO dto);
	public PostDTO selectPost(PostDTO dto);
	public int deletePost(PostDTO dto);
	public int updatePost(PostDTO dto);
	public Long selectPostWriter(long post_idx);
	public int selectPostListCount(BaseDTO<PostDTO> dto);
}
