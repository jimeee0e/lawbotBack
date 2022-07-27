package bit.project.lawbot.service;

import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.domain.PostDTO;
import bit.project.lawbot.mapper.MemberMapper;
import bit.project.lawbot.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostMapper mapper;

	@Override
	public List<PostDTO> selectPostList(PostDTO dto) {
		return mapper.selectPostList(dto);
	}

	@Override
	public int insertPost(PostDTO dto) {
		return mapper.insertPost(dto);
	}

	@Override
	public PostDTO selectPost(PostDTO dto) {
		return mapper.selectPost(dto);
	}

	@Override
	public PostDTO deletePost(PostDTO dto) {
		return mapper.deletePost(dto);
	}

	@Override
	public PostDTO updatePost(PostDTO dto) {
		return mapper.updatePost(dto);
	}
}
