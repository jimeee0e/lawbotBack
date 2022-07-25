package bit.project.lawbot.service;

import bit.project.lawbot.domain.ChartDTO;
import bit.project.lawbot.mapper.ChartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Override
	public int mailTest() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setTo("woon.woon.jo@gmail.com");
		simpleMailMessage.setSubject("test");
		simpleMailMessage.setText("test");
		javaMailSender.send(simpleMailMessage);
		return 0;
	}
}
