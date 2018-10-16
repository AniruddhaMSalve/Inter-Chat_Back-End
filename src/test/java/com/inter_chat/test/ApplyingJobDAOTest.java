package com.inter_chat.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.ApplyingJobDAO;
import com.inter_chat.Inter_Chat_Backend.model.ApplyingJob;

public class ApplyingJobDAOTest 
{
	static ApplyingJobDAO applyingJobDAO;
	
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		applyingJobDAO = (ApplyingJobDAO) context.getBean("applyingJobDAO");
	}
	
	@Ignore
	@Test
	public void postApplyingJobTest()
	{
		ApplyingJob applyingJob=new ApplyingJob();
		applyingJob.setJobId(100);
		applyingJob.setLoginName("test");
		applyingJob.setAppliedDate(new java.util.Date());
		assertTrue("Problem in applying for job:", applyingJobDAO.postApplyingJob(applyingJob));
	}
	
	@Ignore
	@Test
	public void deleteApplyingJobTest()
	{
		ApplyingJob applyingJob=applyingJobDAO.getApplyingJob(951);
		assertTrue("Problem in deleting applied job:", applyingJobDAO.deleteApplyingJob(applyingJob));
	}
	
	@Ignore
	@Test
	public void updateApplyingJobTest()
	{
		ApplyingJob applyingJob=applyingJobDAO.getApplyingJob(952);
		applyingJob.setLoginName("passed");
		assertTrue("Problem in updating applied job:", applyingJobDAO.updateApplyingJob(applyingJob));
	}
	
//	@Ignore
	@Test
	public void listApplyingJobTest() 
	{
		List<ApplyingJob> listApplyingJob = applyingJobDAO.listApplyingJob();
		assertTrue("Problem in listing applied Jobs:",listApplyingJob.size()>0);
		for (ApplyingJob applyingJob : listApplyingJob) 
		{
			System.out.println(applyingJob.getApplyJobId() + ": "+applyingJob.getJobId()+": "+applyingJob.getLoginName()+":"+applyingJob.getAppliedDate());
		}
	}
}