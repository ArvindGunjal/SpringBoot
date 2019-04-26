package com.example.demo.userdetails;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.POJO.user;

public class UserDetailsImpl implements UserDetails{

	
	@Autowired
	user use; 
	
	
	public UserDetailsImpl(user use) {
		this.use=use;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("manager"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return use.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return use.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
