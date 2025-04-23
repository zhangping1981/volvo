package com.example.demo.application.service;

import com.example.demo.domain.model.Account;
import com.example.demo.infrastructure.vo.CardVO;
import com.example.demo.domain.model.Card;
import com.example.demo.infrastructure.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardServiceImpl implements CardService {
    
    @Autowired
    private CardMapper cardMapper;

    @Autowired AccountService accountService;

    @Override
    public String createCard(Card card) {
        // 使用 CardMapper 将卡片信息写入数据库
        CardVO cardVO = card.convertToVO();
        cardVO.setLastUpdated(new Date());
        cardMapper.insert(cardVO);
        // 返回成功消息或生成的卡片 ID
        return null;
    }

    @Override
    public String assignCardToAccount(Card card) {

        Account account = accountService.getAccountByEmail(card.getEmail());

        if( account == null)
        {
            return "There is no account with email"+ card.getEmail();
        }

        Map<String,Object> tempMap = new HashMap<String, Object>();
        tempMap.put("email",card.getEmail());
        List<CardVO>  list =  cardMapper.selectByMap(tempMap);
        if(list!=null && list.size()>0)
        {
            String contractId = list.get(0).getContractId();
            if(!contractId.equals(card.getContractId()))
            {
                 return "There is already a card with contract id "+ card.getContractId()+" assigned to account "+card.getEmail();
            }

        }
        // 实现分配卡片到账户的逻辑
        CardVO cardVO = card.convertToVO();
        cardVO.setLastUpdated(new Date());
         cardMapper.updateById(cardVO);
         return null;
    }

    @Override
    public String changeCardStatus(Card card) {
        // 实现更改卡片状态的逻辑
        CardVO cardvo = cardMapper.selectById(card.convertToVO().getId());
        if (cardvo != null) {
            cardvo.setStatus(card.getStatus().name());
            cardvo.setLastUpdated(new Date());
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