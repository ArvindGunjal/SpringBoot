package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.POJO.user;



public interface UserLoginRepo extends JpaRepository<user, Integer> {

	user findByUsername(String username);
	
}
