package com.example.demo.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.model.Card;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardMapper extends BaseMapper<Card> {
}