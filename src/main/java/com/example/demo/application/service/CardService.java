package com.example.demo.application.service;

import com.example.demo.domain.model.Card;
import com.example.demo.domain.model.CardStatus;
import org.springframework.http.ResponseEntity;

public interface CardService {
   
    // 保留原有方法
    String createCard(Card card);
    String assignCardToAccount(Card card);
    String changeCardStatus(Card card);

    // 新增分页查询方法
    ResponseEntity<?> getCardsByPage(int pageNum, int pageSize);
}