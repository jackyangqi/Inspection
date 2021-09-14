package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.user.entity.User;
import com.yang.user.service.IPermissionService;

@Controller
public class BaseController {
	
	@Autowired
	public IPermissionService permissionService;

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
	
	@RequestMapping("/addMenu")
	public String addMenu() {
		User user  = new User();
		permissionService.selectMenuModel(user);
		return "";
	}

}
