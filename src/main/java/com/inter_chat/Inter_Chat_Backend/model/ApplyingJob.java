package com.inter_chat.Inter_Chat_Backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="applyJobId",sequenceName="applyJob")
public class ApplyingJob 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="applyJobId")
	int applyJobId;
	int jobId;
	String loginName;
	public int getApplyJobId() {
		return applyJobId;
	}
	public void setApplyJobId(int applyJobId) {
		this.applyJobId = applyJobId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	Date appliedDate;
}
