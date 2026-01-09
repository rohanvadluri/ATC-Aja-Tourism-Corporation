package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.ChatBotFaqRequestDto;
import com.aja.Dto.ChatBotFaqResponseDto;
import com.aja.entity.ChatBotFaq;
import com.aja.repository.ChatBotFaqRepo;
import com.aja.service.ChatBotFaqService;

@Service
public class ChatBotFaqServiceImpl implements ChatBotFaqService {

	@Autowired
	private ChatBotFaqRepo chatBotFaqRepo;

	@Override
	public ChatBotFaqResponseDto savechatBotFaq(ChatBotFaqRequestDto faq) {
		// TODO Auto-generated method stub
		ChatBotFaq chatbot = new ChatBotFaq();
		
		BeanUtils.copyProperties(faq, chatbot);
		
		ChatBotFaq chatEntity = chatBotFaqRepo.save(chatbot);
		
		ChatBotFaqResponseDto chatRes = new ChatBotFaqResponseDto();
		
		BeanUtils.copyProperties(chatEntity, chatRes);
		
		return chatRes; 
	}

	@Override
	public List<ChatBotFaq> getAllFaqs() {
		// TODO Auto-generated method stub
		return chatBotFaqRepo.findAll();
	}

	@Override
	public ChatBotFaq getFaqById(Long faqId) {
		// TODO Auto-generated method stub
		return chatBotFaqRepo.findById(faqId).orElse(null);
	}

	@Override
	public ChatBotFaq updaBotFaq(long id, ChatBotFaq chatBotFaq) {
		// TODO Auto-generated method stub
		
		ChatBotFaq chatBotFaq2=chatBotFaqRepo.findById(id).orElse(null);
		chatBotFaq2.setQuestion(chatBotFaq.getQuestion());
		chatBotFaq2.setAnswer(chatBotFaq.getAnswer());
		return chatBotFaqRepo.save(chatBotFaq2);
		
	}

}
