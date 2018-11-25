package com.inter_chat.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inter_chat.Inter_Chat_Backend.dao.JobDAO;
import com.inter_chat.Inter_Chat_Backend.model.ApplyJob;
import com.inter_chat.Inter_Chat_Backend.model.Job;

public class JobDAOTest {

	private static JobDAO jobDAO;
	private Job job;
	private ApplyJob applyJob;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.inter_chat.Inter_Chat_Backend");
		context.refresh();
		jobDAO = (JobDAO) context.getBean("jobDAO");
	}

	@Ignore
	@Test
	public void insertJobTest() throws ParseException {

		job = new Job();
		job.setJobDesignation("");
		job.setCompany("");
		job.setJobDescription("");
		job.setLastDateToApply("");
		job.setSalary(0);
		job.setLocation("");
		;
		assertEquals("Successfully added job into the table", true, jobDAO.addJob(job));

		System.out.println("Success");
	}

	@Ignore
	@Test
	public void updateJobTest() throws ParseException {
		job = jobDAO.getJob(24);
		job.setJobDesignation("");
		job.setCompany("");
		job.setJobDescription("");
		assertEquals("Successfully updated job into the table", true, jobDAO.updateJob(job));
		System.out.println("Success");
	}

	@Ignore
	@Test
	public void testGetJob() {
		job = jobDAO.getJob(0);
		assertEquals("Successfully fetched a job details from the table", "AssociateER", job.getJobDesignation());
		System.out.println("Success");
	}

	@Ignore
	@Test
	public void testGetAllJob() {
		assertTrue("Successfully fetched all jobs from the table", jobDAO.listAllJobs().size() > 0);
		System.out.println("No of jobs:" + jobDAO.listAllJobs().size());
		System.out.println("Success");
	}

	@Ignore
	@Test
	public void testDeleteJob() {
		job = jobDAO.getJob(0);
		assertEquals("Successfully deleted job details from the table", true, jobDAO.deleteJob(job));
		System.out.println("Success");
	}

	@Ignore
	@Test
	public void testApplyJob() {
		applyJob = new ApplyJob();
		job = jobDAO.getJob(0);
		applyJob.setAppliedDate(new Date());
		applyJob.setLoginName("");
		applyJob.setJobId(job.getJobId());
		assertEquals("Successfully applied for job...", true, jobDAO.applyJob(applyJob));
		System.out.println("Success");
	}

	@Ignore
	@Test
	public void listAllAppliedJobs() {
		List<ApplyJob> listAppliedJobs = jobDAO.getAllAppliedJobDetails("");
		assertTrue("Successfully fetched all applied jobs from the table", jobDAO.getAllAppliedJobDetails("User1").size() > 0);
		for (ApplyJob appliedJobs : listAppliedJobs) {
			System.out.println("ApplicationID :" + appliedJobs.getApplicationId());
			System.out.println("JobID :" + appliedJobs.getJobId());
			System.out.println("LoginName :" + appliedJobs.getLoginName());
			System.out.println("Applied Date :" + appliedJobs.getAppliedDate());
		}
		System.out.println("Success");
	}
}