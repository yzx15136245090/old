package com.old.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.old.dao.BuymessageMapper;
import com.old.dao.UserMapper;
import com.old.model.Buymessage;
import com.old.model.GoodsMore;
import com.old.model.User;
import com.old.service.BuymessageService;
@Service
public class BuymessageServiceImpl implements BuymessageService{
Buymessage buymessage;
User user;
@Resource
BuymessageMapper buymessageMapper;
@Resource
UserMapper userMapper;
	public void ReleaseBuymessage(Buymessage buymessage,
			HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		String buyid = UUID.randomUUID().toString().replace("-", "");
		buymessage.setBuymessageid(buyid);
		buymessage.setCreatdate(new Date());
		buymessage.setBuystatus(0);
		User user=new User();
		user=(User) session.getAttribute("user");
		buymessage.setUserid(user.getUserid());
		buymessageMapper.insert(buymessage);
	}
	public List<Buymessage> allBuymessage(int buystatus) {
		// TODO Auto-generated method stub
		return buymessageMapper.allMessage(buystatus);
	}
	public List<Buymessage> allBuymessage(int buystatus, Integer startPage,
			Integer pageSize) {
		// TODO Auto-generated method stub
		int size = startPage*pageSize;
		List<Buymessage> findBuymessageByLImit = buymessageMapper.findBuymessageByLImit(buystatus, size, pageSize);
		for(int i=0;i<findBuymessageByLImit.size();i++)
		{	
			Buymessage buymessage=findBuymessageByLImit.get(i);
			System.out.println(buymessage.getUserid());
			user=userMapper.selectByPrimaryKey(buymessage.getUserid());
			buymessage.setUsername(user.getUsername());
		}
		return findBuymessageByLImit;
	}
public int findBuymessageNumber(int buystatus) {
		
		return buymessageMapper.findBuymessageNumber(buystatus);
	}

}
