package com.inter_chat.Inter_Chat_Backend.dao;

import java.util.List;

import com.inter_chat.Inter_Chat_Backend.model.ApplyingJob;
import com.inter_chat.Inter_Chat_Backend.model.Job;

public interface ApplyingJobDAO 
{
	public boolean postApplyingJob(ApplyingJob applyingJob);
	public boolean deleteApplyingJob(ApplyingJob applyingJob);
	public boolean updateApplyingJob(ApplyingJob applyingJob);
	public List<ApplyingJob> listApplyingJob();
	public ApplyingJob getApplyingJob(int applyJobId);
}