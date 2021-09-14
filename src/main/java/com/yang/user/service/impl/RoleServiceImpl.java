package com.yang.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.user.entity.Role;
import com.yang.user.entity.User;
import com.yang.user.mapper.RoleMapper;
import com.yang.user.service.IRoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laoyang
 * @since 2021-08-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
	@Autowired
	private RoleMapper mapper;

	@Override
	public List<Role> findRoleByUserId(User user) {
		List<Role> list  = mapper.findRoleByUserId(user);
		return list;
	}

}
