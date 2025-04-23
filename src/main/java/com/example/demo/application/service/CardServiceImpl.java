package com.example.demo.application.service;

import com.example.demo.db.vo.CardVO;
import com.example.demo.domain.model.Card;
import com.example.demo.domain.model.CardStatus;
import com.example.demo.infrastructure.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardServiceImpl implements CardService {
    
    @Autowired
    private CardMapper cardMapper;

    @Override
    public String createCard(Card card) {
        // 使用 CardMapper 将卡片信息写入数据库
        cardMapper.insert(card.convertToVO());
        return null;
    }

    @Override
    public String assignCardToAccount(Card card) {
        // 实现分配卡片到账户的逻辑
        int result = cardMapper.updateById(card.convertToVO());
        if (result == 1) {
            return null;
        }
        return "There is no card with id " + card.getId();
    }

    @Override
    public String changeCardStatus(Card card) {
        // 实现更改卡片状态的逻辑
        CardVO cardvo = cardMapper.selectById(card.convertToVO().getId());
        if (cardvo != null) {
            cardvo.setStatus(card.getStatus().name());
            cardMapper.updateById(cardvo);
        } else {
            return "Card not found";
        }
        return null;
    }

    @Override
    public ResponseEntity<?> getCardsByPage(int pageNum, int pageSize) {
        // 调用 CardMapper 的分页查询方法
        List<CardVO> cardList = cardMapper.selectByPage(pageNum, pageSize);
        int total = cardMapper.countAll();

        // 构造分页结果
        Map<String, Object> response = new HashMap<>();
        response.put("total", total);
        response.put("data", cardList);

        return ResponseEntity.ok(response);
    }
}