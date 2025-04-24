package com.example.demo.application.service;

import com.example.demo.domain.model.Account;
import com.example.demo.domain.model.AccountStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface AccountService {
    String  createAccount(Account account);
    String  changeAccountStatus(Account account);
    Account  getAccountByEmail(String email);
    ResponseEntity<?> getAccountByPage(int pageNum, int pageSize);

}