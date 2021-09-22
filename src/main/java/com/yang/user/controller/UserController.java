package com.yang.user.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yang.config.redisConfig.RedisUtil;
import com.yang.config.token.TokenUtil;
import com.yang.pojo.BaseParameter;
import com.yang.pojo.ResponseData;
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
	private RedisUtil redisUtil;

	@Autowired
	private IUserService service;

	@RequestMapping("/list")
	@ResponseBody
	public String list(BaseParameter<User> param) {
		IPage<User> iPage = service.findUserByParam(param);
		return JSONObject.toJSONString(iPage);
	}

	@RequestMapping("/page")
	@ResponseBody
	public ModelAndView page(BaseParameter<User> param, Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/user/user/list");
		return view;
	}

	@RequestMapping("/reg")
	@ResponseBody
	public String reg(User user) {
		User temp = service.userNameIsRepeat(user.getUsername());
		if (temp != null) {
			return ResponseData.result(false, "", "", "用户名已存在");
		}
		user.setInsertTime(new Date());
		boolean issave = service.save(user);
		if (issave) {
			return ResponseData.result(true, "", "", "新增用户成功");
		}
		return ResponseData.result(false, "", "", "新增用户失败");
	}

	@RequestMapping("/update")
	@ResponseBody
	public String update(User user) {
		User temp = service.getById(user);
		temp.setMobile(user.getMobile());
		temp.setUsername(user.getUsername());
		temp.setNickname(user.getNickname());
		temp.setUpdateTime(new Date());		
		temp.setEmail(user.getEmail());
		boolean bool =  service.updateById(temp);
		if (bool) {
			return ResponseData.result(true, "", "", "修改用户成功");
		}
		return ResponseData.result(false, "", "", "新增用户失败");
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(String username, String password) {
		User user = service.selectOneByAccount(username, password);
		String currentTimeMillis = String.valueOf(System.currentTimeMillis());
		String token = TokenUtil.sign(user.getUsername(), currentTimeMillis);
		redisUtil.set("token", token);
		return token;
	}

}
