package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.Blog;
import com.inter_chat.Inter_Chat_Backend.model.UserDetail;

public interface UserDetailDAO 
{
	public boolean addUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public boolean deleteUser(UserDetail userDetail);
	public List<UserDetail> listUserDetail();
	public UserDetail getUserDetail(String loginName);
	public UserDetail checkUserValidation(String loginName,String password);
}