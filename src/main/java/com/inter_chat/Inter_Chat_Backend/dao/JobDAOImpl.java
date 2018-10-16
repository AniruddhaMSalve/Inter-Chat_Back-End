package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.Blog;
import com.inter_chat.Inter_Chat_Backend.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean postJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Job> listJob() 
	{
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Job");
		List<Job> listJob = query.list();
		session.close();
		return listJob;
	}

	@Override
	public Job getJob(int jobId) 
	{
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class,jobId);
		session.close();
		return job;
	}
}