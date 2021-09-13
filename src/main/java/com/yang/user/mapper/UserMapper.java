package com.yang.user.mapper;

import com.yang.user.entity.User;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jack杨
 * @since 2021-09-13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
