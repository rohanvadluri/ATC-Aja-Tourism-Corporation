package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.ChatBotFaq;

@Repository
public interface ChatBotFaqRepo extends JpaRepository<ChatBotFaq, Long> {

}
