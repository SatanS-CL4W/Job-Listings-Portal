package com.jobListings.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank(message = "Name Field cannot be empty !!")
	@Size(min = 5, max = 20, message = "Name should not be less than 5 and more than 20")
	private String name;
	
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@gmail.com", message = "Your Email suffix should be @gmail.com")
	@Column(unique = true)
	private String email;
	
	private String password;
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserResume> jobLists = new ArrayList<>();
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String name, String email, String password, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public List<UserResume> getJobLists() {
		return jobLists;
	}
	public void setJobLists(List<UserResume> jobLists) {
		this.jobLists = jobLists;
	}
	
	
	
	
}
