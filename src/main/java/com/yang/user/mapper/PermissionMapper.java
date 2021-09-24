package com.yang.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.user.entity.Permission;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author laoyang
 * @since 2021-08-05
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
	public List<Permission> findPermissionByRole(List<Integer> list);
	public Permission findById(int id);
	
	public boolean rpSave(Map<String, Integer> map);
}
