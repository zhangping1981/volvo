package com.example.demo.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.db.vo.AccountVO;
import com.example.demo.db.vo.CardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CardMapper extends BaseMapper<CardVO> {

    /**
     * 分页查询卡片列表
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 当前页的卡片列表
     */
    List<CardVO> selectByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 获取总记录数
     * @return 总记录数
     */
    int countAll();
}