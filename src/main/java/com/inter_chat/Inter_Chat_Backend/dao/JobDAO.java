package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.ApplyJob;
import com.inter_chat.Inter_Chat_Backend.model.Job;

public interface JobDAO {
	public boolean addJob(Job job);

	public boolean deleteJob(Job job);

	public boolean updateJob(Job job);

	public Job getJob(int jobId);

	public List<Job> listAllJobs();

	public boolean applyJob(ApplyJob applyJob);

	public List<ApplyJob> getAllAppliedJobDetails(String loginName);
}