package com.yang.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.user.entity.Role;
import com.yang.user.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author laoyang
 * @since 2021-08-05
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	public List<Role> findRoleByUserId(User user);
}
