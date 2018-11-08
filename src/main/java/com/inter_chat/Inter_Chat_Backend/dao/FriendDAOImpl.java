package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.Friend;
import com.inter_chat.Inter_Chat_Backend.model.UserDetail;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean sendFriend(Friend friend) 
	{
		return false;
	}

	@Override
	public boolean acceptFriend(Friend friend) 
	{
		return false;
	}

	@Override
	public boolean deleteFriend(Friend friend) 
	{
		return false;
	}

	@Override
	public List<Friend> listFriend(String loginName) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from friend where(loginName=:myloginName or friendloginName=:friendlogin) and status='A'");
		query.setParameter("myloginName",loginName);
		query.setParameter("friendlogin",loginName);
		
		List<Friend> listFriend=(List<Friend>)query.list();
		session.close();
		return listFriend;
	}

	@Override
	public List<Friend> pendingFriend(String loginName) 
	{
		return null;
	}

	@Override
	public List<UserDetail> suggestedFriend(String loginName) 
	{
		return null;
	}
}