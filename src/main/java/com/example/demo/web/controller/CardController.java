package com.example.demo.web.controller;

import com.example.demo.application.service.CardService;
import com.example.demo.domain.model.Card;
import com.example.demo.domain.model.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @PutMapping("/{id}/assign")
    public void assignCardToAccount(@PathVariable Long id, @RequestParam Long accountId) {
        cardService.assignCardToAccount(id, accountId);
    }

    @PutMapping("/{id}/status")
    public void changeCardStatus(@PathVariable Long id, @RequestParam CardStatus status) {
        cardService.changeCardStatus(id, status);
    }
}