package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class IndexController {

	@RequestMapping("/index")
	public String display()
	{
		return "welcome";
	}

	@RequestMapping("/")
	public String indexpage()
	{
		return "welcome";
	}

	@RequestMapping("/login")
	public String login()
	{
		return "Login";
	}
	
	@RequestMapping("logout-success")
	public String logout()
	{
		return "Logout";
	}
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal)
	{
		return principal;
	}
	
}
