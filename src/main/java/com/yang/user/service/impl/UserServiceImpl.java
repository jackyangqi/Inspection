package com.yang.user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.user.entity.User;
import com.yang.user.mapper.UserMapper;
import com.yang.user.service.IUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jack杨
 * @since 2021-09-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public User selectOneByAccount(String account, String password) {
		QueryWrapper<User> wrapper = new QueryWrapper<User>(); 
		wrapper.eq("username", account);
		wrapper.eq("password", password);
		User user = mapper.selectOne(wrapper);
		return user;
	}

}
