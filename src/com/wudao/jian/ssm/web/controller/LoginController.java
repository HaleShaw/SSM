package com.wudao.jian.ssm.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(String username,String password) {
		/*获取当前用户*/
		Subject currentUser = SecurityUtils.getSubject();

		/*若用户没有认证，则进入认证*/
		if (!currentUser.isAuthenticated()) {
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
				currentUser.login(token);
			} catch (AuthenticationException e) {
				/*认证失败时，跳转到登录页面*/
				e.printStackTrace();
				return "forward:/login.jsp";
			}
		}

		return "forward:/main.jsp";
	}
}
