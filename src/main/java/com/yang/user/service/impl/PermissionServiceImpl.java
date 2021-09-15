package com.yang.user.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.user.entity.Permission;
import com.yang.user.entity.Role;
import com.yang.user.entity.User;
import com.yang.user.mapper.PermissionMapper;
import com.yang.user.mapper.RoleMapper;
import com.yang.user.model.MenuModel;
import com.yang.user.service.IPermissionService;
import com.yang.util.TreeUtil;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author laoyang
 * @since 2021-08-05
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<MenuModel> selectMenuModel(User user) {
		List<Role> roleList = roleMapper.findRoleByUserId(user);
		List<Integer> list = new ArrayList<Integer>();
		for (Iterator iterator = roleList.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			list.add(role.getId());
		}
		List<Permission> permissionList = permissionMapper.findPermissionByRole(list);
		List<MenuModel> resultList = TreeUtil.createMenu(permissionList);
		return resultList;
	}

	@Override
	public List<Permission> findPermissionByUser(User user) {
		List<Role> roleList = roleMapper.findRoleByUserId(user);
		List<Integer> list = new ArrayList<Integer>();
		for (Iterator iterator = roleList.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			list.add(role.getId());
		}
		List<Permission> permissionList = permissionMapper.findPermissionByRole(list);
		return permissionList;
	}

}