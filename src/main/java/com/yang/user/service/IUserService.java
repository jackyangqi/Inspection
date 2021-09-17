package com.yang.user.service;

import com.yang.pojo.BaseParameter;
import com.yang.user.entity.User;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jack杨
 * @since 2021-09-13
 */
public interface IUserService extends IService<User> {

	public User selectOneByAccount(String account, String password);
	
	
	public IPage<User> findUserByParam(BaseParameter<User> param);

}
