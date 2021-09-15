
package com.yang.util;

import java.util.ArrayList;
import java.util.List;
import com.yang.user.entity.Permission;
import com.yang.user.model.MenuModel;

/**
 * 类名称：MenuTreeUtil 类描述：递归构造树型结构
 */
public class TreeUtil {

	public static List<MenuModel> createMenu(List<Permission> permissions) {

		List<MenuModel> resultList = new ArrayList<MenuModel>();

		for (Permission permission : permissions) {
			if (permission.getPid() == 0) {
				MenuModel m = getMenuModel(permission, permissions);
				resultList.add(m);
			}
		}
		return resultList;
	}

	// 构建 XTreeGrid（实体对象）
	public static MenuModel getMenuModel(Permission ps, List<Permission> permissions) {
		MenuModel m = new MenuModel();
		m.setId(ps.getId());
		m.setName(ps.getName());
		m.setPage(ps.getPage());
		m.setIcon(ps.getIcon());
		m.setType(ps.getIstype());
		m.setPid(ps.getPid());
		m.setChild(getChild(ps.getId(), permissions));
		return m;
	}

	/**
	 * 递归查找子菜单
	 */
	public static List<MenuModel> getChild(int id, List<Permission> permissions) {
		List<MenuModel> childList = new ArrayList<>();
		for (Permission permission : permissions) {
			if (permission.getPid() == id) {
				MenuModel m = getMenuModel(permission, permissions);
				childList.add(m);
			}
		}
		return childList;
	}

}
