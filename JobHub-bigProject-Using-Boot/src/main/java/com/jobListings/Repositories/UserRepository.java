package com.jobListings.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobListings.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
