package com.old.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.old.dao.UserMapper;
import com.old.model.User;

@Service
public class UserService {
	@Resource
	public  UserMapper userMap;

	public User queryUserByUserName(String username) {
		return userMap.queryUserInfo(username);
	}
	public User queryUserByUserid(String userid) {
		return userMap.queryUserInfoid(userid);
	}
	public User queryUserByUseremail(String email) {
		return userMap.queryUserInfoemail(email);
	}

	public int insertUser(User user){
		return userMap.insert(user);
	}
	
	public boolean updateUser(User user){
		
		return userMap.updateUser(user);
	}
	
	public User findUserById(String id){
		User user = userMap.findUserById(id);
		return user;
	}

	
	
	

}
