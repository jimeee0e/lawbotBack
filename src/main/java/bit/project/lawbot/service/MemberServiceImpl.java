package bit.project.lawbot.service;

import bit.project.lawbot.domain.AuthDTO;
import bit.project.lawbot.domain.ChatDTO;
import bit.project.lawbot.domain.MemberDTO;
import bit.project.lawbot.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
		dto = mapper.selectMember(dto);
		return dto;
	}
	@Override
	public MemberDTO deleteMember(MemberDTO dto) {
		return mapper.deleteMember(dto);
	}
	@Override
	public int updateMember(MemberDTO dto) {return mapper.updateMember(dto);}
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

	@Override
	public int googleLogin(AuthDTO dto) {
		RestTemplate rest = new RestTemplate();
		rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		rest.getMessageConverters().add(new FormHttpMessageConverter());
		MultiValueMap<String,String> parameters = new LinkedMultiValueMap<>();
		//parameters.add("scope","https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile");
		System.out.println(dto + " 디티오 이렇지롱");

		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization" , "Bearer "+dto.getAccess_token());
		//headers.set("scope","https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile");
		HttpEntity<MultiValueMap> request = new HttpEntity<>(parameters, headers);

		ResponseEntity<String> responseEntity = rest.postForEntity("https://people.googleapis.com/v1/people/me",request,String.class);
		System.out.println(responseEntity + "구글로그인...제발제발하하하하....");
		return 0;
	}

	@Override
	public int kakaoLogin(AuthDTO dto) {
		//dto.setRedirect_uri("http://localhost:8080/kakaoLogin");
		RestTemplate rest = new RestTemplate();
		rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		rest.getMessageConverters().add(new FormHttpMessageConverter());
		MultiValueMap<String,String> parameters = new LinkedMultiValueMap<>();
		parameters.add("code",dto.getCode());
		parameters.add("redirect_uri", dto.getRedirect_uri());
		parameters.add("grant_type",dto.getGrant_type());
		parameters.add("client_id",dto.getClient_id());
//https://developers.naver.com/docs/login/api/api.md
		System.out.println(dto+"디티오 어떤데???");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap> request = new HttpEntity<>(parameters, headers);
		ResponseEntity<AuthDTO> responseEntity = rest.postForEntity("https://kauth.kakao.com/oauth/token",request,AuthDTO.class);
		System.out.println(responseEntity + "제발제발하하하하....");

		if(responseEntity.getStatusCode() == HttpStatus.OK){

			HttpHeaders headers2 = new HttpHeaders();
			headers2.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers2.set("Authorization" , "Bearer "+responseEntity.getBody().getAccess_token());
			MultiValueMap<String,String> parameters2 = new LinkedMultiValueMap<>();
			HttpEntity<MultiValueMap> request2 = new HttpEntity<>(parameters2, headers2);
			ResponseEntity<AuthDTO> responseEntity2 = rest.postForEntity("https://kapi.kakao.com/v2/user/me",request2,AuthDTO.class);
			System.out.println(responseEntity2 + "이것도제발되어주세요제발요....");


			MemberDTO memberDTO = new MemberDTO();

			memberDTO.setEmail(responseEntity2.getBody().getKakao_account().getEmail());
			memberDTO.setPlatform("KAKAO");
			memberDTO.setName(responseEntity2.getBody().getKakao_account().getProfile().getNickname());

			mapper.insertMember(memberDTO);
			//			insert into member values(0,#{email},#{name},#{pass},#{role},#{platform},1);
		}
		return 0;
	}
}
