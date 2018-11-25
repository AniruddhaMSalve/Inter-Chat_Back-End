package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter_chat.Inter_Chat_Backend.model.ApplyJob;
import com.inter_chat.Inter_Chat_Backend.model.Job;

@Service
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public JobDAOImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	@Transactional
	public boolean addJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteJob(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public Job getJob(int jobId) {
		try {
			Session session = sessionFactory.openSession();
			Job job = session.get(Job.class, jobId);
			return job;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> listAllJobs() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Job> jobList = new ArrayList<Job>();
			Query query = session.createQuery("FROM Job");
			jobList = query.list();
			return jobList;
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	@Override
	public boolean applyJob(ApplyJob applyJob) {
		try {
			sessionFactory.getCurrentSession().save(applyJob);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyJob> getAllAppliedJobDetails(String loginName) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<ApplyJob> appliedjobList = new ArrayList<ApplyJob>();
			Query query = session.createQuery("FROM ApplyJob where loginName=:myloginName");
			query.setParameter("myloginName", loginName);
			appliedjobList = query.list();
			return appliedjobList;
		} catch (Exception e) {
			return null;
		}
	}
}