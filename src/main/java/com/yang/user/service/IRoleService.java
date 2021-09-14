package com.yang.user.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.user.entity.Role;
import com.yang.user.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laoyang
 * @since 2021-08-05
 */
public interface IRoleService extends IService<Role> {
	
	public List<Role> findRoleByUserId(User user);

}
