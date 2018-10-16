package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.ApplyingJob;

@Repository("applyingJobDAO")
@Transactional
public class ApplyingJobDAOImpl implements ApplyingJobDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean postApplyingJob(ApplyingJob applyingJob) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(applyingJob);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteApplyingJob(ApplyingJob applyingJob) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(applyingJob);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateApplyingJob(ApplyingJob applyingJob) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(applyingJob);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<ApplyingJob> listApplyingJob() 
	{
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from ApplyingJob");
		List<ApplyingJob> listAppliedJob = query.list();
		session.close();
		return listAppliedJob;
	}

	@Override
	public ApplyingJob getApplyingJob(int applyJobId) 
	{
		Session session=sessionFactory.openSession();
		ApplyingJob applyingJob=(ApplyingJob)session.get(ApplyingJob.class,applyJobId);
		session.close();
		return applyingJob;
	}
}