package com.example.demo.service;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Collections;

import org.springframework.aop.aspectj.SingletonAspectInstanceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.POJO.user;
import com.example.demo.repository.UserLoginRepo;
import com.example.demo.userdetails.UserDetailsImpl;

@Service("UseLoginServiceImpl")
public class UseLoginServiceImpl implements UserDetailsService {

	@Autowired
	UserLoginRepo repo;
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		user use= repo.findByUsername(username);
		
		if(null==use)
		{
			throw new UsernameNotFoundException("User Not Found");
		}

		
		
		return new UserDetailsImpl(use);
	}






}
