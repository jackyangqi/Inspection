package com.yang.user.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yang.pojo.BaseParameter;
import com.yang.user.entity.Role;
import com.yang.user.entity.User;
import com.yang.user.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService service;

	@RequestMapping("/list")
	@ResponseBody
	public String list(BaseParameter<Role> param) {
		service.list();
		return "";
	}
	@RequestMapping("/treeList")
	@ResponseBody
	public String treeList(User user) {		
		List<Role> list =  service.findRoleByUserId(user);
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("code", 0);
		map.put("data", list);
		return JSONObject.toJSONString(map);
	}
	
	

}
