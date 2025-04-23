package com.example.demo.web.controller;

import com.example.demo.application.service.CardService;
import com.example.demo.domain.model.Card;
import com.example.demo.web.controller.view.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/cards")
    public ResponseEntity<String> createCard(@RequestBody Card card) {
        // 调用服务层方法并接收返回的 String 类型结果
        String result = cardService.createCard(card);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/assign")
    public ResponseEntity assignCardToAccount(@RequestBody Card card) {
        String  result = cardService.assignCardToAccount(card);
        if(result ==null)
        {
            return  ResponseEntity.ok("Card created successfully");
        }
        else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PutMapping("/changestatus")
    public ResponseEntity changeCardStatus(@RequestBody Card card) {
       String result=  cardService.changeCardStatus(card);
       if(result ==null)
       {
           return  ResponseEntity.ok("Card status changed successfully");
       }
       else
       {
           return ResponseEntity.badRequest().body(result);
       }
    }

    @GetMapping("/getList")
    public ResponseEntity getCardList(@RequestBody PageView view) {
        return cardService.getCardsByPage(view.getPage(), view.getSize());
    }
}