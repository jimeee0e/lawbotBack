package bit.project.lawbot.service;

import bit.project.lawbot.domain.CommentDTO;
import bit.project.lawbot.domain.PostDTO;

import java.util.List;

public interface CommentService {
	public List<CommentDTO> selectCommentList(CommentDTO dto);
	public int insertComment(CommentDTO dto);
	public CommentDTO selectComment(CommentDTO dto);
	public CommentDTO deleteComment(CommentDTO dto);
	public CommentDTO updateComment(CommentDTO dto);
}
