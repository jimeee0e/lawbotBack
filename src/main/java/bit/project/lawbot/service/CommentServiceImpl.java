package bit.project.lawbot.service;

import bit.project.lawbot.domain.AlarmDTO;
import bit.project.lawbot.domain.ChatDTO;
import bit.project.lawbot.domain.CommentDTO;
import bit.project.lawbot.domain.PostDTO;
import bit.project.lawbot.mapper.AlarmMapper;
import bit.project.lawbot.mapper.CommentMapper;
import bit.project.lawbot.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentMapper mapper;
	@Autowired
	AlarmMapper alarmMapper;
	@Autowired
	PostMapper PostMapper;

	@Override
	public List<CommentDTO> selectCommentList(CommentDTO dto) {
		return mapper.selectCommentList(dto);
	}

	@Override
	public long insertComment(CommentDTO dto) {
		int i = mapper.insertComment(dto);
		long comment_idx = dto.getComment_idx();
		System.out.println("코멘트아이디 잘ㅊ받아오나" + comment_idx);
		Long parentComment = mapper.selectCommentWriter(dto.getParent_comment_idx());

		if (parentComment != null && parentComment > 0){
			AlarmDTO alarmDTO = new AlarmDTO();
			alarmDTO.setMember_no(parentComment);
			alarmDTO.setComment_idx(comment_idx);
			alarmMapper.insertAlarm(alarmDTO);
		}
		Long parentPost = PostMapper.selectPostWriter(dto.getPost_idx());
		if (parentPost != null && parentPost > 0){
			AlarmDTO alarmDTO = new AlarmDTO();
			alarmDTO.setMember_no(parentPost);
			alarmDTO.setComment_idx(comment_idx);
			alarmMapper.insertAlarm(alarmDTO);
		}
		return comment_idx;
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
