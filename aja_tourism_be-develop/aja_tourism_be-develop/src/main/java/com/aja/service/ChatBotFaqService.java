package com.aja.service;

import java.util.List;

import com.aja.Dto.ChatBotFaqRequestDto;
import com.aja.Dto.ChatBotFaqResponseDto;
import com.aja.entity.ChatBotFaq;

public interface ChatBotFaqService {


	public ChatBotFaqResponseDto savechatBotFaq(ChatBotFaqRequestDto chatBotFaq);


	public List<ChatBotFaq> getAllFaqs();

	public ChatBotFaq getFaqById(Long faqId);
	
	public ChatBotFaq updaBotFaq(long id , ChatBotFaq chatBotFaq);
	

}
