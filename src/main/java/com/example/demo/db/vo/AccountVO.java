package com.example.demo.db.vo;


import com.example.demo.domain.model.AccountStatus;
import lombok.Data;

import java.util.Date;


@Data
public class AccountVO {
    private String email;
    private String status;
    private Date lastUpdated;
}
