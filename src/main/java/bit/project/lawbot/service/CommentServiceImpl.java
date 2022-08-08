package bit.project.lawbot.service;

import bit.project.lawbot.domain.CommentDTO;
import bit.project.lawbot.domain.PostDTO;
import bit.project.lawbot.mapper.CommentMapper;
import bit.project.lawbot.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentMapper mapper;

	@Override
	public List<CommentDTO> selectCommentList(CommentDTO dto) {
		return mapper.selectCommentList(dto);
	}

	@Override
	public int insertComment(CommentDTO dto) {
		return mapper.insertComment(dto);
	}

	@Override
	public CommentDTO selectComment(CommentDTO dto) {
		return mapper.selectComment(dto);
	}

	@Override
	public CommentDTO deleteComment(CommentDTO dto) {
		return mapper.deleteComment(dto);
	}

	@Override
	public CommentDTO updateComment(CommentDTO dto) {
		return mapper.updateComment(dto);
	}
}
