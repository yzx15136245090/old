package com.old.dao;

import com.old.model.Chatmessage;

public interface ChatmessageMapper {
    int deleteByPrimaryKey(String chatid);

    int insert(Chatmessage record);

    int insertSelective(Chatmessage record);

    Chatmessage selectByPrimaryKey(String chatid);
    Chatmessage selectByUserId2(String userid2);
    int updateByPrimaryKeySelective(Chatmessage record);

    int updateByPrimaryKey(Chatmessage record);
}