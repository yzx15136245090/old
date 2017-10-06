package com.old.dao;

import com.old.model.Tip;

public interface TipMapper {
    int deleteByPrimaryKey(String tipid);

    int insert(Tip record);

    int insertSelective(Tip record);

    Tip selectByPrimaryKey(String tipid);

    int updateByPrimaryKeySelective(Tip record);

    int updateByPrimaryKey(Tip record);
}