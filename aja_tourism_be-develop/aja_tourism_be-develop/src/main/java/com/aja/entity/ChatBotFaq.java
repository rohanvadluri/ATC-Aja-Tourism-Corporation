package com.aja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ChatBotFaq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long faqId;

	private String question;

	private String answer;

}
