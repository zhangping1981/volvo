package com.example.demo.domain.model;

import com.example.demo.infrastructure.vo.AccountVO;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Account {


    private Long id;
    private String email; // 唯一标识
    private String contractId;
    private AccountStatus status;
    private Date lastUpdated;

    public String validateEmail()
    {
        if (email == null || email.isEmpty()) {
            return "Email cannot be empty";
        }
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return "Invalid email format";
        }
        return null;
    }

    public static  Account convertToDomain(AccountVO accountVO)
    {
        Account account = new Account();
        account.setEmail(accountVO.getEmail());
        account.setStatus(AccountStatus.valueOf(accountVO.getStatus()));
        account.setLastUpdated(accountVO.getLastUpdated());
        return account;
    }

    public AccountVO convertToVO()
    {
        AccountVO accountVO = new AccountVO();
        accountVO.setEmail(email);
        if(status ==null)
        {
            //the default status is active
            status = AccountStatus.ACTIVE;
        }
        accountVO.setStatus(status.name());
        return  accountVO;
    }

}