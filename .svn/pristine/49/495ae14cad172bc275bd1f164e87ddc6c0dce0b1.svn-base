package com.old.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.old.model.Chatmessage;
import com.old.model.Goods;
import com.old.model.User;
import com.old.service.ChatService;
import com.old.service.GoodsService;

@Controller
public class ChatController{
	@Resource
	ChatService chatService;
	@Resource
	GoodsService goodsService;
	
	
	@ResponseBody
	@RequestMapping(value = "/savemessage")
	public String saveChat(String userid1,String userid2,String message,String date) {
		chatService.saveMessage(userid1, userid2, message);
		
		return "发送失败，请重试！";
	}
	@ResponseBody
	@RequestMapping(value = "/readmessage")
	public Chatmessage readChat(String userid2) {
		chatService.readMessage(userid2);
		
		return chatService.readMessage(userid2);
	}
	@RequestMapping("/tochat")
	public String tochat(Model model,String goodsid,HttpServletRequest request) {
	Goods goods=goodsService.goodsDetail(goodsid,request);
		model.addAttribute("goods", goods);
		return "chat";
		
	}
}