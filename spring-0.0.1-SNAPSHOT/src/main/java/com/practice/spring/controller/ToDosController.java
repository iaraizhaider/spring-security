package com.practice.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToDosController {
	
	@RequestMapping("list-todos")
//	@ResponseBody
	public String listTodos() {
		return "list-todos";
	}

}
