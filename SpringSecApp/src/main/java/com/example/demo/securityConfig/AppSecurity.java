package com.example.demo.securityConfig;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.config.AuthConfigProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.authentication.AuthenticationManager;

import com.example.demo.service.UseLoginServiceImpl;
import com.mysql.cj.protocol.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

//	List<UserDetails> usercred=new ArrayList<>();

	
	//user following if want hardcoded Db
//	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService()
//	{
//		List<UserDetails> usercred=new ArrayList<>();
//		usercred.add(User.withDefaultPasswordEncoder().username("arvind").password("arvind").roles("Manager").build());
//		
//		return new InMemoryUserDetailsManager(usercred);
//		
//	}
//	
	@Autowired
	private UserDetailsService userdetailservice;
	
	
	@Bean
	public DaoAuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider authenprovider=new DaoAuthenticationProvider();
		authenprovider.setUserDetailsService(userdetailservice);
		authenprovider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

		
		return authenprovider;
		
		
	}
	
	
}
