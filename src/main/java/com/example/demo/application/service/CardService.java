package com.example.demo.application.service;

import com.example.demo.domain.model.Card;
import com.example.demo.domain.model.CardStatus;

public interface CardService {
    String  createCard(Card card);
    void assignCardToAccount(Long cardId, Long accountId);
    void changeCardStatus(Long cardId, CardStatus status);



}