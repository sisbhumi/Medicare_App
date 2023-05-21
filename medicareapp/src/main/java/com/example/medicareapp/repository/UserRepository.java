package com.example.medicareapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicareapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

	User findByUsername(String name);

	User findByUsernameAndPassword(String username, String password);
	
	
}