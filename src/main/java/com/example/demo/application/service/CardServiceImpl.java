package com.example.demo.application.service;

import com.example.demo.domain.model.Card;
import com.example.demo.domain.model.CardStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    // 模拟数据存储
    private List<Card> cards = new ArrayList<>();

    @Override
    public Card createCard(Card card) {
        // 设置ID（简单模拟）
        card.setId((long) (cards.size() + 1));
        cards.add(card);
        return card;

    }

    @Override
    public void assignCardToAccount(Long cardId, Long accountId) {

    }

    @Override
    public void changeCardStatus(Long cardId, CardStatus status) {
        cards.stream()
                .filter(card -> card.getId().equals(cardId))
                .findFirst()
                .ifPresent(card -> card.setStatus(status));
    }
}