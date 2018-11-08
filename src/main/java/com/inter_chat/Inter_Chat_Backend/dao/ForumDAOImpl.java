package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addForum(Forum forum) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@Override
	public boolean approveForum(Forum forum) 
	{
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean rejectForum(Forum forum) 
	{
		try
		{
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Forum> listForum() 
	{
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Forum");
		List<Forum> listForum = query.list();
		session.close();
		return listForum;
	}

	@Override
	public Forum getForum(int forumId) 
	{
		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class,forumId);
		session.close();
		return forum;
	}
}