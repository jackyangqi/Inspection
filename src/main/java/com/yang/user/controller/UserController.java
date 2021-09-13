package com.yang.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/list")
	@ResponseBody
	public String list() {

		return "[123]";
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(String username, String password) {

		return "";
	}

}
