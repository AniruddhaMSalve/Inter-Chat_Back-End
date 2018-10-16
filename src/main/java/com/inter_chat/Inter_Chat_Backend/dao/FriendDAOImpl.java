package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.Blog;
import com.inter_chat.Inter_Chat_Backend.model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addFriend(Friend friend) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteFriend(Friend friend) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateFriend(Friend friend) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Friend> listFriend() 
	{
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Friend");
		List<Friend> listFriend = query.list();
		session.close();
		return listFriend;
	}

	@Override
	public Friend getFriend(int friendId) 
	{
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class,friendId);
		session.close();
		return friend;
	}
}