package com.example.demo.infrastructure.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.domain.model.CardStatus;
import lombok.Data;

import java.util.Date;


@TableName("card")

@Data
public class CardVO {

    @TableId
    private Long id;
    private String email;
    private String contractId;
    private String status;
    private String cardNumber;
    private Date lastUpdated;
}
