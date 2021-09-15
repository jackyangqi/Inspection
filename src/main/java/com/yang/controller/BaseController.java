package com.yang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yang.user.entity.User;
import com.yang.user.model.MenuModel;
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
	public ModelAndView index1(Model model) {		
		User user  = new User();
		user.setId(1);
		List<MenuModel> resultList  = permissionService.selectMenuModel(user);
		model.addAttribute("menu", resultList);
		ModelAndView view = new ModelAndView("index");		
		return view;
	}
	@RequestMapping("/admin/home")
	public String home() {
		return "home/console";
	}
	
	@RequestMapping("login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("/addMenu")
	@ResponseBody
	public String addMenu() {
		User user  = new User();
		user.setId(1);
		List<MenuModel> resultList  = permissionService.selectMenuModel(user);
		return JSONObject.toJSONString(resultList);
	}

}
