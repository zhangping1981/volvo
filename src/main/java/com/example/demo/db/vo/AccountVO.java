package com.example.demo.db.vo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.domain.model.AccountStatus;
import lombok.Data;

import java.util.Date;


@Data
@TableName("account")
public class AccountVO {

    @TableId
    private String email;
    private String status;
    private Date lastUpdated;
}
