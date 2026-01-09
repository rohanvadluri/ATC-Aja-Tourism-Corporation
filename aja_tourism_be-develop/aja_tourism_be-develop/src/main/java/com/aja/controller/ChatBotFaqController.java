package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.ChatBotFaqRequestDto;
import com.aja.Dto.ChatBotFaqResponseDto;
import com.aja.entity.ChatBotFaq;
import com.aja.serviceImpl.ChatBotFaqServiceImpl;

@RestController
@RequestMapping("/api/chatbotfaq")
@CrossOrigin("*")
public class ChatBotFaqController {
	
	@Autowired
	private ChatBotFaqServiceImpl chatBotFaqServiceImpl;
	
	@PostMapping("/add")
    public ResponseEntity<ChatBotFaqResponseDto> addFaq(@RequestBody ChatBotFaqRequestDto faq) {
		
		
		ChatBotFaqResponseDto chatRes = chatBotFaqServiceImpl.savechatBotFaq(faq);
        return ResponseEntity.ok(chatRes);
    }
	
	@GetMapping("/all")
    public List<ChatBotFaq> getAllFaqs() {
        return chatBotFaqServiceImpl.getAllFaqs();
    }
	
	@GetMapping("/{id}")	
		public ResponseEntity<ChatBotFaq> getChatById(@PathVariable("id") long ChatBotFaqId){
			ChatBotFaq chatFaq =chatBotFaqServiceImpl.getFaqById(ChatBotFaqId);
			return ResponseEntity.ok(chatFaq);
		}
	
	@PutMapping("/update/{id}")
	public ChatBotFaq updateFaq(@PathVariable Long id, @RequestBody ChatBotFaq chatBotFaq)
	{
	    return chatBotFaqServiceImpl.updaBotFaq(id, chatBotFaq);
	}

	
	}
	
