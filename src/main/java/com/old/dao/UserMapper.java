package com.old.dao;

import com.old.model.User;

public interface UserMapper {
   
    int insert(User record);
    int insertSelective(User record);
    public User queryUserInfoid(String userid);
    public User selectByPrimaryKey(String userid);
	public User queryUserInfo(String username);
	public User queryUserInfoemail(String email);
	boolean updateUser(User user);
	public User updateUser(String userid);
	User findUserById(String id);
	

	
}