package bit.project.lawbot.service;

import bit.project.lawbot.domain.CommentDTO;
import bit.project.lawbot.domain.PostDTO;

import java.util.List;

public interface CommentService {
	public List<CommentDTO> selectCommentList(CommentDTO dto);
	public long insertComment(CommentDTO dto);
	public CommentDTO selectComment(CommentDTO dto);
	public int deleteComment(CommentDTO dto);
	public int updateComment(CommentDTO dto);
}
