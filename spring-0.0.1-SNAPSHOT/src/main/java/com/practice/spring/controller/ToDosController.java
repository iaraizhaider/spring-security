package com.practice.spring.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDosController {
	
	@RequestMapping("list-todos")
	public String listTodos() {
		System.out.println("Logged in user is: " + getLoggedInUser());
		return "list-todos";
	}

	public String getLoggedInUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
