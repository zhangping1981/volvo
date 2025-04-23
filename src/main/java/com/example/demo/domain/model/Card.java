package com.example.demo.domain.model;

import com.example.demo.db.vo.CardVO;
import lombok.Data;

import java.util.regex.Pattern;



@Data
public class Card {

    private Long id;
    private String email;
    private String contractId;
    private String cardNumber;
    private CardStatus status;


    // 新增校验方法
    public boolean isValidContractId() {
        if (contractId == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[A-Z]{2}[\\dA-Z]{3}[\\dA-Z]{9}", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(contractId).matches();
    }

    public String validateEmail() {
        if (email == null || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return "Invalid email format";
        }
        return null;
    }
    // 新增随机生成 accountId 的方法
    public void  generateRandomAccountId() {
        StringBuilder sb = new StringBuilder();
        
        // 生成前两位大写字母
        for (int i = 0; i < 2; i++) {
            char randomChar = (char) ('A' + (int) (Math.random() * 26));
            sb.append(randomChar);
        }
        
        // 生成接下来的 3 位数字或字母
        for (int i = 0; i < 3; i++) {
            char randomChar = (char) ('A' + (int) (Math.random() * 36));
            if (randomChar > 'Z') {
                randomChar = (char) ('0' + (randomChar - 'Z' - 1));
            }
            sb.append(randomChar);
        }
        
        // 生成最后 9 位数字或字母
        for (int i = 0; i < 9; i++) {
            char randomChar = (char) ('A' + (int) (Math.random() * 36));
            if (randomChar > 'Z') {
                randomChar = (char) ('0' + (randomChar - 'Z' - 1));
            }
            sb.append(randomChar);
        }
        
        this.contractId= sb.toString();
    }

    public CardVO convertToVO() {
        CardVO cardVO = new CardVO();
        cardVO.setId(id);
        cardVO.setEmail(email);
        cardVO.setContractId(contractId);
        if(status ==null)
        {
            status = CardStatus.ACTIVE;
        }
        cardVO.setStatus(status.name());
        return cardVO;
    }

}