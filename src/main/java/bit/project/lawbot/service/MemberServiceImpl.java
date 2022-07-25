package bit.project.lawbot.service;

import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper mapper;
	@Autowired
	PasswordEncoder pwdEncoder;

	@Override
	public int insertMember(MemberDTO dto) {
		dto.setPass(pwdEncoder.encode(dto.getPass()));
		return mapper.insertMember(dto);
	}
	@Override
	public MemberDTO selectMember(MemberDTO dto) {
		//임시
		dto.setPk_member_no(5);
		String rawPass = dto.getPass();
		dto = mapper.selectMember(dto);
		if(pwdEncoder.matches(rawPass, dto.getPass())){
			System.out.println("맞음");
		}else{
			System.out.println("틀림");
		}
		return dto;
	}
	@Override
	public MemberDTO deleteMember(MemberDTO dto) {
		return mapper.deleteMember(dto);
	}
	@Override
	public MemberDTO updateMember(MemberDTO dto) {return mapper.updateMember(dto);}
	@Override
	public MemberDTO loginMember(MemberDTO dto) {
		String rawPass = dto.getPass();
		dto = mapper.loginMember(dto);
		//메일이 없을때
		if(pwdEncoder.matches(rawPass, dto.getPass())){
			return dto;
		}else{
			return null;
		}
	}

	@Override
	public int idCheckMember(MemberDTO dto) {
		return mapper.idCheckMember(dto);
	}
}
