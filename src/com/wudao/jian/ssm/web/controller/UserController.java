package com.wudao.jian.ssm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wudao.jian.ssm.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/index")
	public String index(String username,String password) {

		return "index";
	}
}
