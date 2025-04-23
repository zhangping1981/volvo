package com.example.demo.application.service;

import com.example.demo.infrastructure.vo.AccountVO;
import com.example.demo.domain.model.Account;
import com.example.demo.infrastructure.mapper.AccountMapper; // 引入数据库操作接口
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper; // 注入数据库操作接口

    @Override
    public String  createAccount(Account account) {

       String result =  account.validateEmail();
       if(result == null )
       {
           AccountVO accountVO = account.convertToVO();

           AccountVO vo = accountMapper.selectById(accountVO.getEmail());
           if(vo!=null)
           {
               return "Account already exists";
           }

           accountVO.setLastUpdated(new Date());
           accountMapper.insert(accountVO);
       return null;}
       else {

           return result;
       }
    }

    @Override
    public String  changeAccountStatus(Account account) {

        AccountVO accountVO = accountMapper.selectById(account.getEmail());
        if(accountVO== null)
        {
            return "Account not found";
        }
        accountVO.setStatus(account.getStatus().name());
        accountMapper.updateById(accountVO);
        return null;
    }

    @Override
    public Account getAccountByEmail(String email) {

        AccountVO vo =  accountMapper.selectById(email);
        if(vo == null)
        {
            return null;
        }
        return Account.convertToDomain(vo);
    }

}