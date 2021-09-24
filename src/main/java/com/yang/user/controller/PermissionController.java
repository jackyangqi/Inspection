package com.yang.user.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.yang.pojo.ResponseData;
import com.yang.user.entity.Permission;
import com.yang.user.entity.Role;
import com.yang.user.entity.User;
import com.yang.user.model.MenuModel;
import com.yang.user.service.IPermissionService;
import com.yang.user.service.IRoleService;
import com.yang.util.TreeUtil;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private IPermissionService permissionService;
	
	@Autowired
	private IRoleService roleService;

	@RequestMapping("/index")
	public ModelAndView index(Model model) {
		User user = new User();
		user.setId(1);
		List<MenuModel> resultList = permissionService.selectMenuModel(user);
		model.addAttribute("menu", resultList);
		ModelAndView view = new ModelAndView("permission/index");
		return view;
	}

	@RequestMapping("/findById")
	@ResponseBody
	public String findById(int id) {
		Permission permission = permissionService.findById(id);
		if (permission != null) {
			return ResponseData.result(true, "", permission, "success");
		}
		return ResponseData.error("error");
	}

	@RequestMapping("/update")
	@ResponseBody
	public String update(Permission permission) {
		
		Permission temp = permissionService.getById(permission);
		if(temp==null) {
			return ResponseData.error("error");
		}
		
		boolean b = permissionService.updateById(permission);
		if(b) {
			return ResponseData.result(true,"修改成功");
		}
		return ResponseData.error("error");
	}

	@RequestMapping("/menuByRole")
	@ResponseBody
	public String menuByRole() {
		Role role = new Role();
		role.setId(1);
		// List<MenuModel>
		List<Permission> list = permissionService.findPermissionByRole(role);
		List<MenuModel> resultList = TreeUtil.createMenu(list);
		System.out.println(JSONObject.toJSONString(resultList));
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("code", 0);
		map.put("data", resultList);
		String res = JSONObject.toJSONString(map);
		// res = res.replace("name", "label");
		// res = res.replace("child", "children");
		return JSONObject.toJSONString(map);
	}
	@RequestMapping("/findPermissionByRoleId")
	@ResponseBody
	public String findPermissionByRoleId(int id) {
		Role role =roleService.getById(id);
		List<Permission> list = permissionService.findPermissionByRole(role);
		Integer [] ids = new Integer[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ids[i] = list.get(i).getId();
		}
//		List<MenuModel> resultList = TreeUtil.createMenu(list);
//		System.out.println(JSONObject.toJSONString(resultList));
//		Map<String, Object> map = new HashedMap<String, Object>();
//		map.put("code", 0);
//		map.put("data", resultList);
//		String res = JSONObject.toJSONString(map);
//		// res = res.replace("name", "label");
//		// res = res.replace("child", "children");
		return JSONObject.toJSONString(ids);
	}
	
	@RequestMapping("/permissionAllTree")
	@ResponseBody
	public String permissionAllTree() {
		List<Permission> list = permissionService.list();
		List<MenuModel> resultList = TreeUtil.createMenu(list);
		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("code", 0);
		map.put("data", resultList);
		return JSONObject.toJSONString(map);
	}
	
	
	
	//TODO 角色权限关联
	@RequestMapping("/rpSave")
	@ResponseBody
	public String rpSave(int rid,int pid) {
		System.out.println(rid);
		System.out.println(pid);
		return "";
	}
	@RequestMapping("/rpDelete")
	@ResponseBody
	public String rpDelete(int rid,int pid) {
		System.out.println(rid);
		System.out.println(pid);
		return "";
	}
	
	
	
	

}
