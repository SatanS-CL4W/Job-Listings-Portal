package com.jobListings.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserResume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resumeId;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

	
	@ManyToOne
	@JoinColumn(name = "jobId", referencedColumnName = "jobId")
	private JobList joblist;

	private String fullName;
	private String email;
	private String phone;

	@Column(length = 1000)
	private String skills;

	@Column(length = 1000)
	private String workExperience;

	@Column(length = 1000)
	private String education;

	@Column(columnDefinition = "LONGBLOB")
	private String resume; // Store resume as byte array

	public UserResume() {
		// Default constructor
	}
	
	public UserResume(int resumeId, User user, JobList joblist, String fullName, String email, String phone,
			String skills, String workExperience, String education, String resume) {
		super();
		this.resumeId = resumeId;
		this.user = user;
		this.joblist = joblist;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.skills = skills;
		this.workExperience = workExperience;
		this.education = education;
		this.resume = resume;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JobList getJoblist() {
		return joblist;
	}

	public void setJoblist(JobList joblist) {
		this.joblist = joblist;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

//	@Override
//	public String toString() {
//		return "UserResume [resumeId=" + resumeId + ", user=" + user + ", joblist=" + joblist + ", fullName=" + fullName
//				+ ", email=" + email + ", phone=" + phone + ", skills=" + skills + ", workExperience=" + workExperience
//				+ ", education=" + education + ", resume=" + Arrays.toString(resume) + "]";
//	}


}
