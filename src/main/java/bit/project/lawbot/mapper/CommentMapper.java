package bit.project.lawbot.mapper;

import bit.project.lawbot.domain.CommentDTO;
import bit.project.lawbot.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
	public List<CommentDTO> selectCommentList(CommentDTO dto);
	public int insertComment(CommentDTO dto);
	public CommentDTO selectComment(CommentDTO dto);
	public int deleteComment(CommentDTO dto);
	public int updateComment(CommentDTO dto);
	public Long selectCommentWriter(long comment_idx);
}
