package com.example.demo.web.controller;

import com.example.demo.application.service.AccountService;
import com.example.demo.domain.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity createAccount(@RequestBody Account account) {


        String result =  accountService.createAccount(account);
        if(result == null)
        {
            return ResponseEntity.ok("Account created successfully");
        }
        else {
            return ResponseEntity.badRequest().body(result);
        }



    }

    @PutMapping("/changestatus")
    public ResponseEntity changeAccountStatus(@RequestBody Account account) {
       String result =   accountService.changeAccountStatus(account);
       if(result ==null)
       {
           return ResponseEntity.ok("Account status changed successfully");
           }
       else {
           return ResponseEntity.badRequest().body(result);
       }

    }


}