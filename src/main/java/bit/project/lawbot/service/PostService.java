package bit.project.lawbot.service;

import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.domain.PostDTO;

import java.util.List;

public interface PostService {
	public List<PostDTO> selectPostList(PostDTO dto);
	public int insertPost(PostDTO dto);
	public PostDTO selectPost(PostDTO dto);
	public PostDTO deletePost(PostDTO dto);
	public PostDTO updatePost(PostDTO dto);
}
