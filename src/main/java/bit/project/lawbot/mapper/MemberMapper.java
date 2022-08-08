package bit.project.lawbot.mapper;

import bit.project.lawbot.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

	public int insertMember(MemberDTO dto);
	public MemberDTO selectMember(MemberDTO dto);
	public MemberDTO deleteMember(MemberDTO dto);
	public int updateMember(MemberDTO dto);
	public MemberDTO loginMember(MemberDTO dto);
	public int idCheckMember(MemberDTO dto);
}
