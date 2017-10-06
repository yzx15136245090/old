package com.old.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.old.model.Buymessage;

public interface BuymessageMapper {
    int deleteByPrimaryKey(String buymessageid);

    int insert(Buymessage record);

    int insertSelective(Buymessage record);

    Buymessage selectByPrimaryKey(String buymessageid);

    int updateByPrimaryKeySelective(Buymessage record);
    int findBuymessageNumber(int buystatus);
    int updateByPrimaryKey(Buymessage record);
    List<Buymessage> allMessage(int buystatus);
    List<Buymessage> findBuymessageByLImit(@Param("buystatus")int buystatus,@Param("startPage")Integer startPage,@Param("pageSize")Integer pageSize);
}