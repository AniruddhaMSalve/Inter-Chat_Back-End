package com.inter_chat.Inter_Chat_Backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
@SequenceGenerator(name = "jobidseq", sequenceName = "job_id_sequence", allocationSize = 1)
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobidseq")
	@Column(nullable = false)
	private int jobId;

	@Column(nullable = false)
	private String jobDesignation;

	@Column(nullable = false)
	String company;

	@Column(nullable = false)
	private int salary;

	@Column(nullable = false)
	private String location;

	@Column(nullable = false)
	private String jobDescription;

	@Column(nullable = false)
	private String lastDateToApply;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobDesignation() {
		return jobDesignation;
	}

	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getLastDateToApply() {
		return lastDateToApply;
	}

	public void setLastDateToApply(String lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}
}