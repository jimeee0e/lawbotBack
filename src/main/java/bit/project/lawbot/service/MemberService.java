package bit.project.lawbot.service;

import bit.project.lawbot.domain.MemberDTO;
public interface MemberService {
	public int insertMember(MemberDTO dto);
	public MemberDTO selectMember(MemberDTO dto);
	public MemberDTO deleteMember(MemberDTO dto);
	public int updateMember(MemberDTO dto);
	public MemberDTO loginMember(MemberDTO dto);
	public int idCheckMember(MemberDTO dto);
}
