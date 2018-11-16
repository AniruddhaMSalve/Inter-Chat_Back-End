package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.Friend;
import com.inter_chat.Inter_Chat_Backend.model.UserDetail;

@Repository("friendDAO")
@Transactional
@Service
public class FriendDAOImpl implements FriendDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean sendFriendRequest(Friend friend) 
	{
		try
		{
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean acceptFriendRequest(int friendId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteFriendRequest(int friendId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Friend> listFriend(String loginName) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where(loginName=:myloginName or friendLoginName=:friendlogin) and status='A'");
		query.setParameter("myloginName",loginName);
		query.setParameter("friendlogin",loginName);
		
		List<Friend> listFriend=(List<Friend>)query.list();
		session.close();
		return listFriend;
	}

	@Override
	public List<Friend> pendingFriend(String loginName) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where friendLoginName=:myloginname and status='P'");
		query.setParameter("myloginname",loginName);
		List<Friend> listFriend=query.list();
		session.close();
		return listFriend;
	}

	@Override
	public List<UserDetail> suggestedFriend(String loginName) 
	{
		Session session=sessionFactory.openSession();
		Query sqlQuery=session.createQuery("select loginName from UserDetail where loginName not in (select friendLoginName from Friend where loginName='"+loginName+"') and loginName not in (select loginName from Friend where friendLoginName='"+loginName+"' and status='A') and loginName!='"+loginName+"'");
		List<String> listUser=(List<String>)sqlQuery.list();
		ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
		int i=0;
		while(i<listUser.size())
		{
			UserDetail userDetail=session.get(UserDetail.class,listUser.get(i).toString().trim());
			listUserDetail.add(userDetail);
			i++;
		}
		session.close();
		return listUserDetail;
	}
}