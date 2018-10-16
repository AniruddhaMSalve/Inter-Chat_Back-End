package com.inter_chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.JobDAO;
import com.inter_chat.Inter_Chat_Backend.model.Blog;
import com.inter_chat.Inter_Chat_Backend.model.Job;

public class JobDAOTest 
{
static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		jobDAO = (JobDAO) context.getBean("jobDAO");
	}
	
	@Ignore
	@Test
	public void postJobTest()
	{
		Job job=new Job();
		job.setJobName("test");
		job.setJobDesc("test");
		job.setCompanyName("test");
		job.setDesignation("test");
		job.setSalary("100000000");
		job.setStatus("test");
		job.setPostedDate(new java.util.Date());
		job.setLastDate(new java.util.Date());
		assertTrue("Problem in posting job:",jobDAO.postJob(job));
	}
	
	
	@Ignore
	@Test
	public void updateJobTest()
	{
		Job job=jobDAO.getJob(951);
		job.setJobName("test passed");
		job.setJobDesc("test passed");
		job.setCompanyName("test passed");
		job.setDesignation("test passed");
		job.setSalary("1111111111");
		job.setStatus("passed");
		assertTrue("Problem in updating job:",jobDAO.updateJob(job));
	}
	
	
	@Ignore
	@Test
	public void deleteJobTest()
	{
		Job job=jobDAO.getJob(951);
		assertTrue("Problem in deleting job:",jobDAO.deleteJob(job));
	}
	
	
//	@Ignore
	@Test
	public void listJobTest() 
	{
		List<Job> listJob = jobDAO.listJob();
		assertTrue("Problem in listing job:",listJob.size()>0);
		for (Job job : listJob) 
		{
			System.out.println(job.getJobName() + ": "+job.getCompanyName()+": "+job.getJobDesc()+": "+job.getDesignation()+": "+job.getSalary());
		}
	}
}