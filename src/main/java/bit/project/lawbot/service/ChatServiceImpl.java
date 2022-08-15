package bit.project.lawbot.service;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.domain.ChatDTO;
import bit.project.lawbot.mapper.ChartMapper;
import bit.project.lawbot.mapper.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	ChatMapper mapper;

	@Override
	public ChatDTO insertChatLog(ChatDTO dto) {
		int i = mapper.insertChatLog(dto);
		if (i>0){
			System.out.println(" 하ㅏ하하하" + dto );
			RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
			ResponseEntity<ChatDTO> responseEntity = template.postForEntity("http://localhost:5000/send",dto,ChatDTO.class);

			System.out.println(responseEntity.getStatusCode()+" 스태터스코드");

			dto = responseEntity.getBody();
			System.out.println( dto +"바디바디!");
		}
		return dto;
	}
}
