package com.old.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.old.model.Buymessage;
import com.old.model.Goods;


public interface BuymessageService {
	void ReleaseBuymessage(Buymessage buymessage,HttpServletRequest request,HttpSession session);
	List<Buymessage> allBuymessage(int buystatus,Integer startPage,Integer pageSize);
	List<Buymessage> allBuymessage(int buystatus);
	int findBuymessageNumber(int buystatus);
}
