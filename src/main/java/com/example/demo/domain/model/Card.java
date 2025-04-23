package com.example.demo.domain.model;

import java.util.regex.Pattern;



public class Card {
    private Long id;
    private String cardNumber;
    private String accountId; // 修改为 String 类型
    private CardStatus status;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
            this.accountId = accountId;

    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    // 新增校验方法
    private boolean isValidAccountId(String accountId) {
        if (accountId == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[A-Z]{2}[\\dA-Z]{3}[\\dA-Z]{9}", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(accountId).matches();
    }
}