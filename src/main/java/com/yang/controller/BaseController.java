package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/admin/index")
	public String index1() {
		return "index";
	}

	@RequestMapping("login")
	public String login() {
		return "user/login";
	}

}
