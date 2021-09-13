package com.yang.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.config.token.TokenUtil;
import com.yang.user.entity.User;
import com.yang.user.service.IUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jack杨
 * @since 2021-09-13
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/list")
	@ResponseBody
	public String list() {

		return "[123]";
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(String username, String password) {
		User user = service.selectOneByAccount(username, password);
		String currentTimeMillis = String.valueOf(System.currentTimeMillis());
		String token = TokenUtil.sign(user.getUsername(), currentTimeMillis);
		return token;
	}

}
