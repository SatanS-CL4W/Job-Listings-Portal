package com.jobListings.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "JOB LIST")
public class JobList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	private String title;
	private String location;
	private String description;
	
	private Date postedDate;
	
	@ManyToOne
	private User user;
	
	public JobList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobList(int jobId, String title, String location, String description, Date postedDate) {
		super();
		this.jobId = jobId;
		this.title = title;
		this.location = location;
		this.description = description;
		this.postedDate = postedDate;
	}


	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
