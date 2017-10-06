package com.old.service;

import com.old.model.Chatmessage;

public interface ChatService {
int saveMessage(String userid1,String userid2,String message);
Chatmessage readMessage(String userid2);
}
