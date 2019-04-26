package com.example.demo.securityConfig;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.config.AuthConfigProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.authentication.AuthenticationManager;

import com.example.demo.service.UseLoginServiceImpl;
import com.mysql.cj.protocol.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurity extends WebSecurityConfigurerAdapter {

//	List<UserDetails> usercred=new ArrayList<>();

	
	//user following if want hardcoded username and password
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
	
	
	//user if you want username and password from database
//	@Bean
//	public DaoAuthenticationProvider authProvider()
//	{
//		DaoAuthenticationProvider authenprovider=new DaoAuthenticationProvider();
//		authenprovider.setUserDetailsService(userdetailservice);
//		authenprovider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//
//		
//		return authenprovider;
//		
//		
//	}

	
	
//Following method use to modify login page
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.
//		csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
//		.and()
//		.formLogin()
//		.loginPage("/login").permitAll()
//		.and()
//		.logout().invalidateHttpSession(true)
//		.clearAuthentication(true)
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))		//on which method logout 
//		.logoutSuccessUrl("/logout-success").permitAll();				//what after logout
//		
//		
//		
//		super.configure(http);
//		
//		
//		
//	}
//	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.
		csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated().and()
		.httpBasic()
		.and().logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-success").permitAll();
		
		

	}
	
	
	
}
