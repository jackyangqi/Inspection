package com.yang.user.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.user.entity.Permission;
import com.yang.user.entity.User;
import com.yang.user.model.MenuModel;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author laoyang
 * @since 2021-08-05
 */
public interface IPermissionService extends IService<Permission> {

	public List<MenuModel> selectMenuModel(User user);
	
	public List<Permission> findPermissionByUser(User user);

}
